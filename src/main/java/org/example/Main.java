package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static void main() {
        String[] wordList = {"athletics", "aerobics", "bowling", "bungee jumping", "cycling", "darts", "fencing", "fishing", "football", "hiking"};
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Set<Character> guessedLetters = new HashSet<Character>();

        System.out.println("-------------------------------");
        System.out.println("Welcome to the Hangman Game! ");
        System.out.println("Press 1 to start!");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                String currentWord = getRandomWord(wordList);
                char[] convertedWord = convertWord(currentWord, sb);

                System.out.println("Your word is: ");
                System.out.println(currentWord);
                System.out.println(convertedWord);
                System.out.println("Now, enter a letter to guess the word!");

                while (!currentWord.equals(new String(convertedWord))) {
                    char guess = sc.next().toLowerCase().charAt(0);
                    if (guessedLetters.contains(guess)) {
                        System.out.println("You've already tried the letter " + guess + ". Try something else!");
                        continue;
                    }
                    guessedLetters.add(guess);

                    if (currentWord.contains("" + guess)) {
                        for (int i = 0; i < currentWord.length(); i++) {
                            if (currentWord.charAt(i) == guess) {
                                convertedWord[i] = guess;
                            }
                        }
                        System.out.println("Congrats! You guessed a letter! Now the word is: ");
                        System.out.println(new String(convertedWord));
                    } else {
                        System.out.println("Wrong guess! Try again!");
                    }


                }

                System.out.println();
                System.out.println("Congratulations! You won!");
                System.out.println("The word was: " + currentWord);
                break;

        }


    }

    private static String getRandomWord(String[] wordList) {
        int randomWordDigit = (int) Math.floor((Math.random() * wordList.length));
        String chosenWord = wordList[randomWordDigit];

        return chosenWord;
    }

    private static char[] convertWord(String originalWord,  StringBuilder sb) {
        char[] currentWord;
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) != 32) {
                sb.append("_");
            } else {
                sb.append(" ");
            }
        }

        currentWord = sb.toString().toCharArray();

        return currentWord;
    }
}
