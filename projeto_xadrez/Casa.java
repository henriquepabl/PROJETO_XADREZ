package projeto_xadrez;

import projeto_xadrez.pecas.*;

public class Casa {
    private static final String FUNDO_CLARO = "\u001B[48;5;180m";  // Marrom claro
    private static final String FUNDO_ESCURO = "\u001B[48;5;94m";   // Marrom escuro
    private static final String TEXTO_BRANCO = "\u001B[97m";
    private static final String TEXTO_PRETO = "\u001B[30m";
    private static final String RESET = "\u001B[0m";

    private final int linha;
    private final char coluna;
    private final boolean clara;
    private Peca peca;

    public Casa(int linha, char coluna, boolean clara) {
        if (!Tabuleiro.noLimite(linha, coluna)) {
            throw new IllegalArgumentException("Coordenadas inválidas para a casa: " + linha + coluna);
        }

        this.linha = linha;
        this.coluna = coluna;
        this.clara = clara;
        this.peca = null;
    }

    public int getLinha() {
        return linha;
    }

    public char getColuna() {
        return coluna;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public boolean estaVazia() {
        return peca == null;
    }

    @Override
    public String toString() {
        String fundo = clara ? FUNDO_CLARO : FUNDO_ESCURO;
        String texto = "   "; // Alinhamento

        if (!estaVazia()) {
            // Peças brancas com texto branco, peças pretas com texto preto
            String corTexto = peca.getCor().equals("branco") ? TEXTO_BRANCO : TEXTO_PRETO;
            texto = " " + corTexto + peca.desenho() + " ";
        }

        return fundo + texto + RESET;
    }
}