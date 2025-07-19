package projeto_xadrez;

import java.util.Scanner;
import projeto_xadrez.pecas.*;

public class Jogador {
    private final String nome;
    private final String cor;
    private Peca[] pecas;

    public Jogador(String cor, Peca[] pecas) {
        this.cor = cor;
        this.pecas = pecas;
        this.nome = solicitarNome();
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
        Scanner scan = new Scanner(System.in);
        String nome;
        
        while (true) {
            try {
                System.out.println("Jogador "+ getCor()+ ", digite seu nome: ");
                nome = scan.nextLine().replaceAll(" ", "");

                if (nome.isEmpty()) {
                    throw new IllegalArgumentException("Nome não pode estar vazio");
                }

                return nome;
            }
            catch (IllegalArgumentException msg) {
                System.out.println("Nome inválido: "+ msg.getMessage());
            }
        }
    }
}