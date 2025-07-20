package projeto_xadrez.pecas;

public abstract class Peca {
    private final String cor;
    private boolean capturada;

    public Peca(String cor) {
        if (!"branco".equals(cor) && !"preto".equals(cor)) {
            throw new IllegalArgumentException("Cor inválida: " + cor + ". Use 'branco' ou 'preto'.");
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