import java.util.HashSet;
import java.util.Scanner; // Import the Scanner class
import java.util.Set;

public class CharacterInputReader extends InputReader {
    private Set<Character> usedCharacters;

    public CharacterInputReader(Scanner scanner) {
        super(scanner);
        this.usedCharacters = new HashSet<>();
    }

    @Override
    public char readInput() {
        char input;
        while (true) {
            System.out.println("Enter a letter:");
            String line = scanner.nextLine().trim().toLowerCase();

            if (line.length() != 1 || !Character.isLetter(line.charAt(0))) {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }

            input = line.charAt(0);
            if (usedCharacters.contains(input)) {
                System.out.println("You already used this letter. Try again.");
            } else {
                usedCharacters.add(input);
                break;
            }
        }
        return input;
    }
}