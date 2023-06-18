package com.javarush.cryptanalyser.tyapkin.service;

import com.javarush.cryptanalyser.tyapkin.constants.inputConstantsConsole;

import java.io.*;
import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.INPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.OUTPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.service.coding.Decode.decrypt;

public class StandardTextDecode {


    public StandardTextDecode() {
        Scanner userMessage = new Scanner(System.in);
        int key;
        System.out.println(inputConstantsConsole.ENTER_KEY);
        key = userMessage.nextInt();
        try {
            BufferedReader file = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            StringBuilder inputBuffer = new StringBuilder();
            String line;
            while ((line = file.readLine()) != null) {
                line = decrypt(line, key); // кодировка файла
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();
            // перезапись  файла
            FileOutputStream fileOut = new FileOutputStream(OUTPUT_FILE_NAME);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }

    }
}
