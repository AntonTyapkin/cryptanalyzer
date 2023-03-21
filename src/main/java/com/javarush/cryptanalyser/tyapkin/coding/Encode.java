package com.javarush.cryptanalyser.tyapkin.coding;

import com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet;
import com.javarush.cryptanalyser.tyapkin.service.Function;

import static com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet.ALPHABET;


public abstract class Encode implements Function {

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
}