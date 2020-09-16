import java.util.*;

public class App {
    private static Bola[] tabuleiro = new Bola[5];
    private static String[][] tentativas = new String[6][6];

    public static void main(String[] args) throws Exception {
        int tiros = 10;
        int x, y = 0;
        boolean acertou = false;

        for (int i = 0; i < 5; i++) {
            criarBola(i);
        }

        System.out.println("Bem Vindo ao Game Acerte as Bolas.");
        System.out.println("O Jogador tem 10 chances de acertar as bolas que estão distribuidas em 25 Posições.");
        System.out.println("Insira a linha/coluna e descubra onde está escondida a bola.");

        criaGrafico();
        exibTentativas();

        do {
            System.out.println("Tentativa: " + tiros);

            System.out.println("****Linha****");
            x = digiteN();

            System.out.println("****Coluna****");
            y = digiteN();

            acertou = false;

            for (int j = 0; j < tabuleiro.length; j++) {

                if (tabuleiro[j].acerta(x, y)) {

                    System.out.println("-----------------");
                    System.out.println("Parabéns: Bola Destruida");
                    System.out.println("-----------------");

                    tiros--;
                    Bola.vida--;
                    criarBola(j);
                    criaGrafico();
                    x = x + 1;
                    y = y + 1;
                    tentativas[x][y] = "Bola  ";
                    exibTentativas();
                    acertou = true;
                    break;
                }

            }
            if (acertou == false) {
                System.out.println("-----------------");
                System.out.println("Que pena, Errou");
                System.out.println("-----------------");
                tiros--;
                x = x + 1;
                y = y + 1;
                tentativas[x][y] = "Nada  ";
                exibTentativas();
            }

            if (Bola.getVida() == 0) {
                System.out.println("-----------------");
                System.out.println("Vc Ganhou");
                System.out.println("-----------------");
                break;
            }

        } while (tiros > 0);

        if (Bola.getVida() > 0) {
            System.out.println("-----------------");
            System.out.println("Vc Perdeu");
            System.out.println("-----------------");
        }

    }

    public static void criarBola(int i) {
        Random rand = new Random();
        int posX = rand.nextInt(5);
        int posY = rand.nextInt(5);
        int cont = 0;

        do {
            if ((tabuleiro[i] == null) && (cont == i)) {
                break;
            } else if (tabuleiro[cont].acerta(posX, posY)) {
                posX = rand.nextInt(5);
                posY = rand.nextInt(5);
                cont = 0;
            } else {
                cont++;
            }
        } while (cont < tabuleiro.length);

        Bola bola = new Bola(posX, posY);
        tabuleiro[i] = bola;

    }

    public static int digiteN() {

        Scanner scan = new Scanner(System.in);
        int z = 0;

        System.out.print("Digite um nº (1-5): ");
        z = scan.nextInt();

        while (z < 1 || z > 5) {
            System.out.print("Apenas números entre 1 e 5 são Aceitos.\nDigite Novamente: ");
            z = scan.nextInt();
        }
        z--;
        return z;
    }

    public static void criaGrafico() {

        for (int i = 1; i < tentativas.length; i++) {
            for (int j = 1; j < tentativas.length; j++) {
                tentativas[i][j] = "||||| ";
            }
        }

        tentativas[0][0] = "     |";
        tentativas[0][1] = "  1  |";
        tentativas[0][2] = "  2  |";
        tentativas[0][3] = "  3  |";
        tentativas[0][4] = "  4  |";
        tentativas[0][5] = "  5  |";
        tentativas[1][0] = "  1   ";
        tentativas[2][0] = "  2   ";
        tentativas[3][0] = "  3   ";
        tentativas[4][0] = "  4   ";
        tentativas[5][0] = "  5   ";
    }

    public static void exibTentativas() {

        for (int i = 0; i < tentativas.length; i++) {
            for (int j = 0; j < tentativas.length; j++) {
                System.out.print(tentativas[i][j]);
            }
            System.out.println(" ");
            System.out.println("------------------------------------");
        }

    }

}
