package principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import excecao.ErroDeConversaoDeAnoException;
import screenmatch.Titulo;
import screenmatch.TituloOmdb;

public class PrincipalComBusca {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Scanner para ler a entrada do usuário pelo console
		Scanner leitura = new Scanner(System.in);
		String busca = ""; // Variável para armazenar o termo de busca digitado
		List<Titulo> titulos = new ArrayList<>(); // Lista para armazenar os títulos retornados da busca

		// Configurando o Gson para serialização/deserialização JSON com padrões de
		// nomenclatura e formatação
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // Para mapear
																								// corretamente os nomes
																								// dos campos JSON que
																								// começam com
																								// maiúsculas
				.setPrettyPrinting() // Para gerar JSON formatado (legível)
				.create();

		// Loop principal para realizar múltiplas buscas até o usuário digitar "sair"
		while (true) {
			System.out.println("Digite um item para busca (ou 'sair' para encerrar): ");
			busca = leitura.nextLine();

			// Se o usuário digitar "sair", interrompe o loop e encerra o programa
			if (busca.equalsIgnoreCase("sair")) {
				break;
			}

			// Monta a URL da API OMDb, substituindo espaços por '+' e incluindo a chave da
			// API
			String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=270ce4b5";
			try {
				// Cria o cliente HTTP e prepara a requisição para a URL da API
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

				// Envia a requisição e recebe a resposta como string JSON
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

				String json = response.body();
				System.out.println("JSON recebido da API:\n" + json);

				// Converte o JSON recebido em um objeto TituloOmdb usando Gson
				TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
				System.out.println("Objeto TituloOmdb criado: " + meuTituloOmdb);

				// Converte o TituloOmdb em um objeto Titulo da sua aplicação (tratando os dados
				// conforme necessário)
				Titulo meuTitulo = new Titulo(meuTituloOmdb);
				System.out.println("Título convertido com sucesso: " + meuTitulo);

				// Adiciona o título convertido na lista
				titulos.add(meuTitulo);

			} catch (NumberFormatException e) {
				// Captura erros caso a conversão dos campos numéricos falhe (ex: ano inválido)
				System.out.println("Erro ao converter número: " + e.getMessage());
			} catch (IllegalArgumentException e) {
				// Captura erros de argumento inválido, como URL mal formada
				System.out.println("Erro de argumento na busca, verifique o endereço.");
			} catch (ErroDeConversaoDeAnoException e) {
				// Captura a exceção personalizada ao converter o ano (ex: ano com mais de 4
				// caracteres)
				System.out.println("Erro ao converter o ano: " + e.getMessage());
			}
		}

		// Após sair do loop, exibe todos os títulos que foram buscados e adicionados
		System.out.println("Títulos a serem salvos: " + titulos);

		// Se a lista de títulos não estiver vazia, salva em um arquivo JSON
		if (!titulos.isEmpty()) {
			FileWriter escrita = new FileWriter("filmes.json");
			escrita.write(gson.toJson(titulos)); // Serializa a lista para JSON e escreve no arquivo
			escrita.close();
			System.out.println("Arquivo filmes.json salvo com sucesso!");
		} else {
			// Caso a lista esteja vazia, informa que nenhum arquivo será gerado
			System.out.println("Nenhum título foi adicionado. Nenhum arquivo gerado.");
		}

		// Fecha o scanner para liberar o recurso
		leitura.close();
		System.out.println("Programa finalizado corretamente.");
	}
}
