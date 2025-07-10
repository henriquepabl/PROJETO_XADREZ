package projeto_xadrez;

import java.util.Scanner;
import projeto_xadrez.pecas.*;

public class Jogador {
    private final String nome;
    private final String cor;
    private Peca[] pecas;

    public Jogador(String nome, String cor, Peca[] pecas) {
        this.nome = nome;
        this.cor = cor;
        this.pecas = pecas;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }
    
    public String informaJogada() {
        Scanner in = new Scanner(System.in);

        System.out.println("Insira jogada (ou 'parar' para encerrar):");

        return in.nextLine().trim();;
    }

    public String pecasCapturadas() {
        StringBuilder capturadas = new StringBuilder();

        for (Peca p : pecas) {
            if (p != null && p.getCapturada()) {
                capturadas.append(p.desenho()).append(" ");
            }
        }

        return capturadas.toString();
    }
}