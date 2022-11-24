import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.*;
import static java.lang.System.out;

public class Task1010 {
    public static void main(String[] args) throws IOException{
        File directory = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java");
        File file = new File(directory, "Для 10.txt");
        FileWriter fileWr = new FileWriter(file);
        BufferedWriter fileBF = new BufferedWriter(fileWr);
        McLarenSeries(fileBF);
    }

    public static void McLarenSeries(BufferedWriter fileBF) throws IOException{
        Scanner scanner = new Scanner(System.in);
        out.println("Введите переменную x меньше 1:");
        double x = scanner.nextDouble();

        output(fileBF, x);

        double Eps = pow(10, -2);
        if (x >= 1) {
            out.println("Ошибка" +
                    "\nВведите x меньше 1");
        }
        else {
            while (Eps >= pow(10, -4)) {
                int count = 0;
                double summ = 0;
                int n = 1;
                while ((abs(pow(sin(x), 3) - summ/4)) >= Eps) {
                    summ += pow(-1, (n + 1)) * ((pow(3, (2 * n + 1)) - 3) / Fact(2 * n + 1)) * pow(x, (2 * n + 1));
                    n++;
                    count++;
                }
                outputResult(fileBF, x, Eps, count,((1.0 / 4) * summ));
                Eps *= 0.1;
            }
        }

        fileBF.close();
    }

    public static int Fact(int n) {
        int result = 1;
        for (int j = 1; j <= n; j++) {
            result *= j;
        }
        return result;
    }

    public static void output(BufferedWriter fileBF, double x) throws IOException{
        DecimalFormat decimalFormat = new DecimalFormat("0.000000000000");
        String stringOS = "Функция f(x) = sin(pow(x, 3)) для x = " + x + " равняется " + decimalFormat.format(function(x));
        fileBF.write(stringOS);

        stringOS = "\n" + "Результаты определения значений функции f(x) = pow(-1, (n + 1)) * ((pow(3, (2 * n + 1)) - 3) / Fact(2 * n + 1)) * pow(x, (2 * n + 1))" +
                "\nс помощью ряда Маклорена";
        fileBF.write(stringOS);

        stringOS = "\n" + "Где Fact(2 * n + 1) - цикл по нахождению факториала:" + "\n" +
                "        int result = 1;\n" +
                "        for (int j = 1; j <= n; j++) {\n" +
                "            result *= j;\n" +
                "        }\n" +
                "        return result;";
        fileBF.write(stringOS);

        stringOS = "\n" + "Значение функции по Маклорену \tПогрешность итерационной процедуры \tПогрешность решения, % \tЧисло итераций";
        fileBF.write(stringOS);
    }

    public static void outputResult(BufferedWriter fileBF, double x, double Eps, int count, double result)
            throws IOException {
        String formatResult = String.format("%.12f", result);
        String error = String.format("%.1f",abs(result - function(x)) / function(x) * 100);
        fileBF.newLine();
        String stringOS_Result = "\t" + formatResult + "\t\t\t\t\t\s\s\s" + Eps +
                "\t\t\t\t\s\s\s" + error + "\t\t\s\s\s\s\s" + count;
        fileBF.write(stringOS_Result);
    }

    public static double function(double x) {
        return sin(pow(x, 3));
    }
}