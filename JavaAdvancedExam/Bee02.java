package JavaAdvancedExam;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flowers = 0;
        int size = Integer.parseInt(scanner.nextLine());


        char[][] teritory = new char[size][size];
        int beeRow = -1;
        int beeCol = -1;
        for (int row = 0; row < size; row++) {
            char[] singleRow = scanner.nextLine().toCharArray();
            teritory[row] = singleRow;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (teritory[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;

                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            teritory[beeRow][beeCol] = '.';
            if (command.equals("right") && beeCol != size - 1) {
                beeCol++;
            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;
            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else {
                teritory[beeRow][beeCol] = '.';
                System.out.println("The bee got lost!");
                break;
            }
            if (teritory[beeRow][beeCol] == 'f') {
                flowers++;
            } else if (teritory[beeRow][beeCol] == 'O') {
                continue;
            }
            teritory[beeRow][beeCol] = 'B';
            command = scanner.nextLine();
        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",flowers);
        }
        printMatrix(size, teritory, beeRow, beeCol);
    }

    private static void printMatrix(int size, char[][] teritory, int beeRow, int beeCol) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(teritory[i][j]);
            }
            System.out.println();
        }
    }
}
