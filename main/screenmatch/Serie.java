// Declara que esta classe pertence ao pacote "screenmatch"
package screenmatch;

// Declara a classe pública "Serie", que herda da classe "Titulo"
// Isso significa que Serie herda atributos e métodos comuns a todos os títulos, como nome, ano e avaliações
public class Serie extends Titulo {

    // Número total de temporadas da série
    private int temporadas;

    // Indica se a série ainda está em produção (ativa)
    private boolean ativa;

    // Número médio de episódios por temporada
    private int episodiosPorTemporada;

    // Duração média de cada episódio, em minutos
    private int minutosPorEpisodio;

    // Construtor da classe Serie, que recebe o nome e o ano de lançamento
    // e passa esses dados para o construtor da superclasse Titulo
    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    // Getter para o número de temporadas
    public int getTemporadas() {
        return temporadas;
    }

    // Setter para o número de temporadas
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // Getter para o status "ativa" da série
    public boolean isAtiva() {
        return ativa;
    }

    // Setter para o status "ativa" da série
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    // Getter para o número de episódios por temporada
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    // Setter para o número de episódios por temporada
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    // Getter para a duração de cada episódio, em minutos
    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    // Setter para a duração de cada episódio
    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    // Sobrescreve o método da classe Titulo
    // Retorna a duração total da série (temporadas * episódios por temporada * minutos por episódio)
    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    // Sobrescreve o método toString() da classe Object
    // Retorna uma representação textual da série com nome e ano de lançamento
    @Override
    public String toString() {
        return "Série: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
