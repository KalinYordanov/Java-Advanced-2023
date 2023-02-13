package JavaAdvancedExam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class k02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        //Намираме колко реда и колони ще има матрицата и я създаваме;
        int rowSize = Integer.parseInt(dimensions[0]);
        int colSize = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rowSize][colSize];

        List<String> path = new LinkedList<>();
        fillMatrix(matrix, scanner);

        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("Y")) {
                    currentRow = row;
                    currentCol = col;

                }
            }
        }


        String command = scanner.nextLine();

        while (!command.equals("Finish")) {


            switch (command) {
                case "up":
                    currentRow--;
                    if (isOutside(currentRow, currentCol, matrix) ||isThereТ(currentRow, currentCol, matrix)) {
                        currentRow++;
                    }else{
                        path.add(command);
                    }
                    break;
                case "down":
                    currentRow++;
                    if (isOutside(currentRow, currentCol, matrix)|| isThereТ(currentRow, currentCol, matrix)) {
                        currentRow--;
                    } else{
                        path.add(command);
                    }
                    break;
                case "left":
                    currentCol--;
                    if (isOutside(currentRow, currentCol, matrix) || isThereТ(currentRow, currentCol, matrix)) {
                        currentCol++;
                    } else {
                        path.add(command);
                    }
                    break;
                case "right":
                    currentCol++;
                    if (isOutside(currentRow, currentCol, matrix) || isThereТ(currentRow, currentCol, matrix)) {
                        currentCol--;
                    } else {
                        path.add(command);
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        if (matrix[currentRow][currentCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static boolean isOutside(int row, int col, String[][] matrix) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return true;
        }

            return false;

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    public static boolean isThereТ(int row, int col, String[][] matrix) {
        if (matrix[row][col].equals("T")) {
            return true;
        }
        return false;
    }
}