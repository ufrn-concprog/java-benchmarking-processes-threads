package benchmark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with the implementation of the three benchmarks
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class Benchmark {
    /**
     * benchmark.Benchmark threads
     * @param label Label for the benchmark
     * @param numThreads Number of threads to create
     */
    public static void benchmarkThreads(String label, int numThreads) {
        long startTime = System.nanoTime();

        List<Thread> workers = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Thread t = new Thread(Task::doTask);
            workers.add(t);
            t.start();
        }


        try {
            for (Thread t : workers) {
                t.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.nanoTime();
        System.out.printf("%-16s| %.4f seconds for %d threads%n",
                label, (endTime - startTime) / 1e9, numThreads);
    }

    /**
     * benchmark.Benchmark processes
     * @param label Label for the benchmark
     * @param numProcesses Number of processes to create
     */
    public static void benchmarkProcesses(String label, int numProcesses) {
        long startTime = System.nanoTime();

        createMultipleProcesses(numProcesses);

        long endTime = System.nanoTime();
        System.out.printf("%-16s| %.4f seconds for %d processes%n",
                label, (endTime - startTime) / 1e9, numProcesses);
    }

    /**
     * Create multiple processes
     * @param numProcesses Number of processes to create
     */
    static void createMultipleProcesses(int numProcesses) {
        List<Process> workers = new ArrayList<>();
        try {
            for (int i = 0; i < numProcesses; i++) {
                Process p = new ProcessBuilder(
                        "java", "-cp", System.getProperty("java.class.path"), "benchmark.Task")
                        .inheritIO()
                        .start();
                workers.add(p);
            }

            for (Process p : workers) {
                p.waitFor();
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * benchmark.Benchmark child processes via a parent process
     * @param label Label for the benchmark
     * @param numChildProcesses Number of child processes to create
     */
    public static void benchmarkChildProcesses(String label, int numChildProcesses) {
        long startTime = System.nanoTime();

        try {
            // Launch a parent process that spawns child processes
            Process parent = new ProcessBuilder(
                    "java", "-cp", System.getProperty("java.class.path"),
                    "benchmark.ParentProcess", Integer.toString(numChildProcesses))
                    .inheritIO()
                    .start();
            parent.waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.nanoTime();
        System.out.printf("%-16s| %.4f seconds for %d child processes (via parent process)%n",
                label, (endTime - startTime) / 1e9, numChildProcesses);
    }
}
