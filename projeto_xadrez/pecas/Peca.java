package projeto_xadrez.pecas;

public abstract class Peca{
    private final String cor;
    private boolean capturada;
    
    public Peca(String color){
        cor = color;
        capturada = false;
    }

    public String getCor() {
        return cor;
    }

    public boolean isCapturada() {
        return capturada;
    }

    public void capturar() {
        capturada = true;
    }
    protected static boolean dentroDoTabuleiro(int linha, char coluna) {
        return linha >= 1 && linha <= 8 && coluna >= 'a' && coluna <= 'h';
    }
    public abstract String desenho();
    public abstract boolean movimentoValido(int linhaO,char colunaO,int linhaD,char colunaD);
    public abstract String caminho(int linhaO,char colunaO,int linhaD,char colunaD);
}
