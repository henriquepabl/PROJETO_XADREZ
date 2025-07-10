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
        if (linhaO == linhaD && colunaO == colunaD) return false;

        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);

        return difLinha <= 1 && difColuna <= 1;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (!movimentoValido(linhaO, colunaO, linhaD, colunaD)) return "";
        
        StringBuilder caminho = new StringBuilder();

        caminho.append(linhaO).append(colunaO).append(linhaD).append(colunaD);

        return caminho.toString();
    }
}