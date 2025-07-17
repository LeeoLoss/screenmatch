// Declara que esta classe pertence ao pacote "calculos"
package calculos;

// Declara a classe pública "Recomendacao"
public class Recomendacao {

    // Atributo privado que poderia ser usado para armazenar uma recomendação textual (ainda não utilizado)
    private String recomendacao;

    // Método público chamado "filtra" que recebe um objeto do tipo "Classificavel"
    // Esse método analisa a classificação do objeto e imprime uma mensagem de recomendação personalizada
    public void filtra(Classificavel classificavel) {

        // Verifica se a classificação é 4 ou maior
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os mais assistidos do momento.");
        
        // Se não, verifica se é pelo menos 2
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Bem avaliado no momento.");
        
        // Se for menor que 2, sugere adicionar à lista para ver mais tarde
        } else {
            System.out.println("Que tal incluir este título em sua lista para incluir depois?");
        }
    }
}
  
