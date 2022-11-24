import java.io.*;
import java.util.ArrayList;

public class Task1015 {

    static ArrayList<int[]> plots = new ArrayList<>();
    static ArrayList<int[]> firstThreeObjects = new ArrayList<>();
    static ArrayList<int[]> lastTwoObjects = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        File file_1 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 15_1.txt");
        FileReader fileReader_1 = new FileReader(file_1);
        BufferedReader br_1 = new BufferedReader(fileReader_1);

        File file_2 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 15_2.txt");
        FileReader fileReader_2 = new FileReader(file_2);
        BufferedReader br_2 = new BufferedReader(fileReader_2);

        File file_3 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 15_3.txt");
        FileReader fileReader_3 = new FileReader(file_3);
        BufferedReader br_3 = new BufferedReader(fileReader_3);

        File directory_4 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java");
        File file_4 = new File(directory_4, "Для 15_4.txt");
        FileWriter fileWriter_4 = new FileWriter(file_4);
        BufferedWriter bw_4 = new BufferedWriter(fileWriter_4);

        readFiles(br_1, br_2, br_3);
    }

    public static void readFiles(BufferedReader br_1, BufferedReader br_2, BufferedReader br_3) throws IOException {
        String line;
        String[] lineSplit;
        int marker = 1;
        while (br_1.ready()) {
            line = br_1.readLine();
            lineSplit = line.split("\s");
            int[] lineInteger = new int[lineSplit.length];
            for(int i = 0; i < lineSplit.length; i++) {
                lineInteger[i] = Integer.parseInt(lineSplit[i]);
            }
            plots.add(lineInteger);
        }

        while (br_1.ready()) {
            if (marker == 1) {
                br_1.readLine();
            }
            else {
                line = br_1.readLine();
                lineSplit = line.split("\s");
                int[] lineInteger = new int[lineSplit.length];
                for (int i = 0; i < lineSplit.length; i++) {
                    lineInteger[i] = Integer.parseInt(lineSplit[i]);
                }
                firstThreeObjects.add(lineInteger);
            }
            marker = 0;
        }

        while (br_1.ready()) {
            if (marker == 1) {
                br_1.readLine();
            }
            else {
                line = br_1.readLine();
                lineSplit = line.split("\s");
                int[] lineInteger = new int[lineSplit.length];
                for (int i = 0; i < lineSplit.length; i++) {
                    lineInteger[i] = Integer.parseInt(lineSplit[i]);
                }
                lastTwoObjects.add(lineInteger);
            }
            marker = 0;
        }

        br_1.close();
        br_2.close();
        br_3.close();
    }
}
