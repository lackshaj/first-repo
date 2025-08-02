import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Main Hangman game class - handles game initialization and flow
public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharacterInputReader inputReader = new CharacterInputReader(scanner);

        System.out.println("Welcome to Hangman!");
        System.out.println("Choose difficulty level: Easy, Medium, Hard");
        String difficulty = scanner.nextLine().trim().toLowerCase();

        String secretWord = selectWord(difficulty);
        if (secretWord == null) {
            System.out.println("Error: Could not load words for the selected difficulty.");
            return;
        }

        AbstractHangman game;
        switch (difficulty) {
            case "easy":
                game = new EasyHangman(secretWord);
                break;
            case "medium":
                game = new MediumHangman(secretWord);
                break;
            case "hard":
                game = new HardHangman(secretWord);
                break;
            default:
                System.out.println("Invalid difficulty. Defaulting to Easy.");
                game = new EasyHangman(secretWord);
        }

        game.start();

        while (!game.isGameOver()) {
            char letter = inputReader.readInput();
            game.guessLetter(letter);
        }

        if (game.isGameWon()) {
            System.out.println("Congratulations! You guessed the word: " + game.secretWord);
        } else {
            System.out.println("Game Over! The word was: " + game.secretWord);
        }

        scanner.close();
    }

    private static String selectWord(String difficulty) {
        try {
            List<String> words = Files.readAllLines(Paths.get("src/words.txt"));
            List<String> filteredWords = new ArrayList<>();

            // Filter words based on the difficulty level
            for (String line : words) {
                String[] parts = line.split(" ");
                if (parts.length == 2 && parts[1].equalsIgnoreCase(difficulty)) {
                    filteredWords.add(parts[0]);
                }
            }

            if (filteredWords.isEmpty()) {
                return null; // No words found for the selected difficulty
            }

            // Select a random word from the filtered list
            Random random = new Random();
            return filteredWords.get(random.nextInt(filteredWords.size()));
        } catch (IOException e) {
            System.out.println("Error reading words.txt: " + e.getMessage());
            return null;
        }
    }
}