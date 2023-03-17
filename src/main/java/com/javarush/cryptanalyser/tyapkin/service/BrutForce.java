package com.javarush.cryptanalyser.tyapkin.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.FORMAT;
import static com.javarush.cryptanalyser.tyapkin.constants.cryptoAlphabet.ALPHABET;
import static com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants.*;
import static com.javarush.cryptanalyser.tyapkin.coding.Decode.decrypt;

public class BrutForce {



    public BrutForce() {
        Scanner userMessage = new Scanner(System.in);
        String message;
String userWay;

        // ввидите путь
        System.out.println(ENTER_WAY);
        userWay = userMessage.nextLine();
                Path directory = Paths.get(userWay);


                // имя файла
                System.out.println(ENTER_NAME);
                String fileName = userMessage.nextLine();

                // формат .txt по умолчанию
                fileName = fileName + FORMAT;
                String absolutePath = directory + File.separator + fileName;
        try {

            // изменение содержимого файла
            BufferedReader file = new BufferedReader(new FileReader(absolutePath));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((message = file.readLine()) != null) {


                ArrayList<String> list = new ArrayList<>();


                for (int i = 1; i < ALPHABET.length(); i++) {

                    line = decrypt(message, i);
                    list.add(message);   // кодировка файла
                    inputBuffer.append(line);
                    inputBuffer.append('\n');

                    System.out.println(line + " " + " key = " + i);
                }
            }
            System.out.println("Осталось найти читаемую строку!");
            file.close();

            // Обработка исключений
        } catch (
                Exception e) {
            System.out.println("Problem reading file.");
        }
    }
}

