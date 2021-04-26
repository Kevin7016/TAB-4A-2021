using System;

namespace Práctica1
{//Clase que realiza las operaciones.
    public class Operaciones
    {
        public string operacion(int d1, int d2, string o)
        {//Recibe los dos numeros y el operador.
            switch (o)//Según el operdor se realiza la operación definida
            {
                case "+"://Suma
                    int suma = d1 + d2;
                    return suma + "";

                case "-"://Resta
                    int resta = d1 - d2;
                    return resta + "";

                case "/"://División
                    if (d1 > 0 && d2 > 0)//Comprueba que los datos son diferentes a 0.
                    {//Porque no se puede dividir entre 0.
                        int divicion = d1 / d2;
                        return divicion + "";
                    }
                    else
                    {
                        return "Imposile división entre 0";
                    }

                case "*"://Multiplicación.
                    int multiplicacion = d1 * d2;
                    return multiplicacion + "";

                case "^"://Elevar.
                    if (d2 != 0)
                    {// Ve que a lo que se elavará sea diferente de 0.
                        double elevar = Math.Pow(d1, d2);
                        return elevar + "";
                    }
                    break;

            }

            return null;
        }

    }
}
