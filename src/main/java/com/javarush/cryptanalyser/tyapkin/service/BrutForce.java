package com.javarush.cryptanalyser.tyapkin.service;
import java.io.*;

import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.INPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.OUTPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.service.coding.Decode.decrypt;
import static com.javarush.cryptanalyser.tyapkin.service.coding.Decode.decryptFile;
import static com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet.ALPHABET;

public class BrutForce {

    public String BrutForceDecode(String textToDecode) throws Exception {
        int key;
        int maxMatches = 0;
        int bestKey = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (key = 0; key < ALPHABET.length(); key++) {
                    String decryptedLine = decrypt(line, key);
                    int matches = countMatches(decryptedLine);
                    if (matches > maxMatches) {
                        maxMatches = matches;
                        bestKey = key;
                    }
                }
            }
            decryptFile(INPUT_FILE_NAME, OUTPUT_FILE_NAME, bestKey);
        }
        return textToDecode;
    }
    private static int countMatches(String text) {
        int matches = 0;
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (word.matches("[а-яА-Я][.,\":;\\-!?] * $")) {
                matches++;
            }
        }
        return matches;
    }
}
