package projeto_xadrez.pecas;

public class Cavalo extends Peca {
    public Cavalo(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        return "C";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) { return true; } // implementar

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) { return ""; } // implementar
}