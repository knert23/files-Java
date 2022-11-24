import java.io.*;
import java.util.ArrayList;


public class Task106 {

    static ArrayList<String> listOfNameOfClubs = new ArrayList<>();
    static ArrayList<Integer> listOfResult = new ArrayList<>();
    static ArrayList<Integer> listOfMembers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 6.txt");
        FileInputStream fileIS = new FileInputStream(file);
        FileOutputStream fileOS = new FileOutputStream(file,true);

        int n = (int) file.length();
        byte[] byteIS = new byte[n];
        fileIS.read(byteIS);
        String stringIS = new String(byteIS);
        String[] stringIS_SplitSentence = stringIS.split("\\.\s");
        String[] stringIS_SplitWords;

        for (int i = 0; i < stringIS_SplitSentence.length; i++) {
            stringIS_SplitWords = stringIS_SplitSentence[i].split(",\s");
            String club = stringIS_SplitWords[1];
            int score = Integer.parseInt(stringIS_SplitWords[3]);
            if (i == 0) {
                listOfNameOfClubs.add(club);
                listOfResult.add(score);
                listOfMembers.add(1);
            }
            else {
                if (!listOfNameOfClubs.contains(club)) {
                    listOfNameOfClubs.add(club);
                    listOfResult.add(score);
                    listOfMembers.add(1);
                }
                else if (listOfNameOfClubs.contains(club)) {
                    int index;
                    index = listOfNameOfClubs.indexOf(club);
                    listOfResult.set(index, listOfResult.get(index) + score);
                    listOfMembers.set(index, listOfMembers.get(index) + 1);
                }
            }
        }

        String stringOS_InfAboutClub;
        byte[] byteOS;
        for (int i = 0; i < listOfNameOfClubs.size(); i++) {
            String club = listOfNameOfClubs.get(i);
            String members = String.valueOf(listOfMembers.get(i));
            String score = String.valueOf(listOfResult.get(i));
            stringOS_InfAboutClub = "\n" + club + ". Количество участников: " +  members + ", общий результат: " + score;
            byteOS = stringOS_InfAboutClub.getBytes();
            fileOS.write(byteOS);
        }
        fileOS.close();
    }
}