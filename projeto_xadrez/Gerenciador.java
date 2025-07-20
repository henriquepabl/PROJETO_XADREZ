package projeto_xadrez;

import java.io.*;
import java.util.*;

public class Gerenciador {
    private boolean jogoEmAndamento;
    private Jogo jogo;

    public Gerenciador() {
        jogoEmAndamento = false;
        jogo = null;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Novo Jogo");
            System.out.println("2. Carregar Jogo");
            System.out.println("3. Salvar Jogo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    novoJogo();
                    break;
                case 2:
                    carregarJogo();
                    break;
                case 3:
                    salvarJogo();
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private void novoJogo() {
        jogo = new Jogo();
        jogoEmAndamento = true;

        while (!jogo.terminado()) {
            System.out.println(jogo.getTabuleiro().desenho());
            Jogador atual = jogo.jogadorAtual();
            String entrada = atual.informaJogada();

            if (entrada.equalsIgnoreCase("parar")) break;

            try {
                Jogada jogada = new Jogada(entrada, atual, jogo.getTabuleiro());
                if (jogada.ehValida()) {
                    jogo.realizarJogada(jogada);
                    jogo.registrarJogada(entrada);
                    jogo.inverterVez();
                } else {
                    System.out.println("Jogada inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro na jogada: " + e.getMessage());
            }
        }

        jogoEmAndamento = false;
        System.out.println("Fim de jogo!");
    }

    private void salvarJogo() {
        if (!jogoEmAndamento || jogo == null) {
            System.out.println("Nenhum jogo em andamento para salvar.");
            return;
        }

        try (FileWriter fw = new FileWriter("salvo.txt")) {
            for (String linha : jogo.getHistorico()) {
                fw.write(linha + "\n");
            }
            System.out.println("Jogo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarJogo() {
        try (BufferedReader br = new BufferedReader(new FileReader("salvo.txt"))) {
            List<String> historico = new ArrayList<>();
            String linha;

            while ((linha = br.readLine()) != null) {
                historico.add(linha);
            }

            jogo = new Jogo(historico);
            jogoEmAndamento = true;
            novoJogo();

        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Gerenciador g = new Gerenciador();
        g.iniciar();
    }
}

