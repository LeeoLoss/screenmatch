// Declara que esta classe pertence ao pacote "screenmatch"
package screenmatch;

// Importa a interface Classificavel do pacote "calculos"
// Isso significa que Episodio precisa implementar o método getClassificacao()
import calculos.Classificavel;

// Define a classe pública "Episodio", que representa um episódio de uma série
// e implementa a interface Classificavel
public class Episodio implements Classificavel {

    // Atributo que representa o número do episódio na temporada
    private int numero;

    // Nome do episódio
    private String nome;

    // Referência para a série à qual o episódio pertence
    private Serie serie;

    // Número total de visualizações que o episódio teve
    private int totalVisualizacoes;

    // Getter para o total de visualizações
    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    // Setter para o total de visualizações
    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    // Getter para o número do episódio
    public int getNumero() {
        return numero;
    }

    // Setter para o número do episódio
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Getter para o nome do episódio
    public String getNome() {
        return nome;
    }

    // Setter para o nome do episódio
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para a série associada a este episódio
    public Serie getSerie() {
        return serie;
    }

    // Setter para associar uma série a este episódio
    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    // Implementação do método da interface Classificavel
    // A classificação é baseada na quantidade de visualizações
    @Override
    public int getClassificacao() {
        // Se teve mais de 100 visualizações, retorna classificação 4 (bem avaliado)
        if (totalVisualizacoes > 100) {
            return 4;
        } else {
            // Caso contrário, retorna 2 (mediano)
            return 2;
        }
    }
}
