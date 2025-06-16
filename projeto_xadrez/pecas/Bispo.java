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
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) { return true; } // implementar

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) { return ""; } // implementar
}