package projeto_xadrez.pecas;

public class Torre extends Peca {
    public Torre(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        return "T";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        // Movimento na mesma linha ou na mesma coluna
        if (linhaO == linhaD && colunaO == colunaD) return false;

        return (linhaO == linhaD) || (colunaO == colunaD);
    }

    @Override
   public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (!movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return "";
        }

        StringBuilder caminho = new StringBuilder();

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
        }

        caminho.append(linhaD).append(colunaD); // Inclui destino
        return caminho.toString();
    }
}