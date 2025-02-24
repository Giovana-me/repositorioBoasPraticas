public interface IModificacoesDisco {
    boolean cadastrarDisco(String titulo, int anoLancamento, String[] faixas, Artista artista);
    boolean associarArtista(String titulo, Artista artista);
    boolean cadastrarArtista(String nome, String genero);
    void listarDiscos();
    void mostrarDetalhesDiscos();
    void listarArtistas();
    boolean removerDisco(String titulo);
    boolean editarDisco(String titulo, int novoAnoLancamento, String[] novasFaixas, Artista novoArtista);
}
