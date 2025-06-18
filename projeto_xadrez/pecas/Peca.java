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
    public abstract String desenho();
    public abstract boolean movimentoValido(int linhaO,char colunaO,int linhaD,char colunaD);
    public abstract String caminho(int linhaO,char colunaO,int linhaD,char colunaD);
}
