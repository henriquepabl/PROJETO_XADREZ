package projectxadrez;

public abstract class Peca{
    //atributos
    private String cor;
    private boolean capturada;
    
    public Peca(String color){
        cor = color;
        capturada = false;
    }
    //getters e setters 
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isCapturada() {
        return capturada;
    }

    public void setCapturada(boolean capturada) {
        this.capturada = capturada;
    }

    //metodos abstratos
    public abstract String desenho();
    public abstract Boolean movimentoValido(int linhaO,char colunaO,int linhaD,char colunaD);
    public abstract String caminho(int linhaO,char colunaO,int linhaD,char colunaD);

   

}
