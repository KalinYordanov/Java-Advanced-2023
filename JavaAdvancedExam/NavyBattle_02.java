package JavaAdvancedExam;

import java.util.Scanner;

public class NavyBattle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int battleSize = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[battleSize][battleSize];
        fillMatrix(matrix, scanner);
        int subRow = -1;
        int subCol = -1;
        int countHits = 0;
        int countCruiser = 0;

        for (int row = 0; row < battleSize; row++) {
            for (int col = 0; col < battleSize; col++) {
                if (matrix[row][col].equals("S")) {
                    subRow = row;
                    subCol = col;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        while (true) {
            matrix[subRow][subCol] = "-";
            if (command.equals("up")) {
                subRow--;

            } else if (command.equals("down")) {
                subRow++;

            } else if (command.equals("left")) {
                subCol--;

            } else if (command.equals("right")) {
                subCol++;
            }
            String submarinePosition = matrix[subRow][subCol];
            if (submarinePosition.equals("-")){
                matrix[subRow][subCol] = "S";
            }else if (submarinePosition.equals("*")){
                matrix[subRow][subCol] = "S";
                countHits++;
                if (countHits == 3){
                    System.out.printf("Mission failed, U-9 disappeared! Last know coordinates [%d, %d]!%n",subRow,subCol);
                    break;
                }

            }else if (submarinePosition.equals("C")){
                matrix[subRow][subCol] = "S";
                countCruiser++;
                if (countCruiser == 3){
                    System.out.printf("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!%n");
                    break;
                }
            }

            command = scanner.nextLine();
        }
        printMatrix(matrix);


    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("");
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }

}
