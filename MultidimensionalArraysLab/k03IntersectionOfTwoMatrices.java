package MultidimensionalArraysLab;

import java.util.Scanner;

public class k03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        char[][] matrixA = new char[row][col];
        char[][] matrixB = new char[row][col];

        for (int r = 0; r < row; r++) {
            String string = scanner.nextLine().trim().replace(" ", "");
            matrixA[r] = string.toCharArray();
        }
        for (int r = 0; r < row; r++) {
            String string = scanner.nextLine().trim().replace(" ", "");
            matrixB[r] = string.toCharArray();
        }

        char[][] matrixC = new char[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrixA[r][c] == matrixB[r][c]) {
                    matrixC[r][c] = matrixA[r][c];
                } else {
                    matrixC[r][c] = '*';
                }
            }
        }
        for (char[] x :
                matrixC) {
            for (char y :
                    x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

