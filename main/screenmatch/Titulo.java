// Declara que esta classe pertence ao pacote "screenmatch"
package screenmatch;

// Importa a exceção personalizada usada no construtor secundário
import excecao.ErroDeConversaoDeAnoException;

// A classe Titulo representa qualquer tipo de mídia (filme, série, etc.)
// Ela implementa a interface Comparable para permitir ordenação por nome
public class Titulo implements Comparable<Titulo> {

    // Atributos principais da classe
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    // Construtor principal: recebe nome e ano
    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    // Construtor alternativo: recebe dados vindos de um objeto TituloOmdb (API externa)
    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title(); // Pega o título

        // Verifica se o campo "year" tem mais de 4 caracteres (ex: "2023–2024")
        if (meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não foi possível a conversão de ano por conter mais de 4 caracteres.");
        }

        // Converte o ano de String para inteiro
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());

        // Converte a duração de "123 min" para inteiro 123
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().replace(" min", ""));
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    // Exibe informações básicas sobre o título
    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    // Adiciona uma avaliação ao título, acumulando a soma e o número total
    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    // Retorna a média das avaliações recebidas
    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    // Implementação da interface Comparable para permitir ordenação por nome (alfabética)
    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    // Retorna uma representação textual do objeto Titulo
    @Override
    public String toString() {
        return "Titulo [nome= " + nome + ", anoDeLancamento = " + anoDeLancamento + ", duração = "
                + duracaoEmMinutos + "]";
    }
}
