package com.javarush.cryptanalyser.tyapkin.service;

import com.javarush.cryptanalyser.tyapkin.coding.Encode;
import com.javarush.cryptanalyser.tyapkin.constants.applicationConstants;
import com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DefFail {
    public DefFail() {

        Scanner userMessage = new Scanner(System.in);
        int key;
        String userWay;
        String fileName;


        System.out.println(inputOutputConstants.ENTER_NAME);
        fileName = userMessage.nextLine();

        System.out.println(inputOutputConstants.ENTER_WAY);
        userWay = userMessage.nextLine();
        Path directory = Paths.get(userWay);

        System.out.println(inputOutputConstants.ENTER_KEY);
        key = userMessage.nextInt();

        fileName = fileName + applicationConstants.FORMAT;
        String absolutePath = directory + File.separator + fileName;

        //вводим KEY смещения

        try (FileOutputStream fileOutputStream = new FileOutputStream(absolutePath)) {
            fileOutputStream.write(Encode.encrypt(applicationConstants.TEXT, key).getBytes());
        } catch (IOException e) { // exception handling
        }
        System.out.println(inputOutputConstants.READY);
    }
}
