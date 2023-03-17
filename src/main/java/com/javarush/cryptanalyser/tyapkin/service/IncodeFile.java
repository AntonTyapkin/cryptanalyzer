package com.javarush.cryptanalyser.tyapkin.service;
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
            case "3": DefFail defFail = new DefFail();
        }
    }
}

