import java.util.Random;

public class Aspirador {

    private static final int TAMANHO_AMBIENTE = 5; // Tamanho do ambiente (5x5 neste exemplo)
    private static char[][] ambiente = new char[TAMANHO_AMBIENTE][TAMANHO_AMBIENTE]; // Matriz para representar o ambiente
    private static int posicaoX, posicaoY; // Posição atual do aspirador

    public static void main(String[] args) {
        // Inicialize o ambiente com sujeira
        inicializarAmbiente();

        // Posicione o aspirador em algum lugar aleatório
        posicaoX = gerarNumeroAleatorio(TAMANHO_AMBIENTE);
        posicaoY = gerarNumeroAleatorio(TAMANHO_AMBIENTE);

        System.out.println("Iniciando a limpeza...");
        mostrarAmbiente();

        // Simule a limpeza do ambiente
        while (ambienteSujo()) {
            moverAspirador();
            mostrarAmbiente();
        }

        System.out.println("Limpeza concluída!");
    }

    // Inicializa o ambiente com sujeira
    private static void inicializarAmbiente() {
        Random rand = new Random();
        for (int i = 0; i < TAMANHO_AMBIENTE; i++) {
            for (int j = 0; j < TAMANHO_AMBIENTE; j++) {
                if (rand.nextDouble() < 0.3) {
                    ambiente[i][j] = 'S'; // Sujeira
                } else {
                    ambiente[i][j] = '.'; // Espaço limpo
                }
            }
        }
    }

    // Verifica se o ambiente ainda contém sujeira
    private static boolean ambienteSujo() {
        for (int i = 0; i < TAMANHO_AMBIENTE; i++) {
            for (int j = 0; j < TAMANHO_AMBIENTE; j++) {
                if (ambiente[i][j] == 'S') {
                    return true;
                }
            }
        }
        return false;
    }

    // Move o aspirador para uma posição adjacente
    private static void moverAspirador() {
        Random rand = new Random();
        int direcao = rand.nextInt(4); // 0: Norte, 1: Sul, 2: Leste, 3: Oeste

        int novaPosX = posicaoX;
        int novaPosY = posicaoY;

        switch (direcao) {
            case 0:
                novaPosX--;
                break;
            case 1:
                novaPosX++;
                break;
            case 2:
                novaPosY++;
                break;
            case 3:
                novaPosY--;
                break;
        }

        if (novaPosX >= 0 && novaPosX < TAMANHO_AMBIENTE && novaPosY >= 0 && novaPosY < TAMANHO_AMBIENTE) {
            if (ambiente[novaPosX][novaPosY] == 'S') {
                ambiente[novaPosX][novaPosY] = '.';
            }
            posicaoX = novaPosX;
            posicaoY = novaPosY;
        }
    }

    // Mostra o estado atual do ambiente
    private static void mostrarAmbiente() {
        for (int i = 0; i < TAMANHO_AMBIENTE; i++) {
            for (int j = 0; j < TAMANHO_AMBIENTE; j++) {
                System.out.print(ambiente[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Gera um número aleatório no intervalo [0, max)
    private static int gerarNumeroAleatorio(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }
}
