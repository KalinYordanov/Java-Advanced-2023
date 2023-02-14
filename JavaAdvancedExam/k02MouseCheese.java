package JavaAdvancedExam;

import java.util.Scanner;

public class k2MouseAndCheese {

    private static int cheeseEat = 0;

    private static int mouseRow = -1;

    private static int mouseCol = -1;

    private static boolean mouseIsInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];


        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            char[] singleRow = line.toCharArray();
            matrix[row] = singleRow;

        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    moveMouse(matrix, -1, 0);
                    break;

                case "down":
                    moveMouse(matrix, 1, 0);
                    break;

                case "left":
                    moveMouse(matrix, 0, -1);
                    break;

                case "right":
                    moveMouse(matrix, 0, 1);
                    break;
            }

            if (!mouseIsInField){
                break;
            }

            command = scanner.nextLine();
        }
        if (!mouseIsInField) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEat >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEat);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEat);
        }

        printMatrix(matrix);
    }


    private static void moveMouse(char[][] matrix, int rowMutator, int colMutator) {

        int nextRow = mouseRow + rowMutator;
        int nextCol = mouseCol + colMutator;
        boolean isBonusHit = false;

        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[mouseRow][mouseCol] = '-';
            mouseIsInField = false;
            return;
        }
        if (matrix[nextRow][nextCol] == 'c') {
            cheeseEat++;
        } else if (matrix[nextRow][nextCol] == 'B') {
           isBonusHit = true;
        }

        matrix[mouseRow][mouseCol] = '-';
        matrix[nextRow][nextCol] = 'M';
        mouseRow = nextRow;
        mouseCol = nextCol;
        if (isBonusHit){
            moveMouse(matrix , rowMutator , colMutator);
        }
    }

    private static boolean isInBounds(char[][] matrix, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[nextRow].length;
    }



    public static void printMatrix(char[][] matrix) {
        for (char[] arr :
                matrix) {
            for (char c :
                    arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}
