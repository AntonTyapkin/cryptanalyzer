package com.javarush.cryptanalyzer.tyapkin.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.tyapkin.coding.Encode.encrypt;
import static com.javarush.cryptanalyzer.tyapkin.constants.applicationConstants.FORMAT;
import static com.javarush.cryptanalyzer.tyapkin.constants.inputOutputConstants.*;

public class DecodeFile {
    public DecodeFile() {

        Scanner userMessage = new Scanner(System.in);
        int key;
        String userWay;
        String fileName;


        System.out.println(ENTER_WAY);
        userWay = userMessage.nextLine();
                Path directory = Paths.get(userWay);


                // имя файла
                System.out.println(ENTER_NAME);
                fileName = userMessage.nextLine();

                // формат .txt по умолчанию
                fileName = fileName + FORMAT;
                String absolutePath = directory + File.separator + fileName;


                //вводим KEY смещения
                System.out.println(ENTER_KEY);
                key = userMessage.nextInt();

                // чтение файла

                try {
                    //
                    BufferedReader file = new BufferedReader(new FileReader(absolutePath));
                    StringBuilder inputBuffer = new StringBuilder();
                    String line;

                    while ((line = file.readLine()) != null) {
                        line = encrypt(line, key); // кадировка файла
                        inputBuffer.append(line);
                        inputBuffer.append('\n');
                    }
                    file.close();

                    // перезапись  файла
                    FileOutputStream fileOut = new FileOutputStream(absolutePath);
                    fileOut.write(inputBuffer.toString().getBytes());
                    fileOut.close();

                } catch (Exception e) {
                    System.out.println("Problem reading file.");

                }
                System.out.println(READY);

    }
}
