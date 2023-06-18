package com.javarush.cryptanalyser.tyapkin.service.coding;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.OUTPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet.ALPHABET;


public class Encode {

    public static String encrypt(String text, int shiftKey) {

        StringBuilder cryptoText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {

            int index = ALPHABET.indexOf(text.charAt(i));
            if (index == -1) {
                cryptoText.append(text.charAt(i));
            } else if ((index + shiftKey) >= ALPHABET.length()) {
                int offsetTemp = shiftKey - (ALPHABET.length() - 1 - index);
                cryptoText.append(ALPHABET.charAt(offsetTemp - 1));
            } else {
                cryptoText.append(ALPHABET.charAt(index + shiftKey));
            }
        }
        return cryptoText.toString();
    }
    public static void encryptFile(String inputFileName, String outPutFileName, int key) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outPutFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = encrypt(line, key);
                writer.write(decryptedLine);
                writer.newLine();
            }

        }
    }
}