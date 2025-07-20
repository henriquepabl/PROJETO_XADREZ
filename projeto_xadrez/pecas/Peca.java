package projeto_xadrez.pecas;

public abstract class Peca {
    protected final String cor;
    protected boolean capturada;

    public Peca(String cor) {
        if (!"branca".equals(cor) && !"preta".equals(cor)) {
            throw new IllegalArgumentException("Cor inválida: " + cor + ". Use 'branca' ou 'preta'.");
        }

        this.cor = cor;
        this.capturada = false;
    }

    public String getCor() {
        return cor;
    }

    public boolean estaCapturada() {
        return capturada;
    }

    public void capturar() {
        this.capturada = true;
    }

    public abstract String desenho();

    public abstract boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD);

    public abstract String caminho(int linhaO, char colunaO, int linhaD, char colunaD);
}