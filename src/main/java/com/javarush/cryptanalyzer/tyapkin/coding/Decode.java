package com.javarush.cryptanalyzer.tyapkin.coding;
import com.javarush.cryptanalyzer.tyapkin.service.Function;

import static com.javarush.cryptanalyzer.tyapkin.constants.cryptoAlphabet.ALPHABET;


public abstract class Decode implements Function {

    public static String decrypt(String cipherText, int shiftKey) {

        StringBuilder message = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % ALPHABET.length();
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            message.append(replaceVal);
        }
        return message.toString();
    }
}
