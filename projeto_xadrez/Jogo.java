package projeto_xadrez;

import projeto_xadrez.pecas.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogadorBranco;
    private Jogador jogadorPreto;
    private Peca[] pecasBrancas;
    private Peca[] pecasPretas;
    private boolean vezBranco;
    private boolean emAndamento;
    private boolean xeque;
    private boolean xequeMate;
    private ArrayList<String> historico;
    private Jogada jogada;

    public Jogo() {
        pecasBrancas = new Peca[16];
        pecasPretas = new Peca[16];
        colocarPecas();

        jogadorBranco = new Jogador("branco", pecasBrancas);
        jogadorPreto = new Jogador("preto", pecasPretas);

        vezBranco = true;
        emAndamento = true;
        xeque = false;
        xequeMate = false;

        tabuleiro = new Tabuleiro(pecasBrancas, pecasPretas);

        historico = new ArrayList<>();

        historico.add(jogadorBranco.getNome() + " - peças brancas");
        historico.add(jogadorPreto.getNome() + " - peças pretas");
        tabuleiro.desenho(); /* !! DEPOIS REMOVER !! */
    }

    public boolean jogadaValida(int linhaO, char colunaO, int linhaD, char colunaD) {return true;}

    public void realizarJogada(int linhaO, char colunaO, int linhaD, char colunaD) {}

    public String registroJogo() {
        StringBuilder sb = new StringBuilder();

        for (String s : historico) {
            sb.append(s).append("\n");
        }

        return sb.toString();
    }
    
    private void colocarPecas() {
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

    private void inverteVez() {
        vezBranco = !vezBranco;
    }
}