import java.util.Scanner;

public abstract class InputReader {
    protected Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract char readInput();
}