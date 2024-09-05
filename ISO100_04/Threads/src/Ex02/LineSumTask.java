package Ex02;

class LineSumTask implements Runnable {
    private final int[] line;
    private final int lineIndex;

    public LineSumTask(int[] line, int lineIndex) {
        this.line = line;
        this.lineIndex = lineIndex;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int value : line) {
            sum += value;
        }
        System.out.println("Linha " + lineIndex + ": Soma = " + sum);
    }
}

