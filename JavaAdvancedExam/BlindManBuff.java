import java.util.Scanner;

public class BlindManBuff {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int bRow = 0;
        int bCol = 0;
        int opponentsTouch = 0;
        int moves = 0;

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] field = new String[rows][cols];
        fillField(scanner, field);





        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("B")) {
                    bRow = row;
                    bCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {

            field[bRow][bCol] = "-";

            int newRow = bRow;
            int newCol = bCol;

            switch (command) {
                case "up":
                    newRow--;
                    if (newRow < 0 || field[newRow][newCol].equals("O")) {
                        newRow = bRow;
                    } else if (field[newRow][newCol].equals("-")) {
                        moves += 1;
                        bRow = newRow;
                    } else if (field[newRow][newCol].equals("P")) {
                        moves += 1;
                        opponentsTouch += 1;
                        field[newRow][newCol] = "-";
                        bRow = newRow;
                    }
                    break;
                case "down":
                    newRow++;
                    if (newRow > rows - 1 || field[newRow][newCol].equals("O")) {
                        newRow = bRow;
                    } else if (field[newRow][newCol].equals("-")) {
                        moves += 1;
                        bRow = newRow;
                    } else if (field[newRow][newCol].equals("P")) {
                        moves += 1;
                        opponentsTouch += 1;
                        field[newRow][newCol] = "-";
                        bRow = newRow;
                    }
                    break;
                case "left":
                    newCol--;
                    if (newCol < 0 || field[newRow][newCol].equals("O")) {
                        newCol = bCol;
                    } else if (field[newRow][newCol].equals("-")) {
                        moves += 1;
                        bCol = newCol;
                    } else if (field[newRow][newCol].equals("P")) {
                        moves += 1;
                        opponentsTouch += 1;
                        field[newRow][newCol] = "-";
                        bCol = newCol;
                    }
                    break;
                case "right":
                    newCol++;
                    if (newCol > cols - 1 || field[newRow][newCol].equals("O")) {
                        newCol = bCol;
                    } else if (field[newRow][newCol].equals("-")) {
                        moves += 1;
                        bCol = newCol;
                    } else if (field[newRow][newCol].equals("P")) {
                        moves += 1;
                        opponentsTouch += 1;
                        field[newRow][newCol] = "-";
                        bCol = newCol;
                    }
                    break;
            }
            if (opponentsTouch == 3) {
                break;
            }
            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", opponentsTouch, moves);

    }

    private static void fillField(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            matrix[row] = input;
        }
    }
}



