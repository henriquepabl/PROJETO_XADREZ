package projeto_xadrez.pecas;

public class Rei extends Peca {
    public Rei(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        return "R";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);
        return (difLinha <= 1 && difColuna <= 1);
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (!movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return "";
        }
        return linhaO + "" + colunaO + linhaD + colunaD;
    }
}