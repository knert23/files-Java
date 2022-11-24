import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1012 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 12.txt");
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedReader fileBR = new BufferedReader(fileReader);
        BufferedWriter fileBW = new BufferedWriter(fileWriter);

        int numberOfStudent = 1;
        while (fileBR.ready()) {
            String infAboutStudent = fileBR.readLine();
            check(infAboutStudent, fileBW, numberOfStudent);
            numberOfStudent++;
        }

        fileBW.close();
    }

    public static void check(String infAboutStudents, BufferedWriter fileBW, int numberOfStudent) throws IOException{
        String[][] masPatternAll = {{"Мужской", "мужской", "мужск", "Мужск", "Муж", "муж"},
                {"Женский", "женский", "женск", "Женск", "Жен", "жен"}, {"Город", "город", "Гор", "гор"},
                {"Область", "область", "Обл", "обл"}, {"Край", "край", "Кр", "кр"}, {"\\.\\.\\."}};
        String[] replaceAll = {"м\\.", "ж\\.", "г\\.", "обл\\.", "кр\\.", "Заполнить"};
        Pattern pattern;
        Matcher matcher;

        fileBW.newLine();
        fileBW.write("----------------------------------------------------------------------------------");

        fileBW.newLine();
        fileBW.write((numberOfStudent) + " ученик:");

        fileBW.newLine();
        fileBW.write(infAboutStudents);

        for (int i = 0; i < masPatternAll.length; i++) {
            for ( int j = 0; j < masPatternAll[i].length; j++) {
                pattern = Pattern.compile(masPatternAll[i][j]);
                matcher = pattern.matcher(infAboutStudents);
                if (matcher.find()) {
                    infAboutStudents = matcher.replaceAll(replaceAll[i]);
                    break;
                }
            }
        }
        fileBW.newLine();
        fileBW.write(infAboutStudents);
        fileBW.newLine();
    }
}
