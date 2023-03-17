package com.javarush.cryptanalyzer.tyapkin.coding;
import com.javarush.cryptanalyzer.tyapkin.service.Function;

import static com.javarush.cryptanalyzer.tyapkin.constants.cryptoAlphabet.ALPHABET;


public abstract class Encode implements Function {

        public static String encrypt (String text, int shiftKey){

            StringBuilder message = new StringBuilder(" ");
            for (int i = 0; i < text.length(); i++) {
                int charPosition = ALPHABET.indexOf(text.charAt(i));
                int keyVal = (shiftKey + charPosition) % ALPHABET.length();
                char replaceVal = ALPHABET.charAt(keyVal);
                message.append(replaceVal);

            }
            return message.toString();
        }
    }
