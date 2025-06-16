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
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) { return true; } // implementar

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) { return ""; } // implementar
}