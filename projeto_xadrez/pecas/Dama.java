package projeto_xadrez.pecas;

public class Dama extends Peca {
    public Dama(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        return "D";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);
        return (linhaO == linhaD || colunaO == colunaD) || (difLinha == difColuna);
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (!movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return "";
        }

        StringBuilder caminho = new StringBuilder();
        caminho.append(linhaO).append(colunaO);

        if (linhaO == linhaD) { // Movimento horizontal
            int dir = colunaD > colunaO ? 1 : -1;
            for (char c = (char) (colunaO + dir); c != colunaD; c += dir) {
                caminho.append(linhaO).append(c);
            }
        } else if (colunaO == colunaD) { // Movimento vertical
            int dir = linhaD > linhaO ? 1 : -1;
            for (int l = linhaO + dir; l != linhaD; l += dir) {
                caminho.append(l).append(colunaO);
            }
        } else { // Movimento diagonal
            int dirLinha = linhaD > linhaO ? 1 : -1;
            int dirColuna = colunaD > colunaO ? 1 : -1;

            int l = linhaO + dirLinha;
            char c = (char) (colunaO + dirColuna);

            while (l != linhaD && c != colunaD) {
                caminho.append(l).append(c);
                l += dirLinha;
                c += dirColuna;
            }
        }

        caminho.append(linhaD).append(colunaD);
        return caminho.toString();
    }
}