/**
 * Task to be executed by processes and threads.
 * It is intentionally trivial.
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class Task {
    /**
     * Task to be executed.
     * It actually does nothing to avoid interfering with the benchmark.
     */
    public static void doTask() {
        // Does nothing
    }

    /**
     * Method to execute the task if this class runs as a separate process
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        doTask();
    }
}
