package app.form.RPNcalcula;

import javax.swing.*;

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

    public FormGUI() {
        Zero.addActionListener(e -> TextField1.setText(TextField1.getText() + "0"));

        Uno.addActionListener(e -> TextField1.setText(TextField1.getText() + "1"));

        Due.addActionListener(e -> TextField1.setText(TextField1.getText() + "2"));

        Tre.addActionListener(e -> TextField1.setText(TextField1.getText() + "3"));

        Quattro.addActionListener(e -> TextField1.setText(TextField1.getText() + "4"));

        Cinque.addActionListener(e -> TextField1.setText(TextField1.getText() + "5"));

        Sei.addActionListener(e -> TextField1.setText(TextField1.getText() + "6"));

        Sette.addActionListener(e -> TextField1.setText(TextField1.getText() + "7"));

        Otto.addActionListener(e -> TextField1.setText(TextField1.getText() + "8"));

        Nove.addActionListener(e -> TextField1.setText(TextField1.getText() + "9"));

        Piu.addActionListener(e -> TextField1.setText(TextField1.getText() + "+"));

        Meno.addActionListener(e -> TextField1.setText(TextField1.getText() + "-"));

        Per.addActionListener(e -> TextField1.setText(TextField1.getText() + "*"));

        Diviso.addActionListener(e -> TextField1.setText(TextField1.getText() + "/"));

        Parentesi1.addActionListener(e -> TextField1.setText(TextField1.getText() + "("));

        Parentesi2.addActionListener(e -> TextField1.setText(TextField1.getText() + ")"));

        Cancella.addActionListener(e -> TextField1.setText(""));

        Uguale.addActionListener(e -> {
            String espressione = TextField1.getText();
            String risultato = RPNcalcula.calcolaEspressioneInInfissa(espressione);
            TextField1.setText(risultato);
        });

        Convert.addActionListener(e -> {
            String espressione = TextField1.getText();
            String risultato = RPNcalcula.elaboraEspressioneRPN(espressione);
            TextField1.setText(risultato);
        });



    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("RPNcalcula");
        frame.setContentPane(new FormGUI().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}


