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
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) { 
        if (!dentroDoTabuleiro(linhaO, colunaO) || !dentroDoTabuleiro(linhaD, colunaD)) return false;
        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);
        
        if(difLinha == 2 && difColuna == 1)return true;
        if(difColuna == 2 && difLinha == 1)return true;
        return false; 
    } 

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) { 
        return ""; 
    } // implementar
}