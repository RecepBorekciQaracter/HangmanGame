# Hangman Game (Console – Java)

A simple **console-based Hangman game** written in Java.
Players choose a **word category**, then try to guess the hidden word letter by letter.

This project focuses on:

* clean console interaction
* file-based word packs
* basic game-loop logic
* input validation

---

## 🎮 How the Game Works

1. The game starts and displays a **menu of word categories**.
2. The player selects a category by entering a number.
3. Words are loaded from a corresponding **text file**.
4. One word is chosen randomly.
5. The player guesses letters until the word is fully revealed.
6. Duplicate guesses are detected and prevented.
7. The game ends when the word is completely guessed.

---

## 📂 Project Structure

```
HangmanGame
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org.example
│   │   │       ├── Main.java
│   │   │       └── WordListReader.java
│   │   └── resources
│   │       ├── daily.txt
│   │       ├── nature.txt
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
* selecting the word pack
* running the game loop
* processing guesses

### `WordListReader`

Responsible for:

* loading words from text files
* reading one word per line
* storing words in a list for the game

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

* Add limited lives (classic Hangman)
* Display remaining attempts
* Add replay option
* Separate game logic into a `HangmanGame` class
* Add difficulty levels
* Track scores

---

## 📌 Notes

* The game is case-insensitive.
* Duplicate letter guesses are handled gracefully.
* Word files are loaded dynamically based on user choice.

---

Have fun playing and improving the game 🎉
