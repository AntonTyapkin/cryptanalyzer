package com.javarush.cryptanalyser.tyapkin.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.service.coding.Encode.encrypt;
import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.FORMAT;
import static com.javarush.cryptanalyser.tyapkin.constants.inputConstantsConsole.*;

public class EnterText {
    public EnterText() {

        Scanner userMessage = new Scanner(System.in);
        System.out.println(ENTER_TEXT);
        String message;
        message = userMessage.nextLine();
        int key;
        String userWay;
        String fileName;
        System.out.println(ENTER_KEY);
        key = userMessage.nextInt();
        // вводим путь сохранения файла и имя
        System.out.println(ENTER_WAY);
        userWay = userMessage.nextLine();
        Path directory = Paths.get(userWay);
        //вводим имя создаваемого файла
        System.out.println(ENTER_NAME);
        fileName = userMessage.nextLine();
        // создание файла
        fileName = fileName + FORMAT;
        String absolutePath = directory + File.separator + fileName;
        encrypt(message, key);
        System.out.println(FILE_CREATED);
        userMessage.close();
        try (FileOutputStream fileOutputStream = new FileOutputStream(absolutePath)) {
            fileOutputStream.write(encrypt(message, key).getBytes());
        } catch (IOException e) { // exception handling
        }
        System.out.println(READY);

    }
}
