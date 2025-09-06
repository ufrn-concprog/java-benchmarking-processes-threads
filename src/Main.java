/**
 * Main driver class
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class Main {
    // Number of work units to create
    private static final int NUM_WORKERS = 1000;

    /**
     * Main method
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Benchmarking creation of processes vs threads:\n");

        // TODO Allow for multiple runs (at least 20) for empirical validity and
        //  record mean and standard deviation
        Benchmark.benchmarkProcesses("Processes", NUM_WORKERS);
        Benchmark.benchmarkChildProcesses("Child Processes", NUM_WORKERS);
        Benchmark.benchmarkThreads("Threads", NUM_WORKERS);
    }
}