package projeto_xadrez;

import projeto_xadrez.pecas.*;
import java.util.ArrayList;
import java.util.List;
public class Jogada {
    private final Jogador jogador;
    private final Caminho caminho;

    public Jogada(int linhaO, char colunaO, int linhaD, char colunaD, Jogador jogador, Tabuleiro tabuleiro) {
        this.jogador = jogador;
        this.caminho = new Caminho(getMovimentoPeca(linhaO, colunaO, linhaD, colunaD, tabuleiro), tabuleiro);
    }
    
    public boolean ehValida() {
        return noLimite() && casaInicialValida() && casaFinalValida() && caminhoLivre() && movimentoValido();
    }
    
    public boolean ehXeque(Tabuleiro tabuleiro) {
        Casa casaDoReiOponente = encontrarCasaDoReiOponente(tabuleiro);
        List<Casa> pecasAtacantes = encontrarPecasDoJogador(tabuleiro);

        for (Casa casaAtacante : pecasAtacantes) {
            Peca peca = casaAtacante.getPeca();
            
            if (peca.movimentoValido(casaAtacante.getLinha(),
                    casaAtacante.getColuna(),
                    casaDoReiOponente.getLinha(),
                    casaDoReiOponente.getColuna())) {
                return true;
            }
        }
        return false;
    }

    private List<Casa> encontrarPecasDoJogador(Tabuleiro tabuleiro) {
        List<Casa> casasComPecas = new ArrayList<>();
        String corJogador = jogador.getCor();

        for (int i = 1; i <= 8; i++) {
            for (char c = 'a'; c <= 'h'; c++) {
                Casa casa = tabuleiro.getCasa(i, c);
                if (!casa.estaVazia() && casa.getPeca().getCor().equals(corJogador)) {
                    casasComPecas.add(casa);
                }
            }
        }
        return casasComPecas;
    }

    private Casa encontrarCasaDoReiOponente(Tabuleiro t) {
        String corOponente = this.jogador.getCor().equals("branco") ? "preto" : "branco";
        
        for (int i = 1; i <= 8; i++) {
            for (char c = 'a'; c <= 'h'; c++) {
                Casa casa = t.getCasa(i, c);
                if (!casa.estaVazia()) {
                    Peca peca = casa.getPeca();
                    if (peca instanceof Rei && peca.getCor().equals(corOponente)) {
                        return casa;
                    }
                }
            }
        }
        return null;
    }

    public boolean ehXequeMate(Tabuleiro tabuleiro) {
        return false;
    }

    private String getMovimentoPeca(int linhaO, char colunaO, int linhaD, char colunaD, Tabuleiro tabuleiro) {
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