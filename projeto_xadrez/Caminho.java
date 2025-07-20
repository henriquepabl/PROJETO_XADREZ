package projeto_xadrez;
import java.util.ArrayList;

public class Caminho {
    private final ArrayList<Casa> casas;

    public Caminho(String movimento, Tabuleiro tabuleiro) {
        if (movimento.length() % 2 != 0) {
            throw new IllegalArgumentException("Formato inválido do movimento: tamanho ímpar");
        }

        casas = new ArrayList<>();
        inserirCasas(movimento, tabuleiro);
    }

    public Casa casaInicial() {
        if (casas.isEmpty()) {
            throw new IllegalStateException("Caminho vazio não possui casa inicial");
        }

        return casas.get(0);
    }

    public Casa casaFinal() {
        if (casas.isEmpty()) {
            throw new IllegalStateException("Caminho vazio não possui casa final");
        }

        return casas.get(casas.size()-1);
    }

    public boolean estaLivre() {
        for (int i = 1; i < casas.size() - 1; i++) { 
            if (!casas.get(i).estaVazia()) {
                return false;
            }
        }
        
        return true;
    }

    private void inserirCasas(String movimento, Tabuleiro tabuleiro) {
        for (int i = 0; i < movimento.length(); i += 2) {
            int linha = movimento.charAt(i) -'0';
            char coluna = movimento.charAt(i + 1);

            try {
                casas.add(tabuleiro.getCasa(linha, coluna));
            }
            catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Posição fora dos limites: " + linha + coluna, e);
            }
        }
    }
}