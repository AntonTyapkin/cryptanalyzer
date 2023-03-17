package com.javarush.cryptanalyzer.tyapkin.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.tyapkin.coding.Encode.encrypt;
import static com.javarush.cryptanalyzer.tyapkin.constants.applicationConstants.FORMAT;
import static com.javarush.cryptanalyzer.tyapkin.constants.applicationConstants.TEXT;
import static com.javarush.cryptanalyzer.tyapkin.constants.inputOutputConstants.*;

public class DefFail {
    public DefFail() {

        Scanner userMessage = new Scanner(System.in);
        int key;
        String userWay;
        String fileName;


        System.out.println(ENTER_NAME);
        fileName = userMessage.nextLine();

        System.out.println(ENTER_WAY);
        userWay = userMessage.nextLine();
        Path directory = Paths.get(userWay);

        System.out.println(ENTER_KEY);
        key = userMessage.nextInt();

        fileName = fileName + FORMAT;
        String absolutePath = directory + File.separator + fileName;

        //вводим KEY смещения

        try (FileOutputStream fileOutputStream = new FileOutputStream(absolutePath)) {
            fileOutputStream.write(encrypt(TEXT, key).getBytes());
        } catch (IOException e) { // exception handling
        }
        System.out.println(READY);
    }
}
