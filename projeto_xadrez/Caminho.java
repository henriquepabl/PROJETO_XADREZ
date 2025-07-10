package projeto_xadrez;
import java.util.ArrayList;
public class Caminho(){

    private String jogada;
    private ArrayList<Casa> casas;
    private Tabuleiro tabuleiro;

    public Caminho(String jogada,Tabuleiro T){
        this.jogada = jogada;
        tabuleiro = T;
        casas = new ArrayList<>();
        casas.add(tabuleiro.getCasa((int)jogada[0],jogada[1]))
    }

    public Casa casaFinal(){
        return casas[0]
    }

    public Casa casaInicial(){
        return casas[casas.length()-1];
    }

    public boolean estaLivre(){
        String caminho = casaInicial().getPeca().caminho((int)jogada[0],jogada[1],jogada[2],jogada[3]);

    }
}

///4f7c