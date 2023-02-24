package multidimensionalArraysExercises;

import java.util.Scanner;

public class k03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];


        fillMatrix(matrix, scanner);
        int sumPrimary = getSumElementsOfPrimaryDiagonal(matrix);
        int sumSecondary = getSumElementsOfSecond(matrix);

        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumElementsOfSecond(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (col == matrix.length - row - 1) {
                    sum += currentElement;

                }
            }
        }
        return sum;
    }

    private static int getSumElementsOfPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (row == col) {
                    sum += currentElement;
                }
            }
        }


        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
