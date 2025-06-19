package projeto_xadrez.pecas;

public class Bispo extends Peca {
    public Bispo(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        return "B";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        int diffLinha = Math.abs(linhaO - linhaD);
        int diffColuna = Math.abs(colunaO - colunaD);
        return diffLinha == diffColuna;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (!movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return "";
        }

        StringBuilder caminho = new StringBuilder();

        int dirLinha = linhaD > linhaO ? 1 : -1;
        int dirColuna = colunaD > colunaO ? 1 : -1;

        int linha = linhaO + dirLinha;
        char coluna = (char) (colunaO + dirColuna);

        while (linha != linhaD && coluna != colunaD) {
            caminho.append(linha).append(coluna);
            linha += dirLinha;
            coluna += dirColuna;
        }

        caminho.append(linhaD).append(colunaD); // Inclui destino
        return caminho.toString();
    }
}