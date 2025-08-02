public interface Game {
    void start();
    void guessLetter(char letter);
    boolean isGameOver();
    boolean isGameWon();
}