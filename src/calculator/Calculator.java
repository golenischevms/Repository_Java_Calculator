/*
* Task 4.
* Created by: Artyom B. Golenischev
* South Ural State University, group 120.
* Date: 08.10.2023
* */

package calculator;

import aboutprogramm.ProgramInformation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;



public class Calculator extends JFrame implements ActionListener{

    private DecimalFormat df = new DecimalFormat("#,##0.00");
    private String[] symbols = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "xⁿ", "="
    };

    private int operator = 0;
    private JMenuBar menuBar = new JMenuBar();
    private JPanel panel = new JPanel(new BorderLayout(5,5));
    private JPanel btnPanel = new JPanel(new GridLayout(5,3));
    private JButton[] btns = new JButton[20];
    private JTextArea screen = new JTextArea(5, 40);
    private double firstNum = 0, secondNum = 0;
    private JTextField calculatingTf = new JTextField(40);

    public Calculator(){
        super("Calculator v1.0 Alpha - Artyom B. Golenischev");
        ImageIcon img = new ImageIcon("src/assets/calculator.png");
        setIconImage(img.getImage());
        initMenu();
        init();
    }

    private void init() {

        panel.setBackground(Color.WHITE);

        screen.setFont(new Font("Times New Roman", Font.BOLD, 24));
        screen.setBackground(Color.WHITE);
        screen.setForeground(Color.BLACK);

        calculatingTf.setFont(new Font("Times New Roman", Font.BOLD, 18));

        btnPanel.setBackground(Color.WHITE);


        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(symbols[i]);

            btns[i].setOpaque(false);
            btns[i].setBorderPainted(false);
            btns[i].setBackground(Color.WHITE);
            btns[i].setForeground(Color.BLACK);
            btns[i].addActionListener(this);
            btns[i].setFont(new Font("Times New Roman", Font.BOLD, 24));

            btnPanel.add(btns[i]);
        }

        calculatingTf.setBackground(Color.WHITE);
        calculatingTf.setForeground(Color.BLACK);

        panel.add(menuBar, BorderLayout.NORTH);
        panel.add(screen, BorderLayout.CENTER);
        panel.add(calculatingTf, BorderLayout.SOUTH);

        add(panel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);

        setSize(480,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initMenu(){
        menuBar.setBackground(Color.WHITE);
        menuBar.setForeground(Color.BLACK);
        JMenu supportMenu = new JMenu("Support");
        menuBar.add(supportMenu);
        JMenuItem aboutItem = new JMenuItem("About Program");
        supportMenu.add(aboutItem);

        aboutItem.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ProgramInformation infoWindow = new ProgramInformation();
            }
        });
    }


    public static void main(String[] args) {
          new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand().toString();

        switch (cmd){
            case ".":
                if (!screen.getText().contains(".")){
                    screen.setText(screen.getText() + ".");
                }
                break;

            case "0":
                screen.setText(screen.getText() + "0");
                break;
            case "1":
                screen.setText(screen.getText() + "1");
                break;
            case "2":
                screen.setText(screen.getText() + "2");
                break;
            case "3":
                screen.setText(screen.getText() + "3");
                break;
            case "4":
                screen.setText(screen.getText() + "4");
                break;
            case "5":
                screen.setText(screen.getText() + "5");
                break;
            case "6":
                screen.setText(screen.getText() + "6");
                break;
            case "7":
                screen.setText(screen.getText() + "7");
                break;
            case "8":
                screen.setText(screen.getText() + "8");
                break;
            case "9":
                screen.setText(screen.getText() + "9");
                break;

            case "+":
                if (!screen.getText().isEmpty()){
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 1;
                    screen.setText("");
                }
                break;
            case "-":
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 2;
                    screen.setText("");
                }
                break;
            case "×":
                if (!screen.getText().isEmpty()){
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 3;
                    screen.setText("");
                }
                break;
            case "÷":
                if (!screen.getText().isEmpty()){
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 4;
                    screen.setText("");
                }
                break;
            case "xⁿ":
                if (!screen.getText().isEmpty()){
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 5;
                    screen.setText("");
                }
                break;

            case "AC":
                screen.setText("");
                calculatingTf.setText("");
                firstNum = 0; secondNum = 0;
                break;

            case "%":
                double num = Double.parseDouble(screen.getText().toString());
                screen.setText(String.valueOf(num/100.0));
                break;

            case "+/-":
                double neg = Double.parseDouble(screen.getText().toString());
                neg *= -1;
                screen.setText(String.valueOf(neg));
                break;

            default:
        }

        if (cmd.equalsIgnoreCase("=")){

            if (!screen.getText().isEmpty()){
                secondNum = Double.parseDouble(screen.getText().toString());

                switch(operator){
                    case 1: // addition
                        screen.setText(String.valueOf(firstNum + secondNum));
                        calculatingTf.setText(String.valueOf(firstNum + " + " + secondNum + " = " +
                                df.format((firstNum + secondNum))));
                        break;
                    case 2: // subtraction
                        screen.setText(String.valueOf(firstNum - secondNum));
                        calculatingTf.setText(String.valueOf(firstNum + " - " + secondNum + " = " +
                                df.format((firstNum - secondNum))));
                        break;
                    case 3: // multiplication
                        screen.setText(String.valueOf(firstNum * secondNum));
                        calculatingTf.setText(String.valueOf(firstNum + " x " + secondNum + " = " +
                                df.format((firstNum * secondNum))));
                        break;
                    case 4: // division
                        screen.setText(String.valueOf(firstNum / secondNum));
                        calculatingTf.setText(String.valueOf(firstNum + " ÷ " + secondNum + " = " +
                                df.format((firstNum / secondNum))));
                        break;
                    case 5: // raising to a power
                        screen.setText(String.valueOf(Math.pow(firstNum, secondNum)));
                        calculatingTf.setText(String.valueOf(firstNum + "^(" + secondNum + ") = " +
                                df.format(Math.pow(firstNum, secondNum))));
                        break;

                }
            }
        }
    }

}
