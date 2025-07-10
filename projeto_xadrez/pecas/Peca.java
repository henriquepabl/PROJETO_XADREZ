package projeto_xadrez.pecas;

public abstract class Peca {
    private final String cor;
    private boolean capturada;

    public Peca(String cor) {
        if (!cor.equalsIgnoreCase("branca") && !cor.equalsIgnoreCase("preta")) {
            throw new IllegalArgumentException("Cor inválida para a peça: " + cor);
        }

        this.cor = cor.toLowerCase();
        this.capturada = false;
    }

    public String getCor() {
        return cor;
    }

    public void setCapturada(boolean capturada) {
        this.capturada = capturada;
    }

    public boolean estaCapturada() {
        return capturada;
    }

    public abstract String desenho();

    public abstract boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD);

    public abstract String caminho(int linhaO, char colunaO, int linhaD, char colunaD);
}