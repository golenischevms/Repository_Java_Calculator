package aboutprogramm;

import javax.swing.*;
import java.awt.*;


public class ProgramInformation  {
    JFrame frame = new JFrame ("About Program");
    private JPanel panel = new JPanel(new BorderLayout(5,5));
    private JEditorPane info = new JEditorPane();

    public ProgramInformation()
    {
        panel.setBackground(Color.WHITE);
        ImageIcon img = new ImageIcon("src/assets/calculator.png");
        frame.setIconImage(img.getImage());


        info.setText("\n" +
                "Program: Calculator v1.0 (Alpha)\n" +
                "Author: © Artyom B. Golenischev\n" +
                "Company: South Ural State University (national research university), 2023\n" +
                "Created with JAVA, OpenJDK 21.\n" +
                "\n" +
                "The MIT License (MIT)");
        panel.add(info, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(500,400);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
    }

}
