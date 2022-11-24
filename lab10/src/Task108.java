import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class Task108 {
    public static void main(String[] args) throws IOException {
        File directory = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java");
        File file = new File(directory, "Для 8.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter fileBW = new BufferedWriter(fileWriter);

        fileBW.write("Уравнения кривых первой фигуры:\n");
        String[][] equationsOfTheFirstFigure = {{"y = x + 4", "x ∈ [-5, -3]"},
                {"y = Math.sqrt(4 - Math.pow((x + 1), 2)) + 1", "x ∈ [-3, -1]"},
                {"y = 2.0 / 3 * x + 11.0 / 3", "x ∈ [-1, 2]"},
                {"y = 5.0 / 3 * x + 5.0 / 3", "x ∈ [-1, 2]"},
                {"y = x + 1", "x ∈ [-1, 4]"},
                {"y = -x / 2 + 7", "x ∈ [4, 6]"},
                {"y = x - 2", "x ∈ [4, 6]"},
                {"y = x / 3 + 2.0 / 3", "x ∈ [1, 4]"},
                {"y = -Math.sqrt(4 - Math.pow((x + 1), 2)) + 1", "x ∈ [-1, 1]"},
                {"y = x", "x ∈ [-2, -1]"},
                {"y = -2 * x - 6", "x ∈ [-3, -2]"},
                {"y = 2 * x + 6", "x ∈ [-4, -3]"},
                {"-x - 6", "x ∈ [-5, -4]"}};
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 2 - 1; j++) {
                String equation = (i + 1) + ") " + equationsOfTheFirstFigure[i][j] + ", " + equationsOfTheFirstFigure[i][j+1];
                fileBW.write(equation);
            }
            fileBW.newLine();
        }

        fileBW.newLine();
        fileBW.write("Уравнения кривых второй фигуры:\n");
        String[][] equationsOfTheSecondFigure = {{"y = x / 2 - 5", "x ∈ [0, 4]"},
                {"y = -Math.sqrt(4 - Math.pow((x - 4), 2)) - 1", "x ∈ [2, 4]"},
                {"y = 1 - x", "x ∈ [2, 3]"},
                {"y = x - 5", "x ∈ [3, 4]"},
                {"y = 0", "x = 4"},
                {"y = 0", "x ∈ [4, 5]"},
                {"y = 5 - x", "x ∈ [4, 5]"},
                {"y = Math.sqrt(4 - Math.pow((x - 4), 2)) - 1", "x ∈ [4, 6]"},
                {"y = 5 - x", "x ∈ [6, 7]"},
                {"y = -2", "x ∈ [4, 7]"},
                {"y = -3 * x + 10", "x ∈ [4, 5]"},
                {"y = -x", "x ∈ [4, 5]"},
                {"y = x / 4 - 5)", "x ∈ [0, 4]"}};
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 2 - 1; j++) {
                String equation = (i + 1) + ") " + equationsOfTheSecondFigure[i][j] + ", " + equationsOfTheSecondFigure[i][j+1];
                fileBW.write(equation);
            }
            fileBW.newLine();
        }

        inputCoordinates(fileBW);

        fileBW.close();
    }

    public static void inputCoordinates (BufferedWriter fileBW) throws IOException{
        Scanner scanner = new Scanner(System.in);
        out.println("Введите количество точек на проверку:");
        int n = scanner.nextInt();
        fileBW.write("\nМассив точек на проверку:");
        String coordinates = "";
        double[][] points = new double[2][n];
        for (int j = 0; j < n; j++) {
            fileBW.newLine();

            out.printf("Введите координату x%d:", j+1);
            out.println();
            points[0][j] = scanner.nextDouble();
            coordinates = (j + 1) + ") x = " + points[0][j] + ", ";
            fileBW.write(coordinates);

            out.printf("Введите координату y%d:", j+1);
            out.println();
            points[1][j] = scanner.nextDouble();
            coordinates = "y = " + points[1][j];
            fileBW.write(coordinates);
        }
        printCheckHitting(points, n, fileBW);
    }

    public static void printCheckHitting(double[][] points, int n, BufferedWriter fileBW) throws IOException{
        fileBW.newLine();
        fileBW.write("\nОтвет:\n");
        String answer;
        for (int j = 0; j < n; j++) {
            if (checkHitting(points[0][j], points[1][j]) == 1) {
                answer = ("Точка " + (j + 1) + " (" + points[0][j] + "," + points[1][j] + ")" +
                        " попала в область первой фигуры");
                fileBW.write(answer + "\n");
            }
            if (checkHitting(points[0][j], points[1][j]) == 10) {
                answer = ("Точка " + (j + 1)  + " (" + points[0][j] + "," + points[1][j] + ")" +
                        " попала на границу первой фигуры");
                fileBW.write(answer + "\n");
            }
            if (checkHitting(points[0][j], points[1][j]) == 2) {
                answer = ("Точка " + (j + 1) + " (" + points[0][j] + "," + points[1][j] + ")" +
                        " попала в область второй фигуры");
                fileBW.write(answer + "\n");
            }
            if (checkHitting(points[0][j], points[1][j]) == 20) {
                answer = ("Точка " + (j + 1) + " (" + points[0][j] + "," + points[1][j] + ")" +
                        " попала на границу второй фигуры");
                fileBW.write(answer + "\n");
            }
            if (checkHitting(points[0][j], points[1][j]) == -1) {
                answer = ("Точка " + (j + 1) + " (" + points[0][j] + "," + points[1][j] + ")" +
                        " не попала ни в область, ни на границу фигур");
                fileBW.write(answer + "\n");
            }
        }
    }

    public static int checkHitting(double x, double y) {
        if (y >= x - 2) { // попадание в область первой фигуры
            int Count1 = 0;
            if ((x >= -5) & (x <= -3) & (y < x + 4) & (y > -x - 6) & (y > 2 * x + 6)) //1 область
                Count1++;
            if ((x >= -3) & (x <= -1) & (y < Math.sqrt(4 - Math.pow((x + 1), 2)) + 1) & (y > x + 4)) //2 область
                Count1++;
            if ((x >= -1) & (x <= 2) & (y < 2.0 / 3 * x + 11.0 / 3) & (y > 5.0 / 3 * x + 5.0 / 3)) //3 область
                Count1++;
            if ((x >= -3) & (x <= -1) & (y < x + 4) & (y > -2 * x - 6) & (y > x)) //4 область
                Count1++;
            if ((x >= 1) & (x <= 6) & (y < x + 1) & (y < -x / 2 + 7) &
                    (y > x - 2) & (y > x / 3 + 2.0 / 3)) { //5 область
                Count1++;
            }
            if ((x >= -2) & (x <= 1) & (y < 5 * x / 3 + 5.0 / 3) & (y > x) & (y > x + 1)) //6 область
                Count1++;
            if ((x >= -1) & (x <= 1) & (y < x) & (y > -Math.sqrt(4 - Math.pow((x + 1), 2)) + 1)) //7 область
                Count1++;
            if (Count1 > 0)
                return 1;
            else { // попадание на границу первой фигуры
                int count1 = 0;
                if ((x >= -5) & (x <= -3) & ((y == x + 4) | (y == -x - 6) | (y == 2 * x + 6))) //1 область
                    count1++;
                if ((x >= -3) & (x <= -1) & ((y == Math.sqrt(4 - Math.pow((x + 1), 2)) + 1) | (y == x + 4))) //2 область
                    count1++;
                if ((x >= -1) & (x <= 2) & ((y == 2.0 / 3 * x + 11.0 / 3) | (y == 5.0 / 3 * x + 5.0 / 3))) //3 область
                    count1++;
                if ((x >= -3) & (x <= -1) & ((y == x + 4) | (y == -2 * x - 6) | (y == x))) //4 область
                    count1++;
                if ((x >= 1) & (x <= 6) & ((y == x + 1) | (y == -x / 2 + 7) |
                        (y == x - 2) | (y == x / 3 + 2.0 / 3))) { //5 область
                    count1++;
                }
                if ((x >= -2) & (x <= 1) & ((y == 5 * x / 3 + 5.0 / 3) | (y == x) | (y == x + 1))) //6 область
                    count1++;
                if ((x >= -1) & (x <= 1) & ((y == x) | (y == -Math.sqrt(4 - Math.pow((x + 1), 2)) + 1))) //7 область
                    count1++;
                if (count1 > 0)
                    return 10;
            }
        } else if (y < x - 2) { //попадание в область второй фигуры
            int Count2 = 0;
            if ((x >= 0) & (x <= 4) & (y < x / 2 - 5) & (y > x / 4 - 5)) { //1 область
                Count2++;
            }
            if ((x >= 2) & (x <= 4) & (y > -Math.sqrt(4 - Math.pow((x - 4), 2)) - 1) & (y < 1 - x)) { //2 область
                Count2++;
            }
            if ((x >= 3) & (x <= 4) & (y > 1 - x) & (y < x - 5) & (y > 1 - x)) { //3 область
                Count2++;
            }
            if ((x >= 4) & (x <= 6) & (y < Math.sqrt(4 - Math.pow((x - 4), 2)) - 1) & (y > 5 - x)) { //4 область
                Count2++;
            }
            if ((x >= 4) & (x <= 7) & (y < 0) & (y < -x + 5) & (y > -2)) { //5 область
                Count2++;
            }
            if ((x >= 4) & (x >= 5) & (y < -3 * x + 10) & (y > -x)) { //6 область
                Count2++;
            }
            if (Count2 > 0) {
                return 2;
            }
            else {
                int count2 = 0; // попадание на границу второй фигуры
                if ((x >= 0) & (x <= 4) & ((y == x / 2 - 5) | (y == x / 4 - 5))) { //1 область
                    count2++;
                }
                if ((x >= 2) & (x <= 4) & ((y == -Math.sqrt(4 - Math.pow((x - 4), 2)) - 1) | (y < 1 - x))) { //2 область
                    count2++;
                }
                if ((x >= 3) & (x <= 4) & ((y == 1 - x) | (y == x - 5) | (y == 1 - x))) { //3 область
                    count2++;
                }
                if ((x >= 4) & (x <= 6) & ((y == Math.sqrt(4 - Math.pow((x - 4), 2)) - 1) | (y == 5 - x))) { //4 область
                    count2++;
                }
                if ((x >= 4) & (x <= 7) & ((y == 0) | (y == -x + 5) | (y == -2))) { //5 область
                    count2++;
                }
                if ((x >= 4) & (x >= 5) & ((y == -3 * x + 10) | (y == -x))) { //6 область
                    count2++;
                }
                if (count2 > 0) {
                    return 20;
                }
            }
        }
        return -1;
    }
}
