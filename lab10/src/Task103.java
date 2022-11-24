import java.io.*;

import static java.lang.System.out;

public class Task103 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 3.txt");
        FileInputStream fileIS = new FileInputStream(file);
        int n  = (int) file.length();
        byte[] byteIS = new byte[n];
        fileIS.read(byteIS);
        String string = new String(byteIS);
        String[] stringSplit = string.split("\s");
        for (int i = 0; i < stringSplit.length; i++) {
            if (check(stringSplit[i].toCharArray())) {
                out.println(stringSplit[i]);
            }
        }
    }

    public static boolean check(char[] array) {
        int count = 0;
        for (int k = 97; k <= 122; k++) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == k) {
                    count++;
                }
            }
        }
        return count == array.length;
    }
}