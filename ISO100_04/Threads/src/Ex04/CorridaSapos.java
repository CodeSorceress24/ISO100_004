package Ex04;

public class CorridaSapos {
    public static void main(String[] args) {
        final int NUM_SAPOS = 5;
        final double DISTANCIA_MAXIMA = 100.0;
        final double TAMANHO_MAXIMO_SALTO = 10.0;

        Thread[] sapos = new Thread[NUM_SAPOS];
        String[] nomes = {"Sapo 1", "Sapo 2", "Sapo 3", "Sapo 4", "Sapo 5"};

        for (int i = 0; i < NUM_SAPOS; i++) {
            sapos[i] = new Thread(new Sapo(nomes[i], DISTANCIA_MAXIMA, TAMANHO_MAXIMO_SALTO));
            sapos[i].start();
        }

        for (int i = 0; i < NUM_SAPOS; i++) {
            try {
                sapos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("A corrida acabou!");
    }
}