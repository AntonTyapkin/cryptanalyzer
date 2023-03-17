package com.javarush.cryptanalyser.tyapkin.coding;
import com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet;
import com.javarush.cryptanalyser.tyapkin.service.Function;


public abstract class Decode implements Function {

    public static String decrypt(String cipherText, int shiftKey) {

        StringBuilder message = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            int charPosition = cryptoAlphabet.ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % cryptoAlphabet.ALPHABET.length();
            if (keyVal < 0) {
                keyVal = cryptoAlphabet.ALPHABET.length() + keyVal;
            }
            char replaceVal = cryptoAlphabet.ALPHABET.charAt(keyVal);
            message.append(replaceVal);
        }
        return message.toString();
    }
}
