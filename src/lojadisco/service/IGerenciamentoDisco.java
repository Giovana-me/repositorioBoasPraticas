package lojadisco.service;

import lojadisco.model.Artista;

public interface IGerenciamentoDisco {
    boolean editarDisco(String titulo, int novoAnoLancamento, String[] novasFaixas, Artista novoArtista);

    boolean removerDisco(String titulo);

    boolean associarArtista(String titulo, Artista artista);
}
