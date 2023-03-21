package com.javarush.cryptanalyser.tyapkin.service;

import java.io.File;

public class OutputFile {

    public void fileOutput() {

    }
    public String outputFile(){
        String root = System.getProperty("user.dir");
        String input = "input.txt";
        String output = root + File.separator + input;


        return output;

    }
}

