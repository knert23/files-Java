import java.io.*;
import java.util.ArrayList;

public class Task105 {

    static ArrayList<String> listOfWords = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        File file1 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 5_1.txt");
        File file2 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 5_2.txt");
        FileInputStream fileIS = new FileInputStream(file1);
        FileOutputStream fileOS = new FileOutputStream(file2, true);

        int n = (int) file1.length();
        byte[] byteIS = new byte[n];
        fileIS.read(byteIS);
        String stringIS = new String(byteIS);
        String[] stringIS_SplitSentence = stringIS.split("\\.\s");
        String[] stringIS_SplitWords;

        for (int i = 0; i < stringIS_SplitSentence.length; i++) {
            stringIS_SplitWords = stringIS_SplitSentence[i].split("\s");
            for ( int j = 0; j < stringIS_SplitWords.length; j++) {
                if (stringIS_SplitWords[j].contains("-")) {
                    listOfWords.add(stringIS_SplitWords[j]);
                }
            }
        }

        StringBuilder stringOS = new StringBuilder();
        for (int i = 0; i < listOfWords.size(); i++) {
            stringOS.append("\n");
            stringOS.append(listOfWords.get(i));
        }
        byte[] byteOS = stringOS.toString().getBytes();
        fileOS.write(byteOS);
        fileOS.close();
    }
}
