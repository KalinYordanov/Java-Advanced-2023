package ExamPrep17october22;

import java.util.Scanner;

public class Snake02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][];
        int snakeRow = -1;
        int snakeCol = -1;
        int learFirstRow = -1, learFirstCol = -1,
                learSecondRow = -1, learSecondCol = -1;


        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().toCharArray();


            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
                if (field[i][j] == 'B') {
                    if (learFirstRow == -1) {
                        learFirstRow = i;
                        learFirstCol = j;
                    } else {
                        learSecondRow = i;
                        learSecondCol = j;
                    }
                }
            }

        }
        int foodEaten = 0;
        while (foodEaten < 10) {
            String command = scanner.nextLine();
            field[snakeRow][snakeCol] = '.';
            switch (command) {
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "up":
                    snakeRow--;
                    break;
            }
            if (snakeRow < 0 || snakeRow >= n || snakeCol < 0 || snakeCol >= n) {
                break;

            }
            if (field[snakeRow][snakeCol] == '*') {
                foodEaten++;
            }
            if (snakeRow == learFirstRow && snakeCol == learFirstCol) {
                field[snakeRow][snakeCol] = '.';
                snakeRow = learSecondRow;
                snakeCol = learSecondCol;
            } else if (snakeRow == learSecondRow && snakeCol == learSecondCol) {
                field[snakeRow][snakeCol] = '.';
                snakeRow = learFirstRow;
                snakeCol = learFirstCol;
            }

            field[snakeRow][snakeCol] = 'S';
        }
        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", foodEaten);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
