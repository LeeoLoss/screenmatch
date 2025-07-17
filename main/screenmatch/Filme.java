// Declara que esta classe pertence ao pacote "screenmatch"
package screenmatch;

// Importa a interface Classificavel do pacote "calculos"
// Isso permite que a classe Filme seja usada em contextos onde uma classificação é necessária
import calculos.Classificavel;

// Declara a classe pública "Filme" que herda da classe "Titulo"
// e implementa a interface "Classificavel"
public class Filme extends Titulo implements Classificavel {

    // Atributo privado que armazena o nome do diretor do filme
    private String diretor;

    // Construtor da classe Filme que chama o construtor da superclasse Titulo
    // Recebe o nome e o ano de lançamento do filme como parâmetros
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    // Getter para o nome do diretor
    public String getDiretor() {
        return diretor;
    }

    // Setter para o nome do diretor
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    // Implementação do método exigido pela interface Classificavel
    // A classificação é baseada na média de avaliações, dividida por 2
    // (presumivelmente a média vai de 0 a 10, então o retorno vai de 0 a 5)
    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    // Sobrescreve o método toString() da classe Object
    // Retorna uma representação textual do filme, com nome e ano
    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
