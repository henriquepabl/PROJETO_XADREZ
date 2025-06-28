package projeto_xadrez;

import projeto_xadrez.pecas.*;

public class Tabuleiro {
    private Casa[][] casas;

    public Tabuleiro() {
        casas = new Casa[8][8];
        inicializarTabuleiro();
        colocarPecasIniciais();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean clara = (i + j) % 2 == 0;
                char coluna = (char) ('a' + j);
                int linha = 8 - i;
                casas[i][j] = new Casa(linha, coluna, clara);
            }
        }
    }

    private void colocarPecasIniciais() {
        // Peões
        for (char c = 'a'; c <= 'h'; c++) {
            getCasa(2, c).setPeca(new Peao("branco"));
            getCasa(7, c).setPeca(new Peao("preto"));
        }

        // Cavalos
        getCasa(1, 'b').setPeca(new Cavalo("branco"));
        getCasa(1, 'g').setPeca(new Cavalo("branco"));
        getCasa(8, 'b').setPeca(new Cavalo("preto"));
        getCasa(8, 'g').setPeca(new Cavalo("preto"));

        // Reis e Damas
        getCasa(1, 'e').setPeca(new Rei("branco"));
        getCasa(8, 'e').setPeca(new Rei("preto"));
        getCasa(1, 'd').setPeca(new Dama("branco"));
        getCasa(8, 'd').setPeca(new Dama("preto"));

        // Torres
        getCasa(1, 'a').setPeca(new Torre("branco"));
        getCasa(1, 'h').setPeca(new Torre("branco"));
        getCasa(8, 'a').setPeca(new Torre("preto"));
        getCasa(8, 'h').setPeca(new Torre("preto"));

        // Bispos
        getCasa(1, 'c').setPeca(new Bispo("branco"));
        getCasa(1, 'f').setPeca(new Bispo("branco"));
        getCasa(8, 'c').setPeca(new Bispo("preto"));
        getCasa(8, 'f').setPeca(new Bispo("preto"));
    }

    public String desenho() {
        StringBuilder sb = new StringBuilder();

        // Cabeçalho com letras
        sb.append("  ");
        for (char c = 'a'; c <= 'h'; c++) {
            sb.append(" ").append(c).append(" ");
        }
        sb.append("\n");

        // Tabuleiro
        for (int i = 0; i < 8; i++) {
            sb.append(8 - i).append(" ");
            for (int j = 0; j < 8; j++) {
                sb.append(casas[i][j].toString());
            }
            sb.append(" ").append(8 - i).append("\n");
        }

        // Rodapé com letras
        sb.append("  ");
        for (char c = 'a'; c <= 'h'; c++) {
            sb.append(" ").append(c).append(" ");
        }

        return sb.toString();
    }

    public Casa getCasa(int linha, char coluna) {
        if (linha < 1 || linha > 8 || coluna < 'a' || coluna > 'h') {
            throw new IllegalArgumentException("Posição inválida: " + linha + coluna);
        }
        return casas[8 - linha][coluna - 'a'];
    }
}