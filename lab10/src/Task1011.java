import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Task1011 {

    static ArrayList<Double>  listX = new ArrayList<>();
    static ArrayList<Double> listY = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        File directory = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java");
        File file = new File(directory, "Для 11.txt");
        FileWriter fileWr = new FileWriter(file);
        FileOutputStream fileOS = new FileOutputStream(file);
        BufferedWriter fileBW = new BufferedWriter(fileWr);

        String stringOS = "Формула поверхности: " + "Math.cos(Math.sin(x) + y)." +
                "\nИнтервал x: [0,6] с шагом 0,1." +
                "\nИнтервал y: [0,5] с шагом 0,2";
        fileBW.write(stringOS);

        fileBW.newLine();
        stringOS = "Массив значений x:" + "\n";
        fileBW.write(stringOS);
        for (double i = 0; i <= 6; i += 0.1) {
            listX.add(i);
            stringOS = String.format("%.1f", i) + "\t";
            fileBW.write(stringOS);
        }

        fileBW.newLine();
        stringOS = "Массив значений y:" + "\n";
        fileBW.write(stringOS);
        for (double j = 0; j <= 5.2; j += 0.2) {
            listY.add(j);
            stringOS = String.format("%.1f", j) + "\t";
            fileBW.write(stringOS);
        }

        fileBW.newLine();
        stringOS = "Матрица значений z:" + "\n";
        fileBW.write(stringOS);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double[][] masZ = new double[listX.size()][listY.size()] ;
        for (int i = 0; i < listX.size(); i++) {
            for (int j = 0; j < listY.size(); j++) {
                masZ[i][j] = function(listX.get(i), listY.get(j));
                stringOS = decimalFormat.format(masZ[i][j]) + "\t";
                fileBW.write(stringOS);
            }
            fileBW.newLine();
        }

        fileBW.close();
    }

    public static double function(double x, double y) {
        return Math.cos(Math.sin(x) + y);
    }
}