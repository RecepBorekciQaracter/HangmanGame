package org.example;

import java.io.IOException;
import java.util.*;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Set<Character> guessedLetters = new HashSet<Character>();

        Map<Integer, String> fileNameMap = new HashMap<>();

        fileNameMap.put(1, "daily.txt");
        fileNameMap.put(2, "nature.txt");
        fileNameMap.put(3, "education.txt");
        fileNameMap.put(4, "psychology.txt");
        fileNameMap.put(5, "finance.txt");
        fileNameMap.put(6, "technology.txt");
        fileNameMap.put(7, "music.txt");

        printMenu();

        int choice = getChoice(sc, fileNameMap.size());

        String fileName = fileNameMap.get(choice);

        WordListReader wordListReader = new WordListReader();
        try {
            wordListReader.readWords(fileName);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }

        ArrayList<String> wordList = wordListReader.getWords();

        System.out.println("Now let the game begin!");

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

    }

    private static int getChoice(Scanner sc, int size){
        int choice;

        while (true) {
            System.out.print("Your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter an integer number!");
                sc.nextLine(); // discard invalid input
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice < 1 || choice > size) {
                System.out.println("Please enter a number between 1 and " + size);
                continue;
            }

            break;
        }

        System.out.println();
        return choice;
    }

    private static void printMenu() {
        System.out.println("-------------------------------");
        System.out.println("Welcome to the Hangman Game! ");
        System.out.println("Choose your word pack please!");
        System.out.println("1. Daily Life");
        System.out.println("2. Nature & Plants");
        System.out.println("3. Education & Learning");
        System.out.println("4. Psychology & Mind");
        System.out.println("5. Finance & Economics");
        System.out.println("6. Technology");
        System.out.println("7. Music");
    }

    private static String getRandomWord(ArrayList<String> wordList) {
        int randomWordDigit = (int) Math.floor((Math.random() * wordList.size()));
        String chosenWord = wordList.get(randomWordDigit);

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
