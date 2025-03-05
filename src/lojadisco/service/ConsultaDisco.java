package lojadisco.service;

import java.util.ArrayList;
import java.util.List;

import lojadisco.model.Artista;
import lojadisco.model.Disco;

public class ConsultaDisco implements IConsultaDisco {
    private final List<Disco> discos;
    private final List<Artista> artistas;

    public ConsultaDisco() {
        this.discos = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }

    public ConsultaDisco(List<Disco> discos, List<Artista> artistas) {
        this.discos = discos;
        this.artistas = artistas;
    }

    @Override
    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            discos.forEach(System.out::println);
        }
    }

    @Override
    public void mostrarDetalhesDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (Disco disco : discos) {
                System.out.println("Título: " + disco.getTitulo());
                System.out.println("Ano: " + disco.getAnoLancamento());
                System.out
                        .println("Artista: " + (disco.getArtista() != null ? disco.getArtista().getNome() : "Nenhum"));
                System.out.println("Faixas: ");
                for (String faixa : disco.getFaixas()) {
                    System.out.println(" - " + faixa);
                }
                System.out.println("-------------------");
            }
        }
    }

    @Override
    public void listarArtistas() {
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
        } else {
            artistas.forEach(artista -> System.out.println(artista.getNome() + " - " + artista.getGenero()));
        }
    }
}
