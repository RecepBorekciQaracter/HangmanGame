package org.example;

import java.io.*;
import java.util.ArrayList;

public class WordListReader {
    private ArrayList<String> words;

    public WordListReader() {
        this.words = new ArrayList<String>();
    }

    public void readWords(String fileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(fileName)
        ));

        String line;
        while ((line = br.readLine()) != null) {
            words.add(line);
        }
    }

    public ArrayList<String> getWords() {
        return words;
    }


}
