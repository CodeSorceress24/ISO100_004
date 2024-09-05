package Ex04;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class Sapo implements Runnable {
    private static final Random random = new Random();
    private static final AtomicInteger posicao = new AtomicInteger(1);

    private final String nome;
    private final double distanciaMaxima;
    private final double tamanhoMaximoSalto;
    private double distanciaPercorrida = 0;
    private int colocacao = -1;

    public Sapo(String nome, double distanciaMaxima, double tamanhoMaximoSalto) {
        this.nome = nome;
        this.distanciaMaxima = distanciaMaxima;
        this.tamanhoMaximoSalto = tamanhoMaximoSalto;
    }

    @Override
    public void run() {
        while (distanciaPercorrida < distanciaMaxima) {
            double salto = random.nextDouble() * tamanhoMaximoSalto;
            distanciaPercorrida += salto;
            distanciaPercorrida = Math.min(distanciaPercorrida, distanciaMaxima);
            System.out.printf("%s deu um salto de %.2f metros, totalizando %.2f metros percorridos.\n", nome, salto, distanciaPercorrida);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        colocacao = posicao.getAndIncrement();
        System.out.printf("%s chegou à linha de chegada! Colocação: %d\n", nome, colocacao);
    }
}
