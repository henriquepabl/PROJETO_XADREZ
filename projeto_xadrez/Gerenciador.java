package projeto_xadrez;

import java.util.Scanner;

public class Gerenciador {
    private Tabuleiro tabuleiro;
    private boolean jogoEmAndamento;

    public Gerenciador() {
        tabuleiro = new Tabuleiro();
        jogoEmAndamento = false;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Novo Jogo");
            System.out.println("2. Carregar Jogo");
            System.out.println("3. Salvar Jogo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    novoJogo();
                    break;
                case 2:
                    carregarJogo();
                    break;
                case 3:
                    salvarJogo();
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private void novoJogo() {
        tabuleiro = new Tabuleiro();
        jogoEmAndamento = true;
        System.out.println("\nNovo jogo iniciado!");
        System.out.println(tabuleiro.desenho());

        // TODO: Implementar lógica de controle do jogo
        // - Alternar turnos entre jogadores
        // - Validar movimentos
        // - Verificar xeque/xeque-mate
    }

    private void carregarJogo() {
        // TODO: Implementar carregamento de jogo a partir de arquivo
        // - Ler estado do tabuleiro de um arquivo
        // - Restaurar posições das peças
        // - Continuar jogo interrompido
        System.out.println("Funcionalidade de carregar jogo será implementada na semana 3");
    }

    private void salvarJogo() {
        // TODO: Implementar salvamento do jogo em arquivo
        // - Salvar estado atual do tabuleiro
        // - Armazenar posições de todas as peças
        // - Salvar histórico de jogadas
        System.out.println("Funcionalidade de salvar jogo será implementada na semana 3");
    }

    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        gerenciador.iniciar();
    }
}