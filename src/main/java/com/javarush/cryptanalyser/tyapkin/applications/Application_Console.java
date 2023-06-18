package com.javarush.cryptanalyser.tyapkin.applications;
import com.javarush.cryptanalyser.tyapkin.service.*;
import com.javarush.cryptanalyser.tyapkin.service.coding.Decode;

import java.util.Scanner;
import static com.javarush.cryptanalyser.tyapkin.constants.inputConstantsConsole.*;

public class Application_Console {

    /**
     * Точка входа в консоль.
     */

    public Application_Console() throws Exception {

        System.out.println(INPUT);
        Scanner userMessage = new Scanner(System.in);
        String message = userMessage.nextLine();


        switch (message) {
            case "1":
                MenuEncodeFile encodeFile = new MenuEncodeFile();
                break;
            case "2":
                MenuDecodeFile decodeFile = new MenuDecodeFile();
                break;

        }

    }

    public static class MenuDecodeFile {
        public MenuDecodeFile() throws Exception {

            Scanner userMessage = new Scanner(System.in);
            System.out.println(INPUT_CODE_DECRYPT);
            String message = userMessage.nextLine();

            switch (message) {
                case "1":
                    DecryptText decryptText = new DecryptText();
                    break;
                case "2":
                    StandardTextDecode standardTextDecrypt = new StandardTextDecode();
                    break;
                case "3":
                    LoadTextDecrypt loadTextDecrypt = new LoadTextDecrypt();
                    break;
                case "4":
//                    Decode.BrutForceDecode();

            }
        }
    }

    public static class MenuEncodeFile {

        public MenuEncodeFile() {

            Scanner userMessage = new Scanner(System.in);
            String message;

            System.out.println(INPUT_CODE_ENCRYPT);
            message = userMessage.nextLine();

            switch (message) {
                case "1":
                    EnterText enterText = new EnterText();
                    break;
                case "2":
                    LoadTextEncrypt loadText = new LoadTextEncrypt();
                    break;
                case "3":
                    StandardTextEncrypt defFail = new StandardTextEncrypt();
                    break;
            }
        }
    }
}