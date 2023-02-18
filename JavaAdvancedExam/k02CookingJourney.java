import java.util.Scanner;

public class k02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        int currentRow = -1;
        int currentCol = -1;
        int firstPillarRow = -1;
        int firstPillarCol = -1;
        int secondPillarRow = -1;
        int secondPillarCol = -1;
        int countPilar = 0;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = input[col];
                if (matrix[row][col].equals("S")) {
                    currentRow = row;
                    currentCol = col;
                }
                if (matrix[row][col].equals("P") && countPilar > 0) {
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
                if (matrix[row][col].equals("P") && countPilar == 0) {
                    firstPillarRow = row;
                    firstPillarCol = col;
                    countPilar++;
                }
            }
        }
        int money = 0;

        while (money < 50) {
            String command = scanner.nextLine();
            int oldRow = currentRow;
            int oldCol = currentCol;
            if (command.equals("left")) {
                currentCol--;
            } else if (command.equals("right")) {
                currentCol++;
            } else if (command.equals("up")) {
                currentRow--;
            } else if (command.equals("down")) {
                currentRow++;
            }
            if (currentRow < 0 || currentCol < 0 || currentRow >= size || currentCol >= size) {
                matrix[oldRow][oldCol] = "-";
                break;
            }
            if (currentRow == firstPillarRow && currentCol == firstPillarCol){
                matrix[oldRow][oldCol] = "-";
                currentRow = secondPillarRow;
                currentCol = secondPillarCol;
                matrix[firstPillarRow][firstPillarCol] = "-";
                matrix[secondPillarRow][secondPillarCol] = "S";
            } else if (currentRow == secondPillarRow && currentCol == secondPillarCol){
                matrix[oldRow][oldCol] = "-";
                currentRow = secondPillarRow;
                currentCol = secondPillarCol;
                matrix[secondPillarRow][secondPillarCol] = "-";
                matrix[firstPillarRow][firstPillarCol] = "S";
            } else if (matrix[currentRow][currentCol].equals("-")) {
                matrix[oldRow][oldCol] = "-";
                matrix[currentRow][currentCol] = "S";
            } else {
                money += Integer.parseInt(matrix[currentRow][currentCol]);
                matrix[oldRow][oldCol] = "-";
                matrix[currentRow][currentCol] = "S";
            }
        }
        if (money < 50){
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n",money);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
