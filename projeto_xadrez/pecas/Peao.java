package projeto_xadrez.pecas;

public class Peao extends Peca {
    private boolean jaMoveu;

    public Peao(String cor) {
        super(cor);
        this.jaMoveu = false;
    }

    public boolean getJaMoveu() {
        return jaMoveu;
    }

    public void setJaMoveu(boolean jaMoveu) {
        this.jaMoveu = jaMoveu;
    }

    @Override
    public String desenho() {
        return "P";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (linhaO == linhaD && colunaO == colunaD) return false;

        int direcao = getCor().equals("branco") ? 1 : -1;
        int difLinha = linhaD - linhaO;
        int difColuna = Math.abs(colunaD - colunaO);

        if (difLinha == direcao && difColuna == 0) return true;
        if (difLinha == 2 * direcao && difColuna == 0 && !jaMoveu) return true;
        if (difLinha == direcao && difColuna == 1) return true;

        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        if (!movimentoValido(linhaO, colunaO, linhaD, colunaD)) return "";

        StringBuilder caminho = new StringBuilder();
        int direcao = getCor().equals("branco") ? 1 : -1;
        int difLinha = Math.abs(linhaD - linhaO);

        caminho.append(linhaO).append(colunaO);
        if (difLinha == 2) caminho.append(linhaO + direcao).append(colunaO);
        caminho.append(linhaD).append(colunaD);

        return caminho.toString();
    }
}