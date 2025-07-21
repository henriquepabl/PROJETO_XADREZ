package projeto_xadrez;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        gerenciador.executar();
    }

    public void executar() {
        int opcao;

        while (true) {
            exibirMenu();

            try {
                opcao = sc.nextInt();
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("\nInput do tipo errado, deve ser int");
                sc.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    novoJogo();
                    break;
                case 2:
                    carregarJogo();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Novo Jogo");
        System.out.println("2. Carregar Jogo");
        System.out.println("3. Sair");
        System.out.println("======================");
        System.out.print("\nEscolha uma opção: ");
    }

    private void novoJogo() {
        Jogo jogo = new Jogo(sc);
        jogo.jogar();

        salvarJogo(jogo);
    }

    private void carregarJogo() {
        System.out.print("\nDigite o nome do arquivo a ser carregado: ");
        String nomeArquivo = sc.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            List<String> historico = new ArrayList<>();
            for (String linha = br.readLine(); linha != null; linha = br.readLine()) {
                historico.add(linha.trim());
            }

            Jogo jogo = new Jogo(sc, historico);
            jogo.jogar();

            salvarJogo(jogo);
        }
        catch (IOException e) {
            System.out.println("\nErro ao carregar o jogo: " + e.getMessage());
        }
    }

    private void salvarJogo(Jogo jogo) {
        while (true) {
            System.out.print("\nDeseja salvar o jogo? (s/n): ");
            String resposta = sc.nextLine().trim().toLowerCase();

            if (resposta.equals("s")) {
                break;
            }
            if (resposta.equals("n")) {
                return;
            }

            System.out.println("\nEntrada inválida. Tente novamente.");
        }

        System.out.print("\nDigite o nome do arquivo para salvar o jogo: ");
        String nomeArquivo = sc.nextLine().trim();

        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeArquivo))) {
            pw.print(jogo.registroJogo());
            System.out.println("\nJogo salvo com sucesso.");
        }
        catch (IOException e) {
            System.out.println("\nErro ao salvar o jogo: " + e.getMessage());
        }
    }
}