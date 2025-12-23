package org.example;

import java.util.HashSet;
import java.util.Set;

public class Hangman {
    private final String originalWord;
    private char[] maskedWord;
    private Set<Character> guessedLetters = new HashSet<Character>();

    public Hangman(String originalWord) {
        this.originalWord = originalWord;
        this.maskedWord = maskWord(originalWord);
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public char[] getMaskedWord() {
        return maskedWord;
    }

    private char[] maskWord(String word) {
        char[] currentWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != 32) {
                currentWord[i] = '_';
            } else {
                currentWord[i] = ' ';
            }
        }

        return currentWord;
    }

    public boolean isWon() {
        return originalWord.equals(new String(maskedWord));
    }

    public boolean guess(char letter) {
        if (guessedLetters.contains(letter)) {
            System.out.println("You've already tried the letter " + letter + ". Try something else!");
            return false;
        }
        guessedLetters.add(letter);

        boolean correctGuess = false;

        if (originalWord.contains("" + letter)) {
            for (int i = 0; i < originalWord.length(); i++) {
                if (originalWord.charAt(i) == letter) {
                    maskedWord[i] = letter;
                }
            }
            System.out.println("Congrats! You guessed a letter! Now the word is: ");
            System.out.println(new String(maskedWord));
            correctGuess = true;
        } else {
            System.out.println("Wrong guess! Try again!");
        }

        return correctGuess;
    }


}
