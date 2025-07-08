package projeto_xadrez;

import projeto_xadrez.pecas.*;
import java.util.Scanner;

public class Jogo {
    private int situacao;
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Peca[] pecas;
    private boolean vezBranco;

    public Jogo(){
        this.pecas = new Peca[32];
        this.situacao = 0;//situacao 0 = inicio,situacao -1 = xequemate, situacao 1 = xeque;
        vezBranco = true;
        this.tabuleiro = new Tabuleiro(pecas);
        inicializarJogadores();
        colocarPecas();
        tabuleiro.desenho();
    }   


    public boolean jogadaValida(int linhaO, char colunaO, int linhaD, char colunaD){

        return true;
    }

    public void realizarJogada(int linhaO, char colunaO, int linhaD,char colunaD){
    
    }

    public String registroJogo(){
        return "";
    }

    private void inicializarJogadores(){
        Scanner scanner = new Scanner(System.in);//tratar entradas com excecões
        String temp = scanner.nextLine();
        this.jogador1 = new Jogador(temp,"branco");
        temp = scanner.nextLine();
        this.jogador2 = new Jogador(temp,"preto");
        this.tabuleiro = new Tabuleiro(pecas);
    }
    
    private void colocarPecas(){
        int i = 0;
        for(;i<8;i++)pecas[i] = new Peao("branco");
        for(;i<16;i++)pecas[i] = new Peao("preto");
        for(;i<18;i++)pecas[i] = new Torre("branco");
        for(;i<20;i++)pecas[i] = new Torre("preto");
        for(;i<22;i++)pecas[i] = new Bispo("branco");
        for(;i<24;i++)pecas[i] = new Bispo("preto");
        for(;i<26;i++)pecas[i] = new Cavalo("branco");
        for(;i<28;i++)pecas[i] = new Cavalo("preto");
        pecas[i++] = new Dama("branco");
        pecas[i++] = new Dama("preto");
        pecas[i++] = new Rei("branco");
        pecas[i++] = new Rei("preto");
    }
    private void inverteVez(){
        this.vezBranco = !this.vezBranco;
    }

}
