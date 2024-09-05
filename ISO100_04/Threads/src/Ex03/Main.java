package Ex03;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int tamanho = 1000;
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(100) + 1;
        }

        Thread thread1 = new Thread(new ThreadVetor(1, vetor));
        Thread thread2 = new Thread(new ThreadVetor(2, vetor));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}