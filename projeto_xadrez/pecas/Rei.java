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
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) { return true; } // implementar

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) { return ""; } // implementar
}