// Declara que esta classe pertence ao pacote "calculos"
package calculos;

// Importa a classe Titulo do pacote "screenmatch"
// A classe Titulo provavelmente é uma superclasse para diferentes tipos de mídia, como Filme e Série
import screenmatch.Titulo;

// Declara a classe pública "CalculadoraDeTempo"
public class CalculadoraDeTempo {

    // Atributo privado que acumula o tempo total (em minutos) dos títulos incluídos
    private int tempoTotal = 0;

    // Método público (getter) que retorna o tempo total acumulado
    public int getTempoTotal() {
        return this.tempoTotal;
    }

    // Método público que recebe um objeto do tipo Titulo (ou subclasses)
    // e adiciona sua duração ao tempo total
    public void inclui(Titulo titulo) {
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
