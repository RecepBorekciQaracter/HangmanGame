# Changelog

## Phase 1 — Critical Bug Fixes

### BUG-1: Off-by-one error in `isGuessesLeft()` (Hangman.java)

**Problem:** `return wrongGuessCount + 1 < WRONG_GUESS_LIMIT;` caused the game to allow only 4 wrong guesses instead of the intended 5.

**Fix:** Removed the `+1` — changed to `return wrongGuessCount < WRONG_GUESS_LIMIT;`.

### BUG-2: Game loop asked for input after the player had already lost (Main.java)

**Problem:** The loop checked `isWon()` at the top, read user input, then checked `isGuessesLeft()`. After the final wrong guess, the player was prompted for one extra letter before being told they lost.

**Fix:** Changed the loop condition to `while (!hangman.isWon() && hangman.isGuessesLeft())`. Added a post-loop check to distinguish win from loss. This also removed the `System.exit(0)` call (BUG-12) in favor of a graceful loop exit.

### BUG-3: Case-sensitivity mismatch made some words unwinnable (Hangman.java)

**Problem:** User input was lowercased, but `originalWord` was stored in its original case. Words containing uppercase letters (e.g., `AI (artificial intelligence)`) could never be matched or won.

**Fix:** Normalized `originalWord` to lowercase in the `Hangman` constructor: `this.originalWord = originalWord.toLowerCase();`.

### BUG-4: Word pack contained unguessable special characters (technology.txt, Hangman.java)

**Problem:** `technology.txt` contained `AI (artificial intelligence)` — parentheses were masked as `_` and required the player to guess `(` and `)` as characters, which is unintuitive and undocumented.

**Fix (data):** Changed the word to `artificial intelligence`.

**Fix (code):** Updated `maskWord()` to only mask `Character.isLetter()` characters as `_`. All non-letter characters (spaces, punctuation, etc.) are now revealed automatically. This makes the game resilient to any future word entries containing punctuation.

### BUG-5: Non-standard `main()` method signature (Main.java)

**Problem:** `static void main()` (package-private, no `String[] args`) only works with Java 23+'s flexible launch protocol (JEP 477). The README claims Java 17+ compatibility, but the program would not launch on Java 17–22.

**Fix:** Changed to the standard `public static void main(String[] args)`.

### BUG-10: `pom.xml` targeted Java 25 (pom.xml)

**Problem:** `maven.compiler.source` and `maven.compiler.target` were set to `25`, contradicting the README's "Java 17 (or higher)" claim and preventing compilation on most systems.

**Fix:** Lowered both to `17` to match the README.

### BUG-12: `System.exit(0)` used for game over (Main.java)

**Problem:** `System.exit(0)` terminates the entire JVM, preventing cleanup, replay, or embedding the game in a larger application.

**Fix:** Resolved as part of BUG-2 — the refactored game loop exits naturally and uses a post-loop conditional to print the appropriate win/loss message.

### BUG-13: Misleading remaining guesses message (Hangman.java)

**Problem:** `"Wrong guess! Try again! You have X wrong guesses remaining!"` was confusing phrasing — "wrong guesses remaining" was ambiguous.

**Fix:** Reworded to `"Wrong guess! You have X attempts remaining."`.

---

### Files Modified

| File | Changes |
|---|---|
| `src/main/java/org/example/Main.java` | Fixed `main()` signature; refactored game loop |
| `src/main/java/org/example/Hangman.java` | Fixed off-by-one; added case normalization; improved masking logic; reworded message |
| `src/main/resources/technology.txt` | Changed `AI (artificial intelligence)` to `artificial intelligence` |
| `pom.xml` | Lowered Java source/target from 25 to 17 |
| `CHANGELOG.md` | Added (this file) |
