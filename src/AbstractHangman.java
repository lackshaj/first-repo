public abstract class AbstractHangman implements Game {
    protected String secretWord;
    protected StringBuilder currentWord;
    protected int attemptsLeft;
    protected int maxAttempts;

    // Constructor to initialize the game state
    public AbstractHangman(String secretWord, int maxAttempts) {
        this.secretWord = secretWord.toLowerCase();
        this.maxAttempts = maxAttempts;
        this.attemptsLeft = maxAttempts;
        this.currentWord = new StringBuilder("_".repeat(secretWord.length()));
    }

    // Method to start the game
    @Override
    public void start() {
        System.out.println("Game started! The word has " + secretWord.length() + " letters.");
        System.out.println("Current Word: " + currentWord);
        System.out.println("You have " + attemptsLeft + " attempts. Good luck!");
    }

    // Method to process a guessed letter
    @Override
    public void guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        boolean found = false;

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                currentWord.setCharAt(i, letter);
                found = true;
            }
        }

        if (!found) {
            attemptsLeft--;
        }

        displayCurrentState();
    }

    // Check if the game is over (either won or out of attempts)
    @Override
    public boolean isGameOver() {
        return attemptsLeft <= 0 || isGameWon();
    }

    // Check if the player has won the game
    @Override
    public boolean isGameWon() {
        return currentWord.toString().equals(secretWord);
    }

    // Display the current state of the game
    protected void displayCurrentState() {
        System.out.println("Current Word: " + currentWord);
        System.out.println("Attempts Left: " + attemptsLeft);
    }
}