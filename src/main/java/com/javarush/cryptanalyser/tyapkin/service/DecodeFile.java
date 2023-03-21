package com.javarush.cryptanalyser.tyapkin.service;

import com.javarush.cryptanalyser.tyapkin.codingText.LoadTextDecrypt;
import com.javarush.cryptanalyser.tyapkin.codingText.BrutForce;
import com.javarush.cryptanalyser.tyapkin.codingText.DecryptText;
import com.javarush.cryptanalyser.tyapkin.codingText.StandardTextDecrypt;
//import com.javarush.cryptanalyser.tyapkin.codingText.StandartTextEncrypt;

import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants.*;

public class DecodeFile {
    public DecodeFile() {

        Scanner userMessage = new Scanner(System.in);

        System.out.println(INPUT_CODE);
        String message = userMessage.nextLine();

        switch (message) {
            case "1":
                DecryptText decryptText = new DecryptText();
                break;
            case "2":
                StandardTextDecrypt standardTextDecrypt = new StandardTextDecrypt();
                break;
            case "3":
                LoadTextDecrypt loadTextDecrypt = new LoadTextDecrypt();
                break;
            case "4":
                BrutForce brutForce = new BrutForce();
                break;
        }
    }
}

//                 чтение файла
//
//                try {
//                    //
//                    BufferedReader file = new BufferedReader(new FileReader(absolutePath));
//                    StringBuilder inputBuffer = new StringBuilder();
//                    String line;
//
//                    while ((line = file.readLine()) != null) {
//                        line = decrypt(line, key); // кадировка файла
//                        inputBuffer.append(line);
//                        inputBuffer.append('\n');
//                    }
//                    file.close();
//
//                    // перезапись  файла
//                    FileOutputStream fileOut = new FileOutputStream(absolutePath);
//                    fileOut.write(inputBuffer.toString().getBytes());
//                    fileOut.close();
//
//                } catch (Exception e) {
//                    System.out.println("Problem reading file.");
//
//                }
//                System.out.println(READY);
//
//    }
//}
