package MultidimensionalArraysLab;

import java.util.Scanner;

public class k06PrintDiagonalsSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            int[] currentRow = new int[size];
            String[] columnData = scanner.nextLine().split(" ");
            for (int col = 0; col < columnData.length; col++) {
                currentRow[col] = Integer.parseInt(columnData[col]);
            }
            matrix[row] = currentRow;
        }
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        for (int row = size - 1, col = 0; col < size; row--, col++) {
            System.out.print(matrix[row][col] + " ");
        }
    }
}

