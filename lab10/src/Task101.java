import java.io.*;

public class Task101 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        FileInputStream fileInputStream = new FileInputStream(file);
        int n = (int) file.length();
        byte[] masByte = new byte[n];
        fileInputStream.read(masByte);
        String string = new String(masByte);
        String[] stringSplit = string.split("\s");
        char[] masChar = new char[stringSplit.length];
        for (int i = 0; i < stringSplit.length; i++) {
            masChar[i] = stringSplit[i].charAt(0);
        }

        // проверка на вхождение символов
        int countLat = 0, countCommas = 0, parameterI = 0;
        boolean checkU = false;
        boolean checkBo = false;
        boolean checkOb = false;
        boolean checkDigit = false;
        boolean checkSiSi1 = false;
        boolean checkSjSj1 = false;
        for (int i = 0; i < masChar.length; i++) { // по длине всего массива
            for (int k = 97; k <= 122; k++) { // вхождение прописных латинских букв
                if (masChar[i] == k) {
                    countLat++;
                }
            }
            if (masChar[i] == 'ю' | masChar[i] == 'Ю') { // вхождение буквы "ю"
                checkU = true;
            }
            if (masChar[i] == ',') { // вхождение запятой
                countCommas++;
            }
        }
        for (int i = 0; i < masChar.length - 1; i++) { // идёт до предпоследнего символа
            if (masChar[i] == 'в' & masChar[i + 1] == 'о') { // вхождение 'во'
                checkBo = true;
            }
            if (masChar[i] == 'о' & masChar[i + 1] == 'в') {// вхождение 'ов'
                checkOb = true;
            }
            if (Character.isDigit(masChar[i]) & Character.isDigit(masChar[i + 1])) { // пара соседних одинаковых чисел
                if (masChar[i] == masChar[i + 1]) {
                    checkDigit = true;
                }
            }
        }
        for (int k = 2; k < masChar.length - 1; k++) { // идёт до предпоследнего символа
            if ((Character.isLowerCase(masChar[k]) & Character.isUpperCase(masChar[k + 1])) |
                    (Character.isUpperCase(masChar[k]) & Character.isLowerCase(masChar[k + 1]))) {
                // si, si+1 это одинаковые буквы отличающиеся регистром
                checkSiSi1 = true;
                parameterI = k;
                break;
            }
        }
        for (int c = parameterI + 1; c < masChar.length - 1; c++) { // идёт до предпоследнего символа
            if (Character.isDigit(masChar[c])) {
                if ((Character.digit(masChar[c], 10) == 0) & (Character.digit(masChar[c + 1], 10) == 0)) {
                    // sj, sj+1 это 0
                    checkSjSj1 = true;
                    break;
                }
            }
        }

        // вывод
        String stringForOutput = "\nКоличество латинских прописных букв: " + String.valueOf(countLat);
        byte[] byteForOutput1 = stringForOutput.getBytes();
        fileOutputStream.write(byteForOutput1);
        if (checkU) {
            stringForOutput = "\nВ массив входит буква 'ю'";
            byte[] byteForOutput2 = stringForOutput.getBytes();
            fileOutputStream.write(byteForOutput2);
        }
        if (countCommas >= 2) {
            stringForOutput = "\nВ массиве имеются две или более запятые";
            byte[] byteForOutput3 = stringForOutput.getBytes();
            fileOutputStream.write(byteForOutput3);
        }
        if (checkBo) {
            stringForOutput = "\nВ массив входит последовательность 'во'";
            byte[] byteForOutput4 = stringForOutput.getBytes();
            fileOutputStream.write(byteForOutput4);
        }
        if (checkOb) {
            stringForOutput = "\nВ массив входит последовательность 'ов'";
            byte[] byteForOutput5 = stringForOutput.getBytes();
            fileOutputStream.write(byteForOutput5);
        }
        if (checkDigit) {
            stringForOutput = "\nВ массив входит пара соседствующих одинаковых цифр";
            byte[] byteForOutput6 = stringForOutput.getBytes();
            fileOutputStream.write(byteForOutput6);
        }
        if (checkSiSi1 & checkSjSj1) {
            stringForOutput = "\nВ массиве есть такие натуральные i и j, что 1 < i < j < n и что si, si+1 " +
                    "это одинаковые буквы отличающиеся регистром, a sj, sj+1 это 0";
            byte[] byteForOutput7 = stringForOutput.getBytes();
            fileOutputStream.write(byteForOutput7);
        }
        fileOutputStream.close();
    }
}