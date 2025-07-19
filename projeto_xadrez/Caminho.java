package projeto_xadrez;
import java.util.ArrayList;

public class Caminho{

    private ArrayList<Casa> casas;
    private Tabuleiro tabuleiro;

    public Caminho(String jogada,Tabuleiro T){
        tabuleiro = T;
        casas = new ArrayList<>();
        inserirCasas(jogada);
    }

    public Casa casaFinal(){
        return casas.get(casas.size()-1);
    }

    public Casa casaInicial(){
        return casas.get(0);
    }

    public boolean estaLivre(){
        for(int i = 1; i < casas.size() - 1; i++){ 
            if(!casas.get(i).estaVazia()){
                return false;
            }
        }
        return true;
    }

    private void inserirCasas(String jogada){
        int i = 0;
        while(i<jogada.length()-1){
            casas.add(tabuleiro.getCasa(jogada.charAt(i++) -'0',jogada.charAt(i++)));
        }
    }
}