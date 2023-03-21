package com.javarush.cryptanalyser.tyapkin.service;

import java.io.File;

public class InputFile {


    public String fileInput() {

        return null;
    }
        public String file(){
            String root = System.getProperty("user.dir");
            String input = "input.txt";
            String in = root + File.separator + input;


            return in;

    }
}


