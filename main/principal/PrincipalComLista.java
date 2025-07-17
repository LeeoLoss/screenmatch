package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import screenmatch.Filme;
import screenmatch.Serie;
import screenmatch.Titulo;

public class PrincipalComListas {
    public static void main(String[] args) {
        // Criação de objetos Filme e Serie com avaliações
        Filme filmeUm = new Filme("Oppenheimer", 2023);
        filmeUm.avalia(7);
        Filme filmeDois = new Filme("Coringa", 2019);
        filmeDois.avalia(8);
        var filmeTres = new Filme("Interstellar", 2014);
        filmeTres.avalia(9);
        Serie theLastOfUs = new Serie("The Last of Us", 2023);

        // Lista de títulos assistidos usando LinkedList (implementação de List)
        List<Titulo> listaDeAssistidos = new LinkedList<>();
        listaDeAssistidos.add(filmeUm);
        listaDeAssistidos.add(filmeDois);
        listaDeAssistidos.add(filmeTres);
        listaDeAssistidos.add(theLastOfUs);

        // Percorre a lista de assistidos e imprime a classificação dos filmes com classificação > 2
        for (Titulo item : listaDeAssistidos) {
            // Verifica se o item é um Filme e se a classificação é maior que 2
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        // Cria uma lista de artistas como Strings
        List<String> listaDeArtista = new ArrayList<>();
        listaDeArtista.add("Leonardo DiCaprio");
        listaDeArtista.add("Meryl Streep");
        listaDeArtista.add("Denzel Washington");

        // Imprime as listas antes da ordenação
        System.out.println(listaDeAssistidos);
        System.out.println(listaDeArtista);

        // Ordena a lista de artistas em ordem alfabética (natural para String)
        Collections.sort(listaDeArtista);
        // Ordena a lista de títulos (usa o compareTo implementado na classe Titulo, provavelmente pelo nome)
        Collections.sort(listaDeAssistidos);

        System.out.println("Lista de artistas ordenada em ordem alfabética: " + listaDeArtista);
        System.out.println("Lista de títulos ordenada em ordem alfabética: " + listaDeAssistidos);

        // Ordena a lista de títulos por ano de lançamento usando Comparator
        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));

        System.out.println("Lista de títulos ordenada por ano de lançamento: " + listaDeAssistidos);
    }
}
