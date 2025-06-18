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
        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);
        
        if(difLinha == 2 && difColuna == 1)return true;
        if(difColuna == 2 && difLinha == 1)return true;
        return false; 
    } 

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) { 
        if(!movimentoValido(linhaO, colunaO, linhaD, colunaD))return ""; 
        int difLinha = (linhaD - linhaO);
        int difColuna = (colunaD - colunaO);
       
        StringBuilder caminho = new StringBuilder();
        caminho.append(linhaO).append((colunaO));
        if(Math.abs(difLinha) == 2 && Math.abs(difColuna) == 1) {
            int passoLinha = difLinha / 2;
            caminho.append(linhaO + passoLinha).append(colunaO);
            caminho.append(linhaO + 2 * passoLinha).append(colunaO);
        }
        else if(Math.abs(difLinha) == 1 && Math.abs(difColuna) == 2) {
            int passoColuna = difColuna / 2;
            caminho.append(linhaO).append((char)(colunaO + passoColuna));
            caminho.append(linhaO).append((char)(colunaO + 2 * passoColuna));
        }

        caminho.append(linhaD).append(colunaD);
        
        return caminho.toString();
    }
}