package projeto_xadrez;
import java.util.ArrayList;

public class Caminho{

    private ArrayList<Casa> casas;
    private Tabuleiro tabuleiro;

    public Caminho(String movimento,Tabuleiro T){
        tabuleiro = T;
        casas = new ArrayList<>();
        inserirCasas(movimento);
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

    private void inserirCasas(String movimento){
        int i = 0;
        while(i<movimento.length()-1){
            casas.add(tabuleiro.getCasa(movimento.charAt(i++) -'0',movimento.charAt(i++)));
        }
    }
}