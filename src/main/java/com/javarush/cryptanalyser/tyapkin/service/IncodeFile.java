package com.javarush.cryptanalyser.tyapkin.service;

import com.javarush.cryptanalyser.tyapkin.codingText.EnterText;
import com.javarush.cryptanalyser.tyapkin.codingText.LoadText;
import com.javarush.cryptanalyser.tyapkin.codingText.StandardTextEncrypt;
//import com.javarush.cryptanalyser.tyapkin.codingText.StandartTextEncrypt;

import java.util.Scanner;

import static com.javarush.cryptanalyser.tyapkin.constants.inputOutputConstants.*;

public class IncodeFile {
    public IncodeFile() {

        Scanner userMessage = new Scanner(System.in);
        String message;

        System.out.println(INPUT_CODE);
        message = userMessage.nextLine();

        switch (message) {
            case "1":
                EnterText enterText = new EnterText();
                break;
            case "2":
                LoadText loadText = new LoadText();
                break;
            case "3":
                StandardTextEncrypt defFail = new StandardTextEncrypt();
                break;
        }
    }
}

