package com.javarush.cryptanalyser.tyapkin.codingText;
import com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants;

import java.io.*;
import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.coding.Decode.decrypt;
import static com.javarush.cryptanalyser.tyapkin.coding.Encode.encrypt;
import static com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants.*;

public class DecryptText  {
    public DecryptText() {

        Scanner userMessage = new Scanner(System.in);
        System.out.println(ENTER_TEXT);
        String message;
        message = userMessage.nextLine();
        int key;

        System.out.println(ENTER_KEY);
        key = userMessage.nextInt();

        String input = "input.txt";
//        String fileInput = root + File.separator + input;



        String root = System.getProperty("user.dir");
        String output = "output.txt";
        String fileOutput = root + File.separator + output;



        try {
            //
            BufferedReader file = new BufferedReader(new FileReader(output));
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            while ((line = file.readLine()) != null) {
                line = decrypt(line, key); // кодировка файла
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();

            // перезапись  файла
            FileOutputStream fileOut = new FileOutputStream(fileOutput);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");

        }
        System.out.println(inputOutputConstants.READY);

    }
}
