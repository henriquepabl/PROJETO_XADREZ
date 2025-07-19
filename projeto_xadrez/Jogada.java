package projeto_xadrez;

public class Jogada {
    String movimento;
    Jogador jogador;
    Caminho caminho;

    public Jogada(String movimento, Jogador jogador, Tabuleiro tabuleiro) {
        this.movimento = movimento;
        this.jogador = jogador;
        this.caminho = new Caminho(getMovimentoPeca(tabuleiro), tabuleiro);
    }
    
    public boolean ehValida() {
        if(!Nolimite())return false;
        if(!pecaDoJogador())return false;
        
        

        return true;
    }
    
    public boolean ehXeque() {return false;}

    public boolean ehXequeMate() {return false;}

    private String getMovimentoPeca(Tabuleiro tabuleiro) {
        linhaO = movimento.charAt(0) - '0';
        colunaO = movimento.charAt(1);
        linhaD = movimento.charAt(2) - '0';
        colunaO = movimento.charAt(3);
        
        return tabuleiro.getCasa(linhaO,colunaO).getPeca().caminho(linhaO,colunaO,linhaD,colunaD);
    }
    
    private boolean pecaDoJogador() {
        return caminho.casaInicial().getPeca().getCor() == jogador.getCor();
    }
}