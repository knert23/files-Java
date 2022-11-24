import java.io.*;
import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Task107 {
    public static void main(String[] args) throws IOException {
       File file = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 7.txt");
       FileOutputStream fileOS = new FileOutputStream(file);
       String stringOS = "Постановка задачи:";
       byte[] byteOS = stringOS.getBytes();
       fileOS.write(byteOS);

       stringOS = """

               for (double x = -3; x  <= 3; x += 0.5) {
                          if (x >= -1) {
                              f = cos(x) + sin(x);
                          } else {
                              f = -(pow((x + 1), 2));
                          }
                      }""";
       byteOS = stringOS.getBytes();
       fileOS.write(byteOS);

       stringOS = "\n" + "значение x" + "\t" + "значение f(x)";
       byteOS = stringOS.getBytes();
       fileOS.write(byteOS);

       DecimalFormat decimalFormat = new DecimalFormat("0.000"); // число f до двух знаков после запятой
       double f;
       for (double x = -3; x  <= 3; x += 0.5) {
           if (x >= -1) {
               f = cos(x) + sin(x);
               stringOS = "\n" + "\s\s\s" + x + "\s\s\s\s\s\s\s" + decimalFormat.format(f);
               byteOS = stringOS.getBytes();
               fileOS.write(byteOS);
           } else {
               f = -(pow((x + 1), 2));
               stringOS = "\n" + "\s\s\s" + x + "\s\s\s\s\s\s\s" + decimalFormat.format(f);
               byteOS = stringOS.getBytes();
               fileOS.write(byteOS);
           }
       }
       fileOS.close();
    }
}