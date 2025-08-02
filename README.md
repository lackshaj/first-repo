# Hangman Game 🎯

This is a simple **Hangman** game implemented in **Java** as part of my coursework. The game runs in the console and challenges the player to guess a hidden word one letter at a time.

## 📚 Project Description

This Java project replicates the classic Hangman word-guessing game. The player attempts to guess a randomly selected word within a limited number of incorrect guesses. The game provides visual feedback using underscores for unguessed letters and tracks the number of remaining attempts.

## 🧠 Learning Objectives

* Practice using **Java data types**, **control structures**, and **loops**
* Learn how to use **arrays** and **strings** for processing characters
* Gain experience with **methods** and **modular programming**
* Understand **input validation** and **basic game logic**

## 🚀 How It Works

1. A random word is chosen from a predefined list.
2. The user is prompted to guess one letter per turn.
3. If the guess is correct, the letter is revealed in the word.
4. If incorrect, the number of remaining guesses decreases.
5. The game ends when:

   * The user guesses the entire word ✅
   * The user runs out of attempts ❌

## 🛠️ Technologies Used

* Java (Standard Edition)
* Console I/O (Scanner class)

## 📂 Files

* `Hangman.java`: Main game logic and execution
* `words.txt` *(optional)*: A text file containing a list of words (if external word list is used)

## 🔧 How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/yourusername/hangman-java.git
   cd hangman-java
   ```
2. Compile the Java file:

   ```bash
   javac Hangman.java
   ```
3. Run the program:

   ```bash
   java Hangman
   ```

## ✅ Features

* Word guessing logic with live feedback
* Tracks and displays incorrect guesses
* Input validation (ignores repeated or invalid inputs)
* Clear win/loss messages

## 📈 Future Improvements

* Add a GUI using JavaFX or Swing
* Implement difficulty levels
* Load word list from external file

## 🧑‍💻 Author

* **Lacksha Jeyabraba**
* University of Southampton - Computer Science

## 📜 License

This project is for educational purposes and coursework submission. Not intended for commercial use.
