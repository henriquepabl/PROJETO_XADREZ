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

    private void colocarPecasIniciais() { /* !! complementar para outras peças !! */
        // Peões brancos (linha 2)
        for (char c = 'a'; c <= 'h'; c++) {
            getCasa(2, c).setPeca(new Peao("branco"));
        }

        // Peões pretos (linha 7)
        for (char c = 'a'; c <= 'h'; c++) {
            getCasa(7, c).setPeca(new Peao("preto"));
        }
        // Cavalos brancos 
        getCasa(1,'b').setPeca(new Cavalo("branco"));
        getCasa(1,'g').setPeca(new Cavalo("branco"));
        
        //Cavalos pretos
        getCasa(8,'b').setPeca(new Cavalo("preto"));
        getCasa(8,'g').setPeca(new Cavalo("preto"));
    }


    public String desenho() {
        StringBuilder sb = new StringBuilder();

        // Cabeçalho com letras
        sb.append("   ");
        for (char c = 'a'; c <= 'h'; c++) {
            sb.append("").append(c).append("  ");
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
        sb.append("   ");
        for (char c = 'a'; c <= 'h'; c++) {
            sb.append("").append(c).append("  ");
        }

        return sb.toString();
    }

    public Casa getCasa(int linha, char coluna) {
        if (linha < 1 || linha > 8 || coluna < 'a' || coluna > 'h') {
            throw new IllegalArgumentException("Posição inválida: " + linha + coluna);
        }
        return casas[8 - linha][coluna - 'a'];
    }

    public static void main(String[] args) { /* !! Depois vai precisar remover !! */
        Tabuleiro tabuleiro = new Tabuleiro();
        System.out.println(tabuleiro.desenho());
    }
}