package com.javarush.cryptanalyser.tyapkin.service;

import java.io.*;
import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.INPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.OUTPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.service.coding.Decode.decrypt;
import static com.javarush.cryptanalyser.tyapkin.constants.inputConstantsConsole.*;

public class DecryptText  {

    public DecryptText() {

        Scanner userMessage = new Scanner(System.in);
        System.out.println(ENTER_TEXT);

        int key;

        System.out.println(ENTER_KEY);
        key = userMessage.nextInt();

        try {
            //
            BufferedReader file = new BufferedReader(new FileReader(OUTPUT_FILE_NAME));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = file.readLine()) != null) {
                line = decrypt(line, key); // кодировка файла
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();

            // перезапись  файла
            FileOutputStream fileOut = new FileOutputStream(INPUT_FILE_NAME);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");

        }
    }
}
