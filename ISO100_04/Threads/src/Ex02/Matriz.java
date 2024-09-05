package Ex02;

import java.util.Random;

public class Matriz {

    public static void main(String[] args) {
        final int rows = 3;
        final int cols = 5;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        System.out.println("Matriz:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        Thread[] threads = new Thread[rows];
        for (int i = 0; i < rows; i++) {
            threads[i] = new Thread(new LineSumTask(matrix[i], i));
            threads[i].start();
        }

        for (int i = 0; i < rows; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}