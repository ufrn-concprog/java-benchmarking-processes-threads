import java.io.IOException;

/**
 * A process that spawns child processes
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class ParentProcess {
    /**
     * Spawns child processes
     * @param args Number of child processes to create
     */
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        Benchmark.createMultipleProcesses(count);
    }
}
