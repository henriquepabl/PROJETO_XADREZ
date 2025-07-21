package projeto_xadrez;

import projeto_xadrez.pecas.*;
import java.util.Scanner;

public class Jogador {
    private final String nome;
    private final String cor;
    private final Peca[] pecas;
    private final Scanner in;

    public Jogador(String cor, Peca[] pecas, Scanner in) {
        this.cor = cor;
        this.pecas = pecas;
        this.in = in;
        this.nome = solicitarNome();
    }

    public Jogador(String cor, String nome, Peca[] pecas, Scanner in) {
        this.cor = cor;
        this.pecas = pecas;
        this.in = in;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }
    
    public String informaJogada() {
        System.out.print("\nInsira jogada (ou 'parar' para encerrar): ");

        return in.nextLine().trim();
    }

    public String pecasCapturadas() {
        StringBuilder capturadas = new StringBuilder();

        for (Peca p : pecas) {
            if (p != null && p.estaCapturada()) {
                capturadas.append(p.desenho()).append(" ");
            }
        }

        return capturadas.toString();
    }

    private String solicitarNome() {
        String nome;
        
        while (true) {
            try {
                System.out.print("\nJogador " + cor + ", digite seu nome: ");
                nome = in.nextLine().replaceAll(" ", "");

                if (nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome não pode estar vazio");
                }

                return nome;
            }
            catch (IllegalArgumentException msg) {
                System.out.println("\nNome inválido: "+ msg.getMessage());
            }
        }
    }
}