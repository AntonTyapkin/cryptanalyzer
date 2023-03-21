package com.javarush.cryptanalyser.tyapkin.codingText;

import com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.javarush.cryptanalyser.tyapkin.coding.Decode.decrypt;
import static com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants.READY;


public class BrutForce {
    private final String Brutforce = "([а-яА-Я] + (\\s|,\\s|:\\s|;\\s)){2}";
    private final Pattern pattern = Pattern.compile(Brutforce);

    public BrutForce() {

        String root = System.getProperty("user.dir");
        String output = "output.txt";
        String fileOutput = root + File.separator + output;


        try {
            BufferedReader file = new BufferedReader(new FileReader(fileOutput));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = file.readLine()) != null) {
                for (int i = 1; i < 93; i++) {
                    inputBuffer.delete(0, inputBuffer.length());
                    inputBuffer = new StringBuilder(decrypt(fileOutput, i));
                    Matcher matcher = pattern.matcher(inputBuffer);
                    if (matcher.find()) ;
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                break;
            }
            file.close();


            FileOutputStream fileOut = new FileOutputStream(fileOutput);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        } catch (IOException e) {

            System.out.println(READY);
        }
    }
}



//                line = decrypt(line, key); // кодировка файла
//                    decodingText.append(line);
//                    decodingText.append('\n');

//            for (int i = 1; i < 93; i++) {
//                decodingText.delete(0, decodingText.length());
//                decodingText = decrypt(,i);
//                Matcher matcher = pattern.matcher(decodingText);
//                if (matcher.find()) ;
//                break;

//    Scanner userMessage = new Scanner(System.in);
//    String message;
//    String userWay;

// ввидите путь
//        System.out.println(ENTER_WAY);
//        userWay = userMessage.nextLine();
//                Path directory = Paths.get(userWay);
//
//                // имя файла
//                System.out.println(ENTER_NAME);
//                String fileName = userMessage.nextLine();
//
//                // формат .txt по умолчанию
//                fileName = fileName + FORMAT;
//                String absolutePath = directory + File.separator + fileName;
//        try {
//
//            // изменение содержимого файла
//            BufferedReader file = new BufferedReader(new FileReader(absolutePath));
//            StringBuilder inputBuffer = new StringBuilder();
//            String line;
//
//            while ((message = file.readLine()) != null) {
//
//                ArrayList<String> list = new ArrayList<>();
//
//                for (int i = 1; i < ALPHABET.length(); i++) {
//
//                    line = decrypt(message, i);
//                    list.add(message);   // кодировка файла
//                    inputBuffer.append(line);
//                    inputBuffer.append('\n');
//
//                    System.out.println(line + " " + " key = " + i);
//                }
//            }
//            System.out.println("Осталось найти читаемую строку!");
//            file.close();
//
//            // Обработка исключений
//        } catch (
//                Exception e) {
//            System.out.println("Problem reading file.");
//        }
//    }
//}
//
