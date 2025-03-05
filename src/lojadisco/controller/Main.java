package lojadisco.controller;

import java.util.Scanner;

import lojadisco.model.Artista;
import lojadisco.service.ICadastroDisco;
import lojadisco.service.IConsultaDisco;
import lojadisco.service.IGerenciamentoDisco;
import lojadisco.service.CadastroDisco;
import lojadisco.service.ConsultaDisco;
import lojadisco.service.GerenciamentoDisco;

public class Main {
    public static void main(String[] args) {
        ICadastroDisco cadastroDisco = new CadastroDisco();
        IConsultaDisco consultaDisco = new ConsultaDisco();
        IGerenciamentoDisco gerenciamentoDisco = new GerenciamentoDisco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Cadastrar Disco");
            System.out.println("2. Associar Artista a algum disco");
            System.out.println("3. Listar Discos");
            System.out.println("4. Mostrar Detalhes dos Discos");
            System.out.println("5. Listar Artistas");
            System.out.println("6. Cadastrar Novo Artista");
            System.out.println("7. Remover Disco");
            System.out.println("8. Editar Disco");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o título do disco: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o ano de lançamento: ");
                    int anoLancamento = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o número de faixas: ");
                    int numFaixas = scanner.nextInt();
                    scanner.nextLine();
                    String[] faixas = new String[numFaixas];
                    for (int faixa = 0; faixa < numFaixas; faixa++) {
                        System.out.print("Digite o nome da faixa " + (faixa + 1) + ": ");
                        faixas[faixa] = scanner.nextLine();
                    }
                    System.out.print("Digite o nome do artista: ");
                    String nomeArtista = scanner.nextLine();
                    System.out.print("Digite o gênero do artista: ");
                    String generoArtista = scanner.nextLine();
                    Artista artista = new Artista(nomeArtista, generoArtista);

                    boolean sucesso = cadastroDisco.cadastrarDisco(titulo, anoLancamento, faixas, artista);
                    if (sucesso) {
                        System.out.println("Disco cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o disco.");
                    }
                }
                case 2 -> {
                    System.out.print("Digite o título do disco: ");
                    String tituloDisco = scanner.nextLine();
                    System.out.print("Digite o nome do artista: ");
                    String nomeArtista = scanner.nextLine();
                    System.out.print("Digite o gênero do artista: ");
                    String genero = scanner.nextLine();
                    Artista artista = new Artista(nomeArtista, genero);

                    boolean sucesso = gerenciamentoDisco.associarArtista(tituloDisco, artista);
                    if (sucesso) {
                        System.out.println("Artista associado com sucesso ao disco.");
                    } else {
                        System.out.println("Erro ao associar artista.");
                    }
                }
                case 3 -> consultaDisco.listarDiscos();
                case 4 -> consultaDisco.mostrarDetalhesDiscos();
                case 5 -> consultaDisco.listarArtistas();
                case 6 -> {
                    System.out.print("Digite o nome do artista: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o gênero do artista: ");
                    String genero = scanner.nextLine();

                    boolean sucesso = cadastroDisco.cadastrarArtista(nome, genero);
                    if (sucesso) {
                        System.out.println("Artista cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o artista.");
                    }
                }
                case 7 -> {
                    System.out.print("Digite o título do disco a ser removido: ");
                    String titulo = scanner.nextLine();
                    boolean sucesso = gerenciamentoDisco.removerDisco(titulo);
                    if (sucesso) {
                        System.out.println("Disco removido com sucesso!");
                    } else {
                        System.out.println("Erro ao remover o disco.");
                    }
                }
                case 8 -> {
                    System.out.print("Digite o título do disco a ser editado: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o novo ano de lançamento: ");
                    int novoAnoLancamento = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o número de novas faixas: ");
                    int numFaixas = scanner.nextInt();
                    scanner.nextLine();
                    String[] novasFaixas = new String[numFaixas];
                    for (int faixa = 0; faixa < numFaixas; faixa++) {
                        System.out.print("Digite o nome da nova faixa " + (faixa + 1) + ": ");
                        novasFaixas[faixa] = scanner.nextLine();
                    }
                    System.out.print("Digite o nome do novo artista: ");
                    String nomeArtista = scanner.nextLine();
                    System.out.print("Digite o gênero do novo artista: ");
                    String generoArtista = scanner.nextLine();
                    Artista novoArtista = new Artista(nomeArtista, generoArtista);

                    boolean sucesso = gerenciamentoDisco.editarDisco(titulo, novoAnoLancamento, novasFaixas,
                            novoArtista);
                    if (sucesso) {
                        System.out.println("Disco editado com sucesso!");
                    } else {
                        System.out.println("Erro ao editar o disco.");
                    }
                }
                case 9 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
