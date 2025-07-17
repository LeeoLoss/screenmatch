// Declara que esta classe pertence ao pacote "excecao"
package excecao;

// Define uma classe de exceção personalizada que estende RuntimeException,
// o que significa que é uma exceção do tipo "não verificada" (unchecked).
public class ErroDeConversaoDeAnoException extends RuntimeException {

    // Atributo privado que armazena a mensagem de erro personalizada
    private String mensagem;

    // Construtor da exceção que recebe uma mensagem como argumento
    // e armazena essa mensagem no atributo local
    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    // Sobrescreve o método getMessage() da classe Exception
    // para retornar a mensagem personalizada armazenada
    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
