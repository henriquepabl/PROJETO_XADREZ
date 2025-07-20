package projeto_xadrez;

import projeto_xadrez.pecas.*;

public class Jogada {
    private final Jogador jogador;
    private final Caminho caminho;

    public Jogada(String movimento, Jogador jogador, Tabuleiro tabuleiro) {
        this.jogador = jogador;
        this.caminho = new Caminho(getMovimentoPeca(movimento, tabuleiro), tabuleiro);
    }
    
    public boolean ehValida() {
        return noLimite() && casaInicialValida() && casaFinalValida() && caminhoLivre() && movimentoValido();
    }
    
    public boolean ehXeque() {return false;}

    public boolean ehXequeMate() {return false;}

    private String getMovimentoPeca(String movimento, Tabuleiro tabuleiro) {
        int linhaO = movimento.charAt(0) - '0';
        char colunaO = movimento.charAt(1);
        int linhaD = movimento.charAt(2) - '0';
        char colunaD = movimento.charAt(3);

        Peca peca = tabuleiro.getCasa(linhaO, colunaO).getPeca();
        if (peca == null) {
            throw new IllegalArgumentException("Não há peça na posição inicial.");
        }
        
        return peca.caminho(linhaO, colunaO, linhaD, colunaD);
    }

    private boolean noLimite() {
        Casa casaInicial = caminho.casaInicial();
        Casa casaFinal = caminho.casaFinal();

        int linhaO = casaInicial.getLinha();
        char colunaO = casaInicial.getColuna();
        int linhaD = casaFinal.getLinha();
        char colunaD = casaFinal.getColuna();

        return Tabuleiro.noLimite(linhaO, colunaO) && Tabuleiro.noLimite(linhaD, colunaD);
    }

    private boolean casaInicialValida() {
        Casa casaInicial = caminho.casaInicial();
        Peca peca = casaInicial.getPeca();

        return peca.getCor() == jogador.getCor();
    }

    private boolean casaFinalValida() {
        Casa casaFinal = caminho.casaFinal();
        Peca peca = casaFinal.getPeca();

        return peca == null || peca.getCor() != jogador.getCor();
    }

    private boolean caminhoLivre() {
        Casa casaInicial = caminho.casaInicial();
        Peca peca = casaInicial.getPeca();

        if (peca.desenho().equals("C")) return true;

        return caminho.estaLivre();
    }

    private boolean movimentoValido() {
        Casa casaInicial = caminho.casaInicial();
        Casa casaFinal = caminho.casaFinal();
        Peca peca = casaInicial.getPeca();

        int linhaO = casaInicial.getLinha();
        char colunaO = casaInicial.getColuna();
        int linhaD = casaFinal.getLinha();
        char colunaD = casaFinal.getColuna();

        if (peca.desenho().equals("P")) {
            int difColuna = Math.abs(colunaD - colunaO);

            if (difColuna == 0) return casaFinal.getPeca() == null;
            return casaFinal.getPeca() != null;
        }

        return peca.movimentoValido(linhaO, colunaO, linhaD, colunaD);
    }
}