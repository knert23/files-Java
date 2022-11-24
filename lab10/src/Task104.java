import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task104 {

    static ArrayList<String> listWordsCondition1 = new ArrayList<>();
    static ArrayList<String> listWordsCondition2 = new ArrayList<>();
    static ArrayList<String> listAllWords = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        File file1 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 4_1.txt");
        File directory = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java");
        File file2 = new File(directory, "Для 4_2.txt");
        FileInputStream file1IS = new FileInputStream(file1);
        FileOutputStream file2OS = new FileOutputStream(file2);

        int n = (int) file1.length();
        byte[] byteIS = new byte[n];
        file1IS.read(byteIS);
        String stringIS = new String(byteIS);

        String[] stringIS_SplitSpace = stringIS.split("\s");
        String[] masPattern = {"_", "\\.", "\\;", ":", "\\\n", "\\\t", "\\!", "\\?"};
        String[] stringsIS_SplitSpace_SplitPattern;
        Pattern pattern;
        Matcher matcher;
        for (int i = 0 ; i < stringIS_SplitSpace.length; i++) {
            int countPattern = 0;
            for (String s : masPattern) {
                pattern = Pattern.compile(s);
                matcher = pattern.matcher(stringIS_SplitSpace[i]);
                if (matcher.find()) {
                    countPattern++;
                    stringsIS_SplitSpace_SplitPattern = stringIS_SplitSpace[i].split(s);
                    if (i == 0) {
                        listWordsCondition1.addAll(List.of(stringsIS_SplitSpace_SplitPattern));
                    } else {
                        for (String value : stringsIS_SplitSpace_SplitPattern) {
                            if (listWordsCondition1.contains(value)) {
                                int index = listWordsCondition1.indexOf(value);
                                listWordsCondition1.set(index, value);
                            } else if (!listWordsCondition1.contains(value)) {
                                listWordsCondition1.add(value);
                            }
                        }
                    }
                }
            }
            if (countPattern == 0) {
                listAllWords.add(stringIS_SplitSpace[i]);
            }
        }

        listAllWords.addAll(listWordsCondition1);
        int[] symbolVowel = {1040, 1045, 1025, 1048, 1054, 1059, 1067, 1069, 1070, 1071,1072, 1077, 1105, 1080, 1086, 1091,
        1099, 1101, 1102, 1103};
        char[] masChar;
        for (int i = 0; i < listAllWords.size(); i++) {
            int countSymbolVowel = 0;
            int countSymbolConsonant = 0;
            masChar = listAllWords.get(i).toCharArray();
            for (char c : masChar) {
                int countEntering = 0;
                if (Character.isLetter(c)) { // проверка: гласных русских букв меньше чем согласных букв
                    for (int j : symbolVowel) {
                        if (c == j) {
                            countSymbolVowel++; // считает кол-во гласных букв
                            countEntering++;
                        }
                    }
                    if (countEntering == 0) {
                        countSymbolConsonant++; // если ни разу не вошла гласная, то это согласная
                    }
                }
            }
            if (countSymbolConsonant > countSymbolVowel) {
                if (i == 0) {
                    listWordsCondition2.add(listAllWords.get(i));
                }
                else {
                    if (listWordsCondition2.contains(listAllWords.get(i))) {
                        int index = listWordsCondition2.indexOf(listAllWords.get(i));
                        listWordsCondition2.set(index, listAllWords.get(i));
                    }
                    else if (!listWordsCondition2.contains(listAllWords.get(i))) {
                        listWordsCondition2.add(listAllWords.get(i));
                    }
                }
            }
         }

        output(file2OS);
    }

    public static void output(FileOutputStream file2OS) throws IOException {
        String stringOS = "Слова, разделенные символами-разделителями «_.,;:\\n\\t!?»:";
        byte[] byteOS = stringOS.getBytes();
        file2OS.write(byteOS);

        for (String str : listWordsCondition1) {
            stringOS = "\n" + str;
            byteOS = stringOS.getBytes();
            file2OS.write(byteOS);
        }

        stringOS = "\n" + "Слова, в которых гласных русских букв меньше чем согласных букв";
        byteOS = stringOS.getBytes();
        file2OS.write(byteOS);

        for (String str : listWordsCondition2) {
            stringOS = "\n" + str;
            byteOS = stringOS.getBytes();
            file2OS.write(byteOS);
        }

        file2OS.close();
    }
}
