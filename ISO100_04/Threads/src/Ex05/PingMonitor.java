package Ex05;

public class PingMonitor {
    public static void main(String[] args) {
        String[] servidores = {"www.uol.com.br", "www.terra.com.br", "www.google.com.br"};
        String[] nomes = {"UOL", "Terra", "Google"};

        Thread[] threads = new Thread[servidores.length];
        for (int i = 0; i < servidores.length; i++) {
            String servidor = servidores[i];
            threads[i] = new Thread(new PingTask(servidor));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Monitoramento de ping concluído!");
    }
}