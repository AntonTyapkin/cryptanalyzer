package com.javarush.cryptanalyser.tyapkin.constants;

import java.io.File;

public class applicationConstants {
    private applicationConstants() {
    }

    public static final String FORMAT = ".txt";
    public static final String KEY = " ";
    public static final String ROOT = System.getProperty("user.dir");
    public static final String OUTPUT = "output.txt";

    public static final String INPUT = "input.txt";
    public static final String INPUT_FILE_NAME = ROOT + File.separator + INPUT;

    public static String OUTPUT_FILE_NAME = ROOT + File.separator + OUTPUT;
    public static final String PROGRAM_NAME = "CryptoAnalyze";

}