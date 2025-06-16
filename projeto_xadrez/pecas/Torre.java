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
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) { return true; } // implementar

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) { return ""; } // implementar
}