package projeto_xadrez;

import projeto_xadrez.pecas.*; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private final Tabuleiro tabuleiro;
    private final Jogador jogadorBranco;
    private final Jogador jogadorPreto;
    private final Peca[] pecasBrancas;
    private final Peca[] pecasPretas;
    private final List<String> historico;
    private Jogador jogadorAtual;
    private Jogada jogada;
    private boolean emAndamento;
    private boolean xeque;
    private boolean xequeMate;

    public Jogo(Scanner sc) {
        pecasBrancas = new Peca[16];
        pecasPretas = new Peca[16];
        inserirPecasIniciais();

        jogadorBranco = new Jogador("branco", pecasBrancas, sc);
        jogadorPreto = new Jogador("preto", pecasPretas, sc);
        jogadorAtual = jogadorBranco;

        tabuleiro = new Tabuleiro(pecasBrancas, pecasPretas);

        historico = new ArrayList<>();
        historico.add(jogadorBranco.getNome());
        historico.add(jogadorPreto.getNome());

        jogada = null;
        emAndamento = true;
        xeque = false;
        xequeMate = false;
    }

    public Jogo(Scanner sc, List<String> historico) {
        this.historico = historico;

        pecasBrancas = new Peca[16];
        pecasPretas = new Peca[16];
        inserirPecasIniciais();

        jogadorBranco = new Jogador("branco", historico.get(0), pecasBrancas, sc);
        jogadorPreto = new Jogador("preto", historico.get(1), pecasPretas, sc);
        jogadorAtual = jogadorBranco;

        tabuleiro = new Tabuleiro(pecasBrancas, pecasPretas);

        jogada = null;
        emAndamento = true;
        xeque = false;
        xequeMate = false;

        recuperarJogo();
    }

    public boolean jogadaValida(int linhaO, char colunaO, int linhaD, char colunaD) {
        jogada = new Jogada(linhaO, colunaO, linhaD, colunaD, jogadorAtual, tabuleiro);

        return jogada.ehValida();
    }

    public void realizarJogada(int linhaO, char colunaO, int linhaD, char colunaD) {
        Casa casaOrigem = tabuleiro.getCasa(linhaO, colunaO);
        Casa casaDestino = tabuleiro.getCasa(linhaD, colunaD);
        Peca pecaOrigem = casaOrigem.getPeca();
        Peca pecaDestino = casaDestino.getPeca();

        if (pecaDestino != null) {
            pecaDestino.capturar();
        }

        casaOrigem.setPeca(null);
        casaDestino.setPeca(pecaOrigem);

        if (pecaOrigem.desenho().equals("P")) {
            ((Peao)pecaOrigem).setJaMoveu(true);;
        }
    }

    public String registroJogo() {
        StringBuilder sb = new StringBuilder();

        for (String s : historico) {
            sb.append(s).append("\n");
        }

        return sb.toString();
    }

    public void jogar() {
        while (emAndamento) {
            try {
                System.out.println("\n============================================");
                System.out.println("Vez de: " + jogadorAtual.getNome());
                if (xeque) System.out.println("Xeque!");
                System.out.println("\nPeças capturadas por " + jogadorPreto.getNome() + ": " + jogadorBranco.pecasCapturadas());
                System.out.println(tabuleiro.desenho());
                System.out.println("Peças capturadas por " + jogadorBranco.getNome() + ": " + jogadorPreto.pecasCapturadas());
                System.out.println("============================================");

                String entrada;
                while (true) {
                    entrada = jogadorAtual.informaJogada();

                    if ("parar".equalsIgnoreCase(entrada)) {
                        return;
                    }

                    try {
                        if (!entrada.matches("[1-8][a-hA-H][1-8][a-hA-H]")) {
                            throw new IllegalArgumentException("Formato inválido. Use o formato (linha coluna linha coluna) com linha entre 1 e 8 e coluna entre 'a' e 'h'.");
                        }

                        int linhaO = entrada.charAt(0) - '0';
                        char colunaO = entrada.charAt(1);
                        int linhaD = entrada.charAt(2) - '0';
                        char colunaD = entrada.charAt(3);

                        if (jogadaValida(linhaO, colunaO, linhaD, colunaD)) {
                            realizarJogada(linhaO, colunaO, linhaD, colunaD);
                            registrarJogada(entrada);
                            inverteVez();
                            break;
                        }
                        else {
                            System.out.println("\nJogada inválida. Tente novamente.");
                        }
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("\nErro: " + e.getMessage());
                    }
                }

                if (pecasBrancas[15].estaCapturada() || pecasPretas[15].estaCapturada()) { // SOLUÇÃO TEMPORÁRIA
                    System.out.println("\nXeque-mate! Jogo terminado.");
                    emAndamento = false;
                    return;
                }

                xeque = jogada.ehXeque(tabuleiro);
                if (xeque) {
                    xequeMate = jogada.ehXequeMate(tabuleiro); // XEQUE-MATE NÃO IMPLEMENTADO SOLUÇÃO TEMPORÁRIA PARA FINALIZAR JOGO
                    if (xequeMate) {
                        System.out.println("\nXeque-mate! Jogo terminado.");
                        emAndamento = false;
                        return;
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }

    public void registrarJogada(String jogada) {
        historico.add(jogada);
    }

    private void inverteVez() {
        if (jogadorAtual == jogadorBranco) {
            jogadorAtual = jogadorPreto;
        }
        else {
            jogadorAtual = jogadorBranco;
        }
    }

    private void inserirPecasIniciais() {
        int i = 0;
        while (i < 8) {
            pecasBrancas[i] = new Peao("branco");
            pecasPretas[i++] = new Peao("preto");
        }
        while (i < 10) {
            pecasBrancas[i] = new Torre("branco");
            pecasPretas[i++] = new Torre("preto");
        }
        while (i < 12) {
            pecasBrancas[i] = new Cavalo("branco");
            pecasPretas[i++] = new Cavalo("preto");
        }
        while (i < 14) {
            pecasBrancas[i] = new Bispo("branco");
            pecasPretas[i++] = new Bispo("preto");
        }
        pecasBrancas[i] = new Dama("branco");
        pecasPretas[i++] = new Dama("preto");
        pecasBrancas[i] = new Rei("branco");
        pecasPretas[i] = new Rei("preto");
    }

    private void recuperarJogo() {
        int i = 0;
        for (String movimento : historico) {
            if (i++ < 2) continue;

            int linhaO = movimento.charAt(0) - '0';
            char colunaO = movimento.charAt(1);
            int linhaD = movimento.charAt(2) - '0';
            char colunaD = movimento.charAt(3);

            realizarJogada(linhaO, colunaO, linhaD, colunaD);
            inverteVez();
        }
    }
}