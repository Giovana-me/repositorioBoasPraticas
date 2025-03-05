package lojadisco.service;

import java.util.ArrayList;
import java.util.List;

import lojadisco.model.Artista;
import lojadisco.model.Disco;

public class GerenciamentoDisco implements IGerenciamentoDisco {
    private final List<Disco> discos;

    public GerenciamentoDisco() {
        this.discos = new ArrayList<>();
    }

    public GerenciamentoDisco(List<Disco> discos) {
        this.discos = discos;
    }

    @Override
    public boolean associarArtista(String tituloDisco, Artista artista) {
        for (Disco disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(tituloDisco)) {
                disco.setArtista(artista);
                System.out.println("Artista associado ao disco com sucesso: " + disco);
                return true;
            }
        }
        System.out.println("Erro: Disco não encontrado.");
        return false;
    }

    @Override
    public boolean removerDisco(String titulo) {
        for (Disco disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                discos.remove(disco);
                System.out.println("Disco removido com sucesso: " + titulo);
                return true;
            }
        }
        System.out.println("Erro: Disco não encontrado.");
        return false;
    }

    @Override
    public boolean editarDisco(String titulo, int novoAnoLancamento, String[] novasFaixas, Artista novoArtista) {
        for (Disco disco : discos) {
            if (disco.getTitulo().equalsIgnoreCase(titulo)) {
                disco.setAnoLancamento(novoAnoLancamento);
                disco.setFaixas(novasFaixas);
                disco.setArtista(novoArtista);
                System.out.println("Disco atualizado com sucesso: " + disco);
                return true;
            }
        }
        System.out.println("Erro: Disco não encontrado.");
        return false;
    }
}
