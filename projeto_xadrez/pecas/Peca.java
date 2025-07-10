package projeto_xadrez.pecas;

public abstract class Peca {
    private final String cor;
    private boolean capturada;
    
    public Peca(String cor) {
        this.cor = cor;
        capturada = false;
    }

    public String getCor() {
        return cor;
    }

    public boolean getCapturada() {
        return capturada;
    }

    public void setCapturada(boolean capturada) {
        this.capturada = capturada;
    }

    public abstract String desenho();

    public abstract boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD);

    public abstract String caminho(int linhaO, char colunaO, int linhaD, char colunaD);
}