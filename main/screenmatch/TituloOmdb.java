// Declara que esta classe pertence ao pacote "screenmatch"
package screenmatch;

// Declara a classe "TituloOmdb" como uma record class
// A record class é uma maneira compacta de criar classes imutáveis para dados simples
// Ela cria automaticamente os construtores, getters, equals(), hashCode(), toString() e outros métodos úteis
public record TituloOmdb(String title, String year, String runtime) {
    // Não é necessário implementar nada aqui, pois o Java faz isso automaticamente para você.
    // Isso significa que a classe já tem:
    // - Construtor: TituloOmdb(String title, String year, String runtime)
    // - Getters: title(), year(), runtime()
    // - Método toString() automaticamente gerado.
}
