package app.form.RPNcalcula;

import java.util.Stack;

public class RPNcalcula{

    public static String elaboraEspressioneRPN(String espressioneRPN) {
        Stack<String> stack = new Stack<>();

        for (String token : espressioneRPN.split(" ")) {
            if (isOperatore(token)) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String risultato = "(" + op1 + token + op2 + ")";
                stack.push(risultato);
            } else {
                stack.push(token);
            }
        }

        if (stack.size() == 1) {
            return stack.pop();
        } else {
            return "Errore: espressione non valida";
        }
    }

    public static String calcolaEspressioneInInfissa(String espressioneInfissa) {
        try {
            return Double.toString(valutaEspressioneInfissa(espressioneInfissa));
        } catch (Exception e) {
            return "Errore: espressione non valida";
        }
    }

    private static boolean isOperatore(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static double valutaEspressioneInfissa(String espressioneInfissa) {
        Stack<Double> operandi = new Stack<>();
        Stack<Character> operatori = new Stack<>();

        for (int i = 0; i < espressioneInfissa.length(); i++) {
            char carattere = espressioneInfissa.charAt(i);
            if (Character.isDigit(carattere)) {
                StringBuilder numero = new StringBuilder();
                while (i < espressioneInfissa.length() && (Character.isDigit(espressioneInfissa.charAt(i)) || espressioneInfissa.charAt(i) == '.')) {
                    numero.append(espressioneInfissa.charAt(i));
                    i++;
                }
                i--;
                operandi.push(Double.parseDouble(numero.toString()));
            } else if (carattere == '(') {
                operatori.push(carattere);
            } else if (carattere == ')') {
                while (!operatori.isEmpty() && operatori.peek() != '(') {
                    double op2 = operandi.pop();
                    double op1 = operandi.pop();
                    char operatore = operatori.pop();
                    double risultato = applicaOperatore(op1, operatore, op2);
                    operandi.push(risultato);
                }
                operatori.pop();
            } else if (isOperatore(String.valueOf(carattere))) {
                while (!operatori.isEmpty() && precedenza(operatori.peek()) >= precedenza(carattere)) {
                    double op2 = operandi.pop();
                    double op1 = operandi.pop();
                    char operatore = operatori.pop();
                    double risultato = applicaOperatore(op1, operatore, op2);
                    operandi.push(risultato);
                }
                operatori.push(carattere);
            }
        }

        while (!operatori.isEmpty()) {
            double op2 = operandi.pop();
            double op1 = operandi.pop();
            char operatore = operatori.pop();
            double risultato = applicaOperatore(op1, operatore, op2);
            operandi.push(risultato);
        }

        return operandi.pop();
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

    private static int precedenza(char operatore) {
        return switch (operatore) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }
}