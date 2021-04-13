package Practica1;
public class Oper {
    public String Ope(int d, int j, String op) {
        switch (op) {//Operaciones
        case "+":
            int sum = d + j;
            return sum + "";

        case "-"://Resta
            int rest = d - j;
            return rest + "";

        case "/"://División
            if (d > 0 && j > 0) {
                int divicion = d / j;
                return divicion + "";
            } else {
                return "Imposible dividir entre 0";
            }

        case "*"://Multiplicación.
            int multiplicacion = d * j;
            return multiplicacion + "";

        case "^"://Elevar.
            if (j != 0) {
                double elevar = Math.pow(d, j);
                return elevar + "";
            }
            break;
        default:
            return "";
        }

        return null;
    }
}