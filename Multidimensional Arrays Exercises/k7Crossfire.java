package multidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class k7Crossfire {
    public static List<List<Integer>> matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrix = new ArrayList<>();
        populateMatrix(scanner);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] inputArg = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int bombRow = inputArg[0];
            int bombCol = inputArg[1];
            int bombPower = inputArg[2];

            dropTheBomb(bombRow, bombCol, bombPower);
            input = scanner.nextLine();
        }
        System.out.println(printMatrix(matrix));
    }

    private static String printMatrix(List<List<Integer>> matrix) {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                builder.append(matrix.get(row).get(col)).append(" ");
            }
            if (row != matrix.size() - 1) {
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    private static void dropTheBomb(int bombRow, int bombCol, int bombPower) {
        destroyVertical(bombRow, bombCol, bombPower);
        destroyHorizontal(bombRow, bombCol, bombPower);
        clearDebris();
    }

    private static void clearDebris() {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                if (matrix.get(row).get(col) == -1) {
                    matrix.get(row).remove(col);
                    col--;
                }
            }
        }
        for (int row = 0; row < matrix.size(); row++) {
            if (matrix.get(row).size() == 0) {
                matrix.remove(row);
                row--;
            }
        }
    }


    private static void destroyHorizontal(int bombRow, int bombCol, int bombPower) {
        for (int col = bombCol - bombPower; col <= bombCol + bombPower; col++) {
            if (isInsideTheMatrix(bombRow, col)) {
                matrix.get(bombRow).set(col, -1);
            }

        }

    }

    private static void destroyVertical(int bombRow, int bombCol, int bombPower) {
        for (int row = bombRow - bombPower; row <= bombRow + bombPower; row++) {
            if (isInsideTheMatrix(row, bombCol)) {
                matrix.get(row).set(bombCol, -1);
            }
        }
    }

    private static boolean isInsideTheMatrix(int row, int col) {
        if (row < 0 || row >= matrix.size() || col < 0 || col >= matrix.get(row).size()) {
            return false;
        }
        return true;
    }

    private static void populateMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
    }
}
