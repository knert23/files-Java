import java.io.*;
import java.util.ArrayList;

public class Task1013 {

    static ArrayList<String> matrix_1String = new ArrayList<>();
    static ArrayList<double[]> matrix_1Double = new ArrayList<>();
    static ArrayList<Integer> matrix_1QuantityRow = new ArrayList<>();
    static ArrayList<String> matrix_2String = new ArrayList<>();
    static ArrayList<double[]> matrix_2Double = new ArrayList<>();
    static ArrayList<Integer> matrix_2QuantityRow = new ArrayList<>();
    static ArrayList<double[]> matrixResultDouble = new ArrayList<>();
    static ArrayList<String> matrixResultString = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File file_1 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 13_1.txt");
        FileReader fileReader_1 = new FileReader(file_1);
        BufferedReader fileBF_1 = new BufferedReader(fileReader_1);

        File file_2 = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java\\Для 13_2.txt");
        FileReader fileReader_2 = new FileReader(file_2);
        BufferedReader fileBR_2 = new BufferedReader(fileReader_2);

        File directory = new File("C:\\Users\\pc\\OneDrive\\Документы\\Инфа\\Java\\Лаба 10(7) Java");
        File fileWithResult = new File(directory, "Для 13_3.txt");
        FileWriter fileWriter_Result = new FileWriter(fileWithResult);
        BufferedWriter fileBW_Result = new BufferedWriter(fileWriter_Result);

