package app.form.RPNcalcula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FormGUI {

    private JPanel Panel;
    private JButton Zero;
    private JButton Uno;
    private JButton Due;
    private JButton Tre;
    private JButton Quattro;
    private JButton Cinque;
    private JButton Sei;
    private JButton Sette;
    private JButton Otto;
    private JButton Nove;
    private JButton Piu;
    private JButton Meno;
    private JButton Per;
    private JButton Diviso;
    private JButton Uguale;
    private JButton Cancella;
    private JTextField TextField1;
    private JButton Parentesi1;
    private JButton Parentesi2;
    private JButton Convert;
    private JLabel LABEL;

    public FormGUI() {
        Zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "0");
            }
        });

        Uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "1");
            }
        });

        Due.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "2");
            }
        });

        Tre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "3");
            }
        });

        Quattro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "4");
            }
        });

        Cinque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "5");
            }
        });

        Sei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "6");
            }
        });

        Sette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "7");
            }
        });

        Otto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "8");
            }
        });

        Nove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "9");
            }
        });

        Piu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check if last char is a number

                if(!TextField1.getText().isEmpty()) {
                    char lastChar = TextField1.getText().charAt(TextField1.getText().length() - 1);
                    if (!(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '(')) {
                        TextField1.setText(TextField1.getText() + "+");
                    }
                }
            }
        });

        Meno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!TextField1.getText().isEmpty()) {
                    char lastChar = TextField1.getText().charAt(TextField1.getText().length() - 1);
                    if (!(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '(')) {
                        TextField1.setText(TextField1.getText() + "-");
                    }
                }
            }
        });

        Per.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!TextField1.getText().isEmpty()) {
                    char lastChar = TextField1.getText().charAt(TextField1.getText().length() - 1);
                    if (!(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '(')) {
                        TextField1.setText(TextField1.getText() + "*");
                    }
                }
            }
        });

        Diviso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!TextField1.getText().isEmpty()) {
                    char lastChar = TextField1.getText().charAt(TextField1.getText().length() - 1);
                    if (!(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '(')) {
                        TextField1.setText(TextField1.getText() + "/");
                    }
                }
            }
        });

        Parentesi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + "(");
            }
        });

        Parentesi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText(TextField1.getText() + ")");
            }
        });

        Cancella.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField1.setText("");
            }
        });

        Uguale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String espressione = TextField1.getText();
                Double risultato = RPNcalcula.calcola(espressione);
                //do
                TextField1.setText(risultato.toString());
            }
        });

        Convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String espressione = TextField1.getText();
                String risultato = RPNcalcula.converti(espressione);
                TextField1.setText(risultato);
            }
        });



    }

    // ... (resto del codice)

    public static void main(String[] args) {
        JFrame frame = new JFrame("RPNcalcula");
        frame.setContentPane(new FormGUI().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //erase textfield

    public static void eraseTextField(){
        TextField1.setText("");
    }
}


