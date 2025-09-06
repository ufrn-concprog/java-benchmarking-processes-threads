//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.IOException;

/**
 * Main driver class
 */
public class Main {
    // Number of work units to create
    private static final int NUM_WORKERS = 1000;

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Benchmarking creation and joining of processes vs threads:\n");

        try {
            Benchmark.benchmarkProcesses("Processes", NUM_WORKERS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Benchmark.benchmarkChildProcesses("Child Processes", NUM_WORKERS);

        Benchmark.benchmarkThreads("Threads", NUM_WORKERS);
    }
}