package projeto_xadrez;

import projeto_xadrez.pecas.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogadorB;
    private Jogador jogadorP;
    private Peca[] pecasB;
    private Peca[] pecasP;
    private boolean vezBranco;
    private int situacao; //situacao 0 = inicio,situacao -1 = xequemate, situacao 1 = xeque;
    private ArrayList<String> historico;
    private Jogada jogada;
    public Jogo() {
        pecasB = new Peca[16];
        pecasP = new Peca[16];
        colocarPecas();
        jogadorB = new Jogador("branco", pecasB);
        jogadorP = new Jogador("preto", pecasP);
        situacao = 0;
        vezBranco = true;
        tabuleiro = new Tabuleiro(pecasB, pecasP);
        historico = new ArrayList<>();
        historico.add(jogadorB.getNome() + " - peças brancas");
        historico.add(jogadorP.getNome() + " - peças pretas");
        tabuleiro.desenho(); /* !! DEPOIS REMOVER !! */
    }

    public boolean jogadaValida(int linhaO, char colunaO, int linhaD, char colunaD) {
        
    }

    public void realizarJogada(int linhaO, char colunaO, int linhaD, char colunaD) { 

    }

    public String registroJogo() {
        return "";
    }
    
    private void colocarPecas() {
        int i = 0;

        while (i < 8) {
            pecasB[i] = new Peao("branco");
            pecasP[i++] = new Peao("preto");
        }
        while (i < 10) {
            pecasB[i] = new Torre("branco");
            pecasP[i++] = new Torre("preto");
        }
        while (i < 12) {
            pecasB[i] = new Cavalo("branco");
            pecasP[i++] = new Cavalo("preto");
        }
        while (i < 14) {
            pecasB[i] = new Bispo("branco");
            pecasP[i++] = new Bispo("preto");
        }
        pecasB[i] = new Dama("branco");
        pecasP[i++] = new Dama("preto");
        pecasB[i] = new Rei("branco");
        pecasP[i] = new Rei("preto");
    }

    private void inverteVez() {
        vezBranco = !vezBranco;
    }
}