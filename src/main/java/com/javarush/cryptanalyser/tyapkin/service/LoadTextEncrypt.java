package com.javarush.cryptanalyser.tyapkin.service;

import com.javarush.cryptanalyser.tyapkin.constants.applicationConstants;
import com.javarush.cryptanalyser.tyapkin.constants.inputConstantsConsole;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.OUTPUT_FILE_NAME;
import static com.javarush.cryptanalyser.tyapkin.service.coding.Encode.encrypt;

public class LoadTextEncrypt {



    public LoadTextEncrypt() {
// выбираем путь загружаемого текстового файла
        Scanner userMessage = new Scanner(System.in);
        int key;
        String userWay;
        String fileName;
        System.out.println(inputConstantsConsole.ENTER_WAY);
        userWay = userMessage.nextLine();
        Path directory = Paths.get(userWay);
        // имя файла
        System.out.println(inputConstantsConsole.ENTER_NAME);
        fileName = userMessage.nextLine();
        // формат .txt по умолчанию
        fileName = fileName + applicationConstants.FORMAT;
        String absolutePath = directory + File.separator + fileName;
        //вводим KEY смещения
        System.out.println(inputConstantsConsole.ENTER_KEY);
        key = userMessage.nextInt();
        // чтение файла
        try {
            BufferedReader file = new BufferedReader(new FileReader(absolutePath));
            StringBuilder inputBuffer = new StringBuilder();
            String line;
            while ((line = file.readLine()) != null) {
                line = encrypt(line, key); // кодировка файла
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
        System.out.println(inputConstantsConsole.READY);

    }
}

