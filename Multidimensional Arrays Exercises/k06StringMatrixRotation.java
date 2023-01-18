package multidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class k06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotate = scanner.nextLine();
        int angleRotation = Integer.parseInt(rotate.split("[()]+")[1]) % 360;

        String input = scanner.nextLine();
        ArrayList<String> lineForMatrix = new ArrayList<>();
        int maxLength = input.length();
        while (!input.equals("END")) {
            lineForMatrix.add(input);
            input = scanner.nextLine();
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }

        int rows = lineForMatrix.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < lineForMatrix.get(row).length()) {
                    matrix[row][col] = lineForMatrix.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        rotate(angleRotation, rows, cols, matrix);

    }

    private static void rotate(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 180){
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0 ; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (angleRotation == 270){
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
