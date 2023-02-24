package multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class k04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int firstRow = numbers[0];
        int firstCol = numbers[1];
        int[][] matrixReed = new int[firstRow][firstCol];

        fillMatrixType(scanner, matrixReed, firstRow, firstCol);

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < firstRow - 2; row++) {
            for (int col = 0; col < firstCol - 2; col++) {
                int sum = matrixReed[row][col] + matrixReed[row][col + 1] + matrixReed[row][col + 2]
                      + matrixReed[row + 1][col]  + matrixReed[row + 1][col + 1] + matrixReed[row + 1][col + 2]
                        + matrixReed[row + 2][col] + matrixReed[row + 2][col + 1] + matrixReed[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = startRow; row <= startRow + 2; row++) {
            for (int col = startCol; col <= startCol + 2; col++) {
                System.out.print(matrixReed[row][col] + " ");
            }
            System.out.println();

        }

    }

    private static void fillMatrixType(Scanner scanner, int[][] matrixReed, int firstRow, int firstCol) {
        for (int row = 0; row < firstRow; row++) {
            matrixReed[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            }
        }
    }

