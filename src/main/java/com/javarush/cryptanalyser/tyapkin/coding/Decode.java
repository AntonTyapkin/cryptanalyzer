package com.javarush.cryptanalyser.tyapkin.coding;
import com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet;
import com.javarush.cryptanalyser.tyapkin.service.Function;

import static com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet.ALPHABET;


public abstract class Decode implements Function {

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
}
