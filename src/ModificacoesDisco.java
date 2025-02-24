import java.util.ArrayList;
import java.util.List;

public class ModificacoesDisco implements IModificacoesDisco {
    private final List<Disco> discos;
    private final List<Artista> artistas;

    public ModificacoesDisco() {
        this.discos = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }

    @Override
    public boolean cadastrarDisco(String titulo, int anoLancamento, String[] faixas, Artista artista) {
        if (titulo == null || titulo.isEmpty() || anoLancamento <= 0 || faixas == null || faixas.length == 0 || artista == null) {
            System.out.println("Erro: Dados inválidos para o disco.");
            return false;
        }
        Disco novoDisco = new Disco(titulo, anoLancamento, faixas, artista);
        discos.add(novoDisco);
        System.out.println("Disco cadastrado com sucesso: " + novoDisco);
        return true;
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
                System.out.println("Artista: " + (disco.getArtista() != null ? disco.getArtista().getNome() : "Nenhum"));
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
