package com.javarush.cryptanalyzer.tyapkin.applications;

import com.javarush.cryptanalyzer.tyapkin.service.BrutForce;
import com.javarush.cryptanalyzer.tyapkin.service.DecodeFile;
import com.javarush.cryptanalyzer.tyapkin.service.IncodeFile;

import java.util.Scanner;
import static com.javarush.cryptanalyzer.tyapkin.constants.inputOutputConstants.*;

public class Application_Console {

    public Application_Console() {

        System.out.println(INPUT);
        Scanner userMessage = new Scanner(System.in);
        String s1 = userMessage.nextLine();


        switch (s1) {
            case "1":
                IncodeFile incodeFile = new IncodeFile();
                break;
            case "2":
                DecodeFile decodeFile = new DecodeFile();
                break;
            case "3":
                BrutForce brutForce = new BrutForce();
                break;


        }

    }
}