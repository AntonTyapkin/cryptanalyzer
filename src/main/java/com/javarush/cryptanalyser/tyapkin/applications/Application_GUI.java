package com.javarush.cryptanalyser.tyapkin.applications;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import static com.javarush.cryptanalyser.tyapkin.constants.applicationConstants.PROGRAM_NAME;

public class Application_GUI {

    /**
     * Точка входа в приложение.
     */
    public Application_GUI() {
        JFrame frame = new JFrame(PROGRAM_NAME);
        frame.setSize(600, 300);

        // Добавляем панель кодирования
        EncodePanel encodePanel = new EncodePanel();
        encodePanel.setBorder(new EmptyBorder(6, 6, 6, 6));
        frame.add(encodePanel);
        frame.setVisible(true);
    }
}



