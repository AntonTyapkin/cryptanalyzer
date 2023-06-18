package com.javarush.cryptanalyser.tyapkin.service.coding;

import java.io.*;

import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.INPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.OUTPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet.ALPHABET;


public class Decode {


    public static String decrypt(String cipherText, int shiftKey) {

        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            int index = ALPHABET.indexOf(cipherText.charAt(i));
            if (index == -1) {
                decryptedText.append(cipherText.charAt(i));
            } else if ((index - shiftKey) < 0) {
                int offsetTemp = shiftKey - (index + 1);
                decryptedText.append(ALPHABET.charAt(ALPHABET.length() - 1 - offsetTemp));
            } else {
                decryptedText.append(ALPHABET.charAt(index - shiftKey));
            }
        }
        return decryptedText.toString();
    }

    public static void decryptFile(String inputFileName, String outputFileName, int key) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decrypt(line, key);

                writer.write(decryptedLine);
                writer.newLine();
            }

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }

    }

    public static String BrutForceDecode(String textToDecode) {
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
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


