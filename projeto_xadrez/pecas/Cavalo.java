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
        if (linhaO == linhaD && colunaO == colunaD) return false;

        int difLinha = Math.abs(linhaD - linhaO);
        int difColuna = Math.abs(colunaD - colunaO);
        
        if (difLinha == 2 && difColuna == 1) return true;
        if (difLinha == 1 && difColuna == 2) return true;

        return false; 
    } 

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) { 
        if (!movimentoValido(linhaO, colunaO, linhaD, colunaD)) return "";

        StringBuilder caminho = new StringBuilder();
        int difLinha = Math.abs(linhaO - linhaD);
       
        caminho.append(linhaO).append((colunaO));
        if (difLinha == 2) {
            int dirLinha = Integer.compare(linhaD, linhaO);

            caminho.append(linhaO + dirLinha).append(colunaO);
            caminho.append(linhaD).append(colunaO);
        }
        else {
            int dirColuna = Integer.compare(colunaD, colunaO);

            caminho.append(linhaO).append((char)(colunaO + dirColuna));
            caminho.append(linhaO).append(colunaD);
        }
        caminho.append(linhaD).append(colunaD);
        
        return caminho.toString();
    }
}