        readMatrices(fileBF_1, fileBR_2, fileBW_Result);
    }

    public static void readMatrices(BufferedReader fileBR_1, BufferedReader fileBR_2, BufferedWriter fileBW_Result)
    throws IOException{
        String line;
        int countRowMatrix1 = 0;
        while (fileBR_1.ready()) { // считываем матрицы из первого файла
            line = fileBR_1.readLine();
            if (!line.equals("")) { // вычисление количества строк до предпоследней матрицы
                countRowMatrix1++;
                matrix_1String.add(line);
            }
            else {
                matrix_1QuantityRow.add(countRowMatrix1);
                countRowMatrix1 = 0;
            }

        }

        int countRowMatrix2 = 0;
        while (fileBR_2.ready()) { // считываем матрицы из второго файла
            line = fileBR_2.readLine();
            if (!line.equals("")) { // вычисление количества строк до предпоследней матрицы
                countRowMatrix2++;
                matrix_2String.add(line);
            }
            else {
                matrix_2QuantityRow.add(countRowMatrix2);
                countRowMatrix2 = 0;
            }

        }

        fileBR_1.close();
        fileBR_2.close();
        transferToInteger(fileBW_Result);
    }

    public static void transferToInteger(BufferedWriter fileBW_Result) throws IOException {
        String[] row;
        double[] rowInteger;
        int matrix_1quantityRowLast;
        int matrix_1QuantityRowSum = 0;
        for (int d : matrix_1QuantityRow) {
            matrix_1QuantityRowSum += d;
        }
        for (String value : matrix_1String) { // переводим String в int, 1 файл
            row = value.split("\s");
            rowInteger = new double[row.length];
            for (int j = 0; j < row.length; j++) {
                rowInteger[j] = Integer.parseInt(row[j]);
            }
            matrix_1Double.add(rowInteger);
        }
        matrix_1quantityRowLast = matrix_1Double.size() - matrix_1QuantityRowSum;
        matrix_1QuantityRow.add(matrix_1quantityRowLast); // добавляем кол-во строк последней матрицы, 1 файл

        int matrix_2quantityRowLast;
        int matrix_2QuantityRowSum = 0;
        for (int d : matrix_2QuantityRow) {
            matrix_2QuantityRowSum += d;
        }
        for (String s : matrix_2String) { // переводим String в int, 2 файл
            row = s.split("\s");
            rowInteger = new double[row.length];
            for (int j = 0; j < row.length; j++) {
                rowInteger[j] = Integer.parseInt(row[j]);
            }
            matrix_2Double.add(rowInteger);
        }
        matrix_2quantityRowLast = matrix_2Double.size() - matrix_2QuantityRowSum;
        matrix_2QuantityRow.add(matrix_2quantityRowLast); // добавляем кол-во строк последней матрицы, 2 файл

        multiply();
        output(fileBW_Result);
    }

    public static void multiply() {
        int rowLengthMatrix1; // количество строк матрицы 1 файла
        int columnLengthMatrix1; // количество столбцов матрицы 1 файла
        int rowLengthMatrix2; // количество строк матрицы 2 файла
        int columnLengthMatrix2; // количество столбцов матрицы 2 файла

        for (int c = 0; c < matrix_1QuantityRow.size(); c++) { // в 1 и 2 лежит одиннаковое кол-во размеров
            ArrayList<double[]> copyOfMatrix_1Double = new ArrayList<>(matrix_1Double);
            ArrayList<double[]> copyOfMatrix_2Double = new ArrayList<>(matrix_2Double);

            rowLengthMatrix1 = matrix_1QuantityRow.get(c);
            columnLengthMatrix1 = matrix_1Double.get(rowLengthMatrix1 - 1).length;

            rowLengthMatrix2 = matrix_2QuantityRow.get(c);
            columnLengthMatrix2 = matrix_2Double.get(rowLengthMatrix2 - 1).length;

            String[] gettingMatrixRowString = new String[rowLengthMatrix1];
            double[][] gettingMatrix = new double[rowLengthMatrix1][columnLengthMatrix2];
            for (int i = 0; i < rowLengthMatrix1; i++) {// перемножение матриц из 1 и 2 файлов
                for (int j = 0; j < columnLengthMatrix2; j++) {
                    for (int k = 0; k < columnLengthMatrix1; k++) {
                        gettingMatrix[i][j] += matrix_1Double.get(i)[k] * matrix_2Double.get(k)[j];
                    }
                    gettingMatrixRowString[i] = String.valueOf(gettingMatrix[i][j]);
                }
                matrixResultString.add(gettingMatrixRowString[i]);
                matrixResultDouble.add(gettingMatrix[i]);
            }


            matrix_1Double.clear();
            for (int u = rowLengthMatrix1; u < copyOfMatrix_1Double.size(); u++) {
                matrix_1Double.add(copyOfMatrix_1Double.get(u));
            }

            matrix_2Double.clear();
            for (int u = rowLengthMatrix2; u < copyOfMatrix_2Double.size(); u++) {
                matrix_2Double.add(copyOfMatrix_2Double.get(u));
            }
        }
    }

    public static void output(BufferedWriter fileBW_Result) throws IOException {
        ArrayList<String> cloneOfMatrix_1String = new ArrayList<>(matrix_1String);
        ArrayList<String> cloneOfMatrix_2String = new ArrayList<>(matrix_2String);
        ArrayList<String> cloneOfMatrixResultString = new ArrayList<>(matrixResultString);
        int indexOfBeginningMatrix1 = 0;
        int indexOfBeginningMatrix2 = 0;

        for (int i = 0; i < matrix_1QuantityRow.size(); i++) {
            String result = "\t\t\t\t\t\t\tБлок матриц №"  + (i + 1);
            fileBW_Result.write(result);

            result = "Матрица из 1-го файла\t\t\t" + "Матрица из 2-го файла\t\t\t" +
                    "Матрица, полученная умножением предыдущих";
            fileBW_Result.newLine();
            fileBW_Result.write(result);

            int maxQuantityRow;
            if (matrix_1QuantityRow.get(i) > matrix_2QuantityRow.get(i)) {
                maxQuantityRow = matrix_1QuantityRow.get(i);
            }
            else {
                maxQuantityRow = matrix_2QuantityRow.get(i);
            }
            //System.out.println(maxQuantityRow);
            // добавляем пустые строки, чтобы можно было вывести
            for (int t = 0; t < maxQuantityRow; t++) {
               if (matrix_1QuantityRow.get(i) < t + 1) {
                    cloneOfMatrix_1String.add(t, "");

               }
               if (matrix_2QuantityRow.get(i) < t + 1) {
                    cloneOfMatrix_2String.add(t, "");

               }
               if (matrix_1QuantityRow.get(i) < t + 1) {
                    cloneOfMatrixResultString.add(t, "");

               }
            }
            String matrix1Output;
            String matrix2Output;
            String matrixResultOutput;
            for (int l = 0; l < maxQuantityRow; l++) {
                matrix1Output = cloneOfMatrix_1String.get(l);
                matrix2Output = cloneOfMatrix_2String.get(l);
                matrixResultOutput = cloneOfMatrixResultString.get(l);
                result = "\t" + matrix1Output + "\t\t\t\t\t\t" + matrix2Output + "\t\t\t\t\t\t" + matrixResultOutput;
                fileBW_Result.newLine();
                fileBW_Result.write(result);
            }

            indexOfBeginningMatrix1 += matrix_1QuantityRow.get(i);
            indexOfBeginningMatrix2 += matrix_2QuantityRow.get(i);

            cloneOfMatrix_1String.clear();
            for (int u = indexOfBeginningMatrix1; u < matrix_1String.size(); u++) {
                cloneOfMatrix_1String.add(matrix_1String.get(u));
            }
            cloneOfMatrix_2String.clear();
            for (int u = indexOfBeginningMatrix2; u < matrix_2String.size(); u++) {
                cloneOfMatrix_2String.add(matrix_2String.get(u));
            }
            cloneOfMatrixResultString.clear();
            for (int u = indexOfBeginningMatrix1; u < matrix_1String.size(); u++) {
                cloneOfMatrixResultString.add(matrixResultString.get(u));
            }


            fileBW_Result.newLine();
        }

        fileBW_Result.close();
    }
}