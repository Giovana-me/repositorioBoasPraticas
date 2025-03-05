package lojadisco.service;

import java.util.ArrayList;
import java.util.List;

import lojadisco.model.Artista;
import lojadisco.model.Disco;

public class CadastroDisco implements ICadastroDisco {
    private final List<Disco> discos;
    private final List<Artista> artistas;

    public CadastroDisco() {
        this.discos = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }

    public CadastroDisco(List<Disco> discos, List<Artista> artistas) {
        this.discos = discos;
        this.artistas = artistas;
    }

    @Override
    public boolean cadastrarDisco(String titulo, int anoLancamento, String[] faixas, Artista artista) {
        if (titulo == null || titulo.isEmpty() || anoLancamento <= 0 || faixas == null || faixas.length == 0
                || artista == null) {
            System.out.println("Erro: Dados inválidos para o disco.");
            return false;
        }
        Disco novoDisco = new Disco(titulo, anoLancamento, faixas, artista);
        discos.add(novoDisco);
        System.out.println("Disco cadastrado com sucesso: " + novoDisco);
        return true;
    }

    @Override
    public boolean cadastrarArtista(String nome, String genero) {
        if (nome == null || nome.isEmpty() || genero == null || genero.isEmpty()) {
            System.out.println("Erro: Dados inválidos para o artista.");
            return false;
        }
        Artista novoArtista = new Artista(nome, genero);
        artistas.add(novoArtista);
        System.out.println("Artista cadastrado com sucesso: " + novoArtista);
        return true;
    }
}
