import java.io.*;
import java.util.ArrayList;

public class Task1014 {

    static ArrayList<String> data = new ArrayList<>();
    static ArrayList<String> firstLine = new ArrayList<>();
    static ArrayList<double[]> dataDouble = new ArrayList<>();
    static ArrayList<double[]> dataDoubleDeviation = new ArrayList<>();

    public static void main (String[] args) throws IOException{
        File file = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Файлы к заданию\\Variant_5,15.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader fileBR = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter fileBW = new BufferedWriter(fileWriter);

        readData(fileBR);
        analyzes(fileBW);
    }

    public static void readData (BufferedReader fileBR)  throws IOException{
        String line;
        int count = 0, marker = 0;
        String[] lineSplit;
        while (fileBR.ready()) {
            line = fileBR.readLine();
            if (count == 0) {
                marker = Integer.parseInt(line);
            }

            if (count == marker) {
                lineSplit = line.split("\s");
                for (int i = 0; i < lineSplit.length; i++) {
                    firstLine.add(lineSplit[i]);
                }
            }
            if (count > marker) {
                lineSplit = line.split("\s");
                double[] lineInteger = new double[lineSplit.length];
                for (int i = 0; i < lineSplit.length; i++) {
                    lineInteger[i] = Double.parseDouble(lineSplit[i]);
                }
                data.add(line);
                dataDouble.add(lineInteger);
            }
            count++;
        }

        fileBR.close();
    }

    public static void analyzes(BufferedWriter fileBW)  throws IOException{
        double[][] answer = new double[3][dataDouble.get(0).length];
        for (int j = 0; j < dataDouble.get(0).length; j++) { // max, min, middle value

            double max = dataDouble.get(0)[j], min = dataDouble.get(0)[j];

            for (int i = 0; i < dataDouble.size(); i++) {
                if (dataDouble.get(i)[j] > max) {
                    max = dataDouble.get(i)[j];
                }

                if (dataDouble.get(i)[j] < min) {
                    min = dataDouble.get(i)[j];
                }

                answer[2][j] += dataDouble.get(i)[j]/ dataDouble.size();
            }

            answer[1][j] = min;
            answer[0][j] = max;
        }

        for (int i = 0; i < dataDouble.size(); i++) { // отклонение от средненего значения
            double deviation;
            double[] masDeviation = new double[dataDouble.get(0).length];

            for (int j = 0; j < dataDouble.get(0).length; j++) {
                deviation = Math.abs(answer[2][j] - dataDouble.get(i)[j]);
                masDeviation[j] = deviation;
            }

            dataDoubleDeviation.add(masDeviation);
        }
        output(fileBW, answer);
    }

    public static void output(BufferedWriter fileBW, double[][] answer) throws IOException {
        fileBW.newLine();
        String print = "\nОтвет на первый вопрос:";
        fileBW.write(print);
        fileBW.newLine();

        for (int i = 0; i < 3; i++) {
            print = "";
            if (i == 0) {
                print = "max\t";
            }
            else if (i == 1) {
                print = "min\t";
            }
            else {
                print = "middle value\t";
            }
            fileBW.write(print);

            for (int j = 0; j < dataDouble.get(0).length; j++) {
                print = String.format("%.4e\t", answer[i][j]);
                fileBW.write(print);
            }

            fileBW.newLine();
        }

        fileBW.newLine();
        print = "Ответ на второй вопрос:";
        fileBW.write(print);
        fileBW.newLine();

        for (int i = 0; i < dataDoubleDeviation.size(); i++) {
            for (int j = 0; j < dataDoubleDeviation.get(0).length; j++) {
                print = String.format("%.4e\t", dataDoubleDeviation.get(i)[j]);
                fileBW.write(print);
            }
            fileBW.newLine();
        }

        fileBW.close();
    }
}
