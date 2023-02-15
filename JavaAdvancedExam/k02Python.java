package JavaAdvancedExam;

import java.util.List;
import java.util.Scanner;

public class k02Python {

    public static int food = 0;
    public static int pRow = -1;
    public static int pCol = -1;
    public static int length = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] pythonField = new char[size][size];

        String[] commands = scanner.nextLine().split(", ");


        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            pythonField[row] = line.toCharArray();

            if (line.contains("s")) {
                pRow = row;
                pCol = line.indexOf("s");
            }
            for (char c : pythonField[row]) {
                if (c == 'f') {
                    food++;
                }
            }
        }

        for (String command : commands) {
            if (command.equals("up")) {
                movePython(pythonField, pRow - 1, pCol);
            } else if (command.equals("down")) {
                movePython(pythonField, pRow + 1, pCol);
            } else if (command.equals("left")) {
                movePython(pythonField, pRow, pCol - 1);
            } else if (command.equals("right")) {
                movePython(pythonField, pRow, pCol + 1);
            }

            if (length == -1 || food == 0) {
                break;
            }
        }


        if (food == 0) {
            System.out.println("You win! Final python length is " + length);
        } else if (food > 0 && length != -1) {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        } else {
            System.out.println("You lose! Killed by an enemy!");
        }
    }

    private static void movePython(char[][] pythonField, int newRow, int newCol) {
        //Moving python
        if (isOutOfBounds(pythonField, newRow, newCol)) {
            int[] newIndex = flipSnakeSide(pythonField.length, newRow, newCol);
            newRow = newIndex[0];
            newCol = newIndex[1];
        }

        if (pythonField[newRow][newCol] == 'e') {
            length = -1;
        } else if (pythonField[newRow][newCol] == 'f') {
            length++;
            food--;
        }

        pRow = newRow;
        pCol = newCol;
    }

    private static int[] flipSnakeSide(int length, int r, int c) {
        //намираме от къде излиза и го презаписваме в противоположната страна (up <-> down , left <-> right)
        int[] result = new int[2];
        if (r < 0) {
            result[0] = length - 1;
            result[1] = c;
        } else if (r >= length) {
            result[1] = c;
        } else if (c < 0) {
            result[0] = r;
            result[1] = length - 1;
        } else if (c >= length) {
            result[0] = r;
        }


        return result;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        //метод за намиране дали сме излезнали от границата на матрицата
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;

    }
}
