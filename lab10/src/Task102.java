import java.io.*;

public class Task102 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 2.txt");
        FileOutputStream fileOS = new FileOutputStream(file, true);
        int i, j;
        String stringOS = "";
        byte[] byteOS;
        for (i = 1; i <= 9; i++) {
            for (j = 1; j <= 9; j++) {
                stringOS = String.valueOf(i) + " x " + String.valueOf(j) + " = " + String.valueOf(i * j) + "\t";
                byteOS = stringOS.getBytes();
                fileOS.write(byteOS);
            }
            stringOS = "\n";
            byteOS = stringOS.getBytes();
            fileOS.write(byteOS);
        }
        fileOS.close();
    }
}