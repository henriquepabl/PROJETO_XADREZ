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
        if (linhaO == linhaD && colunaO == colunaD) return false;

        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);

        return linhaO == linhaD || colunaO == colunaD || difLinha == difColuna;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (!movimentoValido(linhaO, colunaO, linhaD, colunaD)) return "";

        StringBuilder caminho = new StringBuilder();
        int dirLinha = Integer.compare(linhaD, linhaO);
        int dirColuna = Integer.compare(colunaD, colunaO);
        int linha = linhaO;
        char coluna = colunaO;

        while (linha != linhaD || coluna != colunaD) {
            caminho.append(linha).append(coluna);

            linha += dirLinha;
            coluna += dirColuna;
        }
        caminho.append(linha).append(coluna);

        return caminho.toString();
    }
}