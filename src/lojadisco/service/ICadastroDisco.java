package lojadisco.service;

import lojadisco.model.Artista;

public interface ICadastroDisco {
    boolean cadastrarDisco(String titulo, int anoLancamento, String[] faixas, Artista artista);

    boolean cadastrarArtista(String nome, String genero);
}