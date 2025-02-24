public class Disco {
    private String titulo;
    private int anoLancamento;
    private String[] faixas;
    private Artista artista;

    public Disco(String titulo, int anoLancamento, String[] faixas, Artista artista) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.faixas = faixas;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String[] getFaixas() {
        return faixas;
    }

    public void setFaixas(String[] faixas) {
        this.faixas = faixas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Disco: " + titulo + ", Ano: " + anoLancamento + ", Artista: " + (artista != null ? artista.getNome() : "N/A");
    }
}
