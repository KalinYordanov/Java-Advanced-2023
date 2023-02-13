package ExamPrep17october22;

import java.util.Scanner;

public class ReVolt {
    public static int playerRow;
    public static int playerCol;
    public static boolean hasWon;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.toCharArray();
            if (matrixRow.contains("f")) {
                playerRow = row;
                playerCol = matrixRow.indexOf("f");
            }
        }
        while (numberOfCommands-- > 0 && !hasWon) {
            String comand = scanner.nextLine();
            if (comand.equals("up")) {
                movePlayer(matrix, -1, 0);
            } else if (comand.equals("down")) {
                movePlayer(matrix, 1, 0);
            } else if (comand.equals("left")) {
                movePlayer(matrix, 0, -1);
            } else if (comand.equals("right")) {
                movePlayer(matrix, 0, 1);
            }
        }
        System.out.println(hasWon ? "Player won!" : "Player lost!");
        print(matrix);
    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playerRow + rowMutator;
        int nextCol = playerCol + colMutator;
        if (isOutOfBounds(matrix, nextRow, nextCol)) {
            if (nextRow < 0 || nextRow >= matrix.length) {
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            } else {
                nextCol = nextCol < 0 ? matrix[nextRow].length - 1 : 0;
            }

        }
        if (matrix[nextRow][nextCol] == 'T') {
            return;
        } else if (matrix[nextRow][nextCol] == 'B') {
            matrix[playerRow][playerCol] = '-';
            playerRow = nextRow;
            playerCol = nextCol;
            movePlayer(matrix, rowMutator, colMutator);
            return;
        } else if (matrix[nextRow][nextCol] == 'F') {
            hasWon = true;
        }
        if (matrix[playerRow][playerCol] != 'B'){
            matrix[playerRow][playerCol] = '-';
        }
        matrix[nextRow][nextCol] = 'f';
        playerRow = nextRow;
        playerCol = nextCol;
    }

    private static boolean isOutOfBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[nextRow].length;
    }


    public static void print(char[][] matrix) {
        for (char[] chars :
                matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
