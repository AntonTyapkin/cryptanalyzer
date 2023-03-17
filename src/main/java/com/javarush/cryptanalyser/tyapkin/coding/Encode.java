package com.javarush.cryptanalyser.tyapkin.coding;
import com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet;
import com.javarush.cryptanalyser.tyapkin.service.Function;


public abstract class Encode implements Function {

        public static String encrypt (String text, int shiftKey){

            StringBuilder message = new StringBuilder(" ");
            for (int i = 0; i < text.length(); i++) {
                int charPosition = cryptoAlphabet.ALPHABET.indexOf(text.charAt(i));
                int keyVal = (shiftKey + charPosition) % cryptoAlphabet.ALPHABET.length();
                char replaceVal = cryptoAlphabet.ALPHABET.charAt(keyVal);
                message.append(replaceVal);

            }
            return message.toString();
        }
    }
