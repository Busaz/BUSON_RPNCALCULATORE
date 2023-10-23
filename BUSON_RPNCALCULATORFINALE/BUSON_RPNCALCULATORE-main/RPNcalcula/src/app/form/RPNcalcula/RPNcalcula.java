package app.form.RPNcalcula;

import java.util.Stack;
import static javax.swing.JOptionPane.showMessageDialog;
public class RPNcalcula {

    public static String converti(String espressioneInfix) {
        StringBuilder espressioneRPN = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        boolean inNumero = false;  

        for (char carattere : espressioneInfix.toCharArray()) {
            if (Character.isDigit(carattere)) {
                if (inNumero) {
                    
                    espressioneRPN.append(carattere);
                } else {
                    inNumero = true;
                    espressioneRPN.append(carattere); 
                }
            } else {
                if (inNumero) {
                    espressioneRPN.append(" "); 
                    inNumero = false;
                }

                if (carattere == '(') {
                    operatorStack.push(carattere);
                } else if (carattere == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        espressioneRPN.append(operatorStack.pop());
                        espressioneRPN.append(" ");
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                        operatorStack.pop();
                    }
                } else if (isOperatore(Character.toString(carattere))) {
                    while (!operatorStack.isEmpty() && precedenza(carattere) <= precedenza(operatorStack.peek())) {
                        espressioneRPN.append(operatorStack.pop());
                        espressioneRPN.append(" ");
                    }
                    operatorStack.push(carattere);
                }
            }
        }

        // Aggiungi spazi tra operatori se non ci sono spazi
        if (inNumero) {
            espressioneRPN.append(" ");
        }

        while (!operatorStack.isEmpty()) {
            espressioneRPN.append(operatorStack.pop());
            espressioneRPN.append(" ");
        }

        return espressioneRPN.toString().trim();
    }


    //erase textfield



    public static double calcola(String espressioneRPN) {

        
        if(espressioneRPN.matches(".*[a-zA-Z]+.*")){
            showMessageDialog(null, "Syntax error");
        }

        Stack<Double> valoreStack = new Stack<>();

        for (String token : espressioneRPN.split("\\s+")) {
            if (token.matches("-?\\d+(\\.\\d+)?")) { //sia positivo che negativo ma opzionale, sia intero che decimale, sia con o senza virgola ma opzionale
                valoreStack.push(Double.parseDouble(token));
            } else if (isOperatore(token)) {
                double op2 = valoreStack.pop();
                double op1 = valoreStack.pop();
                double risultato = applicaOperatore(op1, token.charAt(0), op2);
                valoreStack.push(risultato);
            }
        }

        return valoreStack.pop();
    }

    private static boolean isOperatore(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }


    private static int precedenza(char operatore) {
        return switch (operatore) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0; // parentesi
        };
    }


    private static double applicaOperatore(double op1, char operatore, double op2) {
        return switch (operatore) {
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            case '*' -> op1 * op2;
            case '/' -> {
                if (op2 == 0) {
                    throw new ArithmeticException("Divisione per zero");
                }
                yield op1 / op2;
            }
            default -> throw new IllegalArgumentException("Operatore sconosciuto: " + operatore);
        };
    }

}
