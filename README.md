# Hangman Game (Console – Java)

A simple **console-based Hangman game** written in Java.
Players choose a **word category**, then try to guess the hidden word letter by letter.

This project focuses on:

* clean console interaction
* file-based word packs
* basic game-loop logic
* input validation

---

## ▶️ How to Play (Quick Start)

When you run the game, you will first see a **menu of word categories**:

```
-------------------------------
Welcome to the Hangman Game!
Choose your word pack please!
1. Daily Life
2. Nature & Plants
3. Education & Learning
4. Psychology & Mind
5. Finance & Economics
6. Technology
7. Music
```

### Step-by-step

1. **Enter a number (1–7)** to choose a word category.
2. The game loads a random word from the selected category.
3. The word is shown as **underscores (`_`)**, with spaces preserved.
4. **Type one letter at a time** to guess the word.
5. Correct guesses reveal letters in the word.
6. Wrong guesses reduce your remaining attempts.
7. Duplicate letter guesses are detected and blocked.
8. You **win** when all letters are revealed.
9. You **lose** if you run out of allowed wrong guesses.

Example:

```
Your word is:
_ _ _ _ _  _ _ _ _ _

Enter a letter:
a
```

---

## 🎮 How the Game Works (Internals)

1. The game displays a **menu of word categories**.
2. The player selects a category by entering a number.
3. Words are loaded from a corresponding **text file**.
4. One word is chosen randomly.
5. The player guesses letters until the word is fully revealed.
6. Duplicate guesses are detected and prevented.
7. The game ends when the word is completely guessed or guesses run out.

---

## 📂 Project Structure

```
HangmanGame
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org.example
│   │   │       ├── Main.java
│   │   │       ├── Hangman.java
│   │   │       └── WordListReader.java
│   │   └── resources
│   │       ├── daily.txt
│   │       ├── plants.txt
│   │       ├── education.txt
│   │       ├── psychology.txt
│   │       ├── finance.txt
│   │       ├── technology.txt
│   │       └── music.txt
```

---

## 🧠 Class Overview

### `Main`

Responsible for:

* displaying the menu
* handling user input
* validating category selection
* loading word packs
* starting the game loop

---

### `Hangman`

Responsible for:

* masking the original word
* tracking guessed letters
* handling guesses
* counting wrong attempts
* checking win / lose conditions

---

### `WordListReader`

Responsible for:

* loading words from text files
* reading one word or phrase per line
* storing words in memory for the game

Text files are loaded from the **classpath** using `resources/`.

---

## 🗂 Word Packs

Each word pack is a `.txt` file where:

* each line represents **one word or phrase**
* spaces are allowed

Example:

```
stock market
interest rate
inflation
```

Available categories:

* Daily Life
* Nature & Plants
* Education & Learning
* Psychology & Mind
* Finance & Economics
* Technology
* Music

---

## ▶️ How to Run

1. Open the project in IntelliJ IDEA (or any Java IDE).
2. Make sure the text files are inside:

   ```
   src/main/resources
   ```
3. Run `Main`.
4. Choose a category number.
5. Start guessing letters.

---

## 🛠 Technologies Used

* Java
* Scanner (console input)
* Collections (`Map`, `Set`, `ArrayList`)
* File I/O via `BufferedReader`

---

## 🚀 Possible Improvements

* Add visual Hangman stages (ASCII art)
* Display remaining attempts after each guess
* Add replay option
* Separate game logic into a `HangmanGame` class
* Add difficulty levels
* Track scores across rounds

---

## 📌 Notes

* The game is case-insensitive.
* Duplicate letter guesses are handled gracefully.
* Word files are loaded dynamically based on user choice.

---

Have fun playing and improving the game 🎉
