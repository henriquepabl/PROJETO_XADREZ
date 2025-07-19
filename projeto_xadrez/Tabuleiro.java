package projeto_xadrez;

import projeto_xadrez.pecas.*;

public class Tabuleiro {
    private Casa[][] casas;

    public Tabuleiro(Peca[] pecasB, Peca[] pecasP) {
        casas = new Casa[8][8];
        inicializarTabuleiro();
        colocarPecasIniciais(pecasB, pecasP);
    }

    public Casa getCasa(int linha, char coluna) {
        if (linha < 1 || linha > 8 || coluna < 'a' || coluna > 'h') {
            throw new IllegalArgumentException("Posição inválida: " + linha + coluna);
        }

        return casas[8 - linha][coluna - 'a'];
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

    private void colocarPecasIniciais(Peca[] pecasB, Peca[] pecasP) {
        // Peões
        for (int i = 0; i < 8; i++) {
            getCasa(2, (char)('a' + i)).setPeca(pecasB[i]);
            getCasa(7, (char)('a' + i)).setPeca(pecasP[i]);
        }

        // Torres
        getCasa(1, 'a').setPeca(pecasB[8]);
        getCasa(1, 'h').setPeca(pecasB[9]);
        getCasa(8, 'a').setPeca(pecasP[8]);
        getCasa(8, 'h').setPeca(pecasP[9]);

        // Cavalos
        getCasa(1, 'b').setPeca(pecasB[10]);
        getCasa(1, 'g').setPeca(pecasB[11]);
        getCasa(8, 'b').setPeca(pecasP[10]);
        getCasa(8, 'g').setPeca(pecasP[11]);

        // Bispos
        getCasa(1, 'c').setPeca(pecasB[12]);
        getCasa(1, 'f').setPeca(pecasB[13]);
        getCasa(8, 'c').setPeca(pecasP[12]);
        getCasa(8, 'f').setPeca(pecasP[13]);

        // Damas e Reis
        getCasa(1, 'd').setPeca(pecasB[14]);
        getCasa(1, 'e').setPeca(pecasB[15]);
        getCasa(8, 'd').setPeca(pecasP[14]);
        getCasa(8, 'e').setPeca(pecasP[15]);
    }
    public static boolean noLimite(int linha, char coluna) {
        return linha >= 1 && linha <= 8 && coluna >= 'a' && coluna <= 'h';
    }
}