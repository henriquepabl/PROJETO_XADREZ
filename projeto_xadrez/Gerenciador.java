package projeto_xadrez;

import java.util.Scanner;

public class Gerenciador {

    private Tabuleiro tabuleiro;
    private Jogador jogadorBranco;
    private Jogador jogadorPreto;
    private Jogador jogadorAtual;

    public GerenciadorXadrez() {
        tabuleiro = new Tabuleiro();
        jogadorBranco = new Jogador("Brancas");
        jogadorPreto = new Jogador("Pretas");
        jogadorAtual = jogadorBranco;
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        boolean jogando = true;

        while (jogando) {
            exibirMenuInicial();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    jogarPartida(scanner);
                    break;
                case 2:
                    System.out.println("Exibindo regras básicas do jogo...");
                    exibirRegras();
                    break;
                case 3:
                    jogando = false;
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private void exibirMenuInicial() {
        System.out.println("===== XADREZ =====");
        System.out.println("1 - Iniciar partida");
        System.out.println("2 - Regras do jogo");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void jogarPartida(Scanner scanner) {
        tabuleiro.inicializar();
        boolean fimDeJogo = false;

        while (!fimDeJogo) {
            tabuleiro.exibir();
            System.out.println("Vez do jogador: " + jogadorAtual.getNome());
            System.out.print("Digite o movimento (ex: e2e4): ");
            String movimento = scanner.nextLine();

            if (tabuleiro.movimentoValido(movimento, jogadorAtual)) {
                tabuleiro.realizarMovimento(movimento);
                fimDeJogo = tabuleiro.verificarFimDeJogo();
                alternarJogador();
            } else {
                System.out.println("Movimento inválido. Tente novamente.");
            }
        }
        System.out.println("Fim da partida!");
    }

    private void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogadorBranco) ? jogadorPreto : jogadorBranco;
    }

    private void exibirRegras() {
        System.out.println("As regras básicas do xadrez incluem o movimento de cada peça:");
        System.out.println("- Peões avançam para frente e capturam diagonalmente.");
        System.out.println("- Torres se movem horizontal e verticalmente.");
        System.out.println("- Cavalos se movem em L.");
        System.out.println("- Bispos se movem diagonalmente.");
        System.out.println("- Rainha se move em qualquer direção.");
        System.out.println("- Rei se move apenas uma casa por vez.");
    }

    public static void main(String[] args) {
        GerenciadorXadrez jogo = new GerenciadorXadrez();
        jogo.iniciarJogo();
    }
}

