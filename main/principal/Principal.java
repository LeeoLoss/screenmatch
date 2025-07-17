package principal;

import java.util.ArrayList;
import java.util.List;

import calculos.CalculadoraDeTempo;
import calculos.Recomendacao;
import screenmatch.Episodio;
import screenmatch.Filme;
import screenmatch.Serie;

public class Principal {

    public static void main(String[] args) {
        // Criando um objeto Filme chamado "Oppenheimer" lançado em 2023
        Filme filmeUm = new Filme("Oppenheimer", 2023);
        // Definindo a duração do filme em minutos
        filmeUm.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + filmeUm.getDuracaoEmMinutos());
        
        // Exibindo informações básicas do filme
        filmeUm.exibeFichaTecnica();
        // Avaliando o filme com diferentes notas
        filmeUm.avalia(8);
        filmeUm.avalia(5);
        filmeUm.avalia(10);
        
        // Criando um objeto Serie chamado "The Last of Us" lançado em 2023
        Serie theLastOfUs = new Serie("The Last of Us", 2023);
        // Exibindo informações básicas da série
        theLastOfUs.exibeFichaTecnica();
        // Configurando o número de temporadas, episódios por temporada e duração de cada episódio
        theLastOfUs.setTemporadas(6);
        theLastOfUs.setEpisodiosPorTemporada(20);
        theLastOfUs.setMinutosPorEpisodio(50);
        // Calculando e exibindo a duração total para assistir toda a série
        System.out.println("Duração para completar a série: " + theLastOfUs.getDuracaoEmMinutos());
        
        // Criando outro filme "Coringa" lançado em 2019 e definindo sua duração
        Filme filmeDois = new Filme("Coringa", 2019);
        filmeDois.setDuracaoEmMinutos(122);
        
        // Criando a calculadora de tempo para somar durações de títulos
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        // Incluindo filmes e série na calculadora para somar suas durações
        calculadora.inclui(filmeUm);
        calculadora.inclui(filmeDois);
        calculadora.inclui(theLastOfUs);
        // Exibindo o tempo total acumulado dos títulos adicionados
        System.out.println(calculadora.getTempoTotal());
        
        // Criando um filtro de recomendação baseado na classificação
        Recomendacao filtro = new Recomendacao();
        // Aplicando o filtro no filme "Oppenheimer"
        filtro.filtra(filmeUm);
        
        // Criando um episódio da série "The Last of Us"
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(theLastOfUs);
        episodio.setTotalVisualizacoes(300);
        // Aplicando o filtro de recomendação para o episódio
        filtro.filtra(episodio);
        
        // Criando um terceiro filme "Interstellar" lançado em 2014 e avaliando-o
        var filmeTres = new Filme("Interstellar", 2014);
        filmeTres.setDuracaoEmMinutos(169);
        filmeTres.avalia(9);
        
        // Criando uma lista de filmes para armazenar os objetos filmes
        List<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeUm);
        listaDeFilmes.add(filmeDois);
        listaDeFilmes.add(filmeTres);
        
        // Exibindo informações da lista
        System.out.println("Tamanho da lista: " + listaDeFilmes.size()); // Quantidade de filmes na lista
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome()); // Nome do primeiro filme
        System.out.println(listaDeFilmes); // Lista completa usando o método toString de cada objeto Filme
        System.out.println("toString do filme: " + listaDeFilmes.get(0).toString()); // Mostrando o toString do primeiro filme
    }
}
