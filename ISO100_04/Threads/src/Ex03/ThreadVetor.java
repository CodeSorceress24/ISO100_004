package Ex03;

class ThreadVetor implements Runnable {
    private final int valor;
    private final int[] vetor;

    public ThreadVetor(int valor, int[] vetor) {
        this.valor = valor;
        this.vetor = vetor;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        
        if (valor % 2 == 0) {
            for (int i = 0; i < vetor.length; i++) {
                int temp = vetor[i];
            }
        } else {
            for (int num : vetor) {
                int temp = num;
            }
        }

        long endTime = System.nanoTime();
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Tempo gasto (em segundos) para valor " + valor + ": " + elapsedTimeInSeconds);
    }
}

