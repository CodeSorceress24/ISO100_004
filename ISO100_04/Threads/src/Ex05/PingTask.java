package Ex05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class PingTask implements Runnable {
    private static final int NUM_ITERATIONS = 10;
    private final String servidor;
    private final List<Long> tempos = new ArrayList<>();
    private final AtomicInteger completions = new AtomicInteger(0);

    public PingTask(String servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("ping", "-4", "-c", String.valueOf(NUM_ITERATIONS), servidor);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("time=")) {
                    String[] parts = line.split("time=");
                    String[] timePart = parts[1].split(" ");
                    long tempo = Long.parseLong(timePart[0]);
                    tempos.add(tempo);
                    System.out.printf("%s: Tempo de resposta = %d ms%n", servidor, tempo);
                }
            }

            process.waitFor();
            calcularTempoMedio();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void calcularTempoMedio() {
        if (tempos.isEmpty()) {
            System.out.printf("%s: Nenhum tempo de resposta foi registrado.%n", servidor);
            return;
        }
        long soma = tempos.stream().mapToLong(Long::longValue).sum();
        double media = soma / (double) tempos.size();
        System.out.printf("%s: Tempo médio de resposta = %.2f ms%n", servidor, media);
    }
}