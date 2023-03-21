package com.javarush.cryptanalyser.tyapkin.codingText;

import com.javarush.cryptanalyser.tyapkin.constants.applicationConstants;
import com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.coding.Decode.decrypt;
import static com.javarush.cryptanalyser.tyapkin.coding.Encode.encrypt;

public class LoadTextDecrypt {
    public LoadTextDecrypt() {


        Scanner userMessage = new Scanner(System.in);
        int key;
        String userWay;
        String fileName;

        String root = System.getProperty("user.dir");
        String output = "output.txt";
        String fileInput = root + File.separator + output;

        System.out.println(inputOutputConstants.ENTER_WAY);
        userWay = userMessage.nextLine();
        Path directory = Paths.get(userWay);

        // имя файла
        System.out.println(inputOutputConstants.ENTER_NAME);
        fileName = userMessage.nextLine();

        // формат .txt по умолчанию
        fileName = fileName + applicationConstants.FORMAT;
        String absolutePath = directory + File.separator + fileName;

        //вводим KEY смещения
        System.out.println(inputOutputConstants.ENTER_KEY);
        key = userMessage.nextInt();

        // чтение файла

        try {
            //
            BufferedReader file = new BufferedReader(new FileReader(absolutePath));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = file.readLine()) != null) {
                line = decrypt(line, key); // кодировка файла
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();

            // перезапись  файла
            FileOutputStream fileOut = new FileOutputStream(output);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");

        }
        System.out.println(inputOutputConstants.READY);

    }
}

