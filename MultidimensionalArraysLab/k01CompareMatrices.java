package MultidimensionalArraysLab;
import java.util.Scanner;

public class k01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        int firstRows = Integer.parseInt(input[0]);
        int firstCols = Integer.parseInt(input[1]);

        int [][] matrix = new int[firstRows][firstCols];

        for (int row = 0; row < firstRows; row++) {
           String[] parts = scanner.nextLine().split(" ");
            for (int col = 0; col <firstCols; col++) {
                matrix[row][col] = Integer.parseInt(parts[col]);
            }
        }

        input = scanner.nextLine().split(" ");
        int secondRows = Integer.parseInt(input[0]);
        int secondCols = Integer.parseInt(input[1]);
        int [][] secondMatrix = new int[secondRows][secondCols];



        for (int i = 0; i < secondRows; i++) {
            String[] parts = scanner.nextLine().split(" ");
            for (int j = 0; j < secondCols; j++) {
                secondMatrix[i][j] = Integer.parseInt(parts[j]);
            }
        }
        if (firstRows != secondRows || firstCols != secondCols){
            System.out.println("not equal");
            return;
        }

        for (int i = 0; i < firstRows; i++) {
            for (int j = 0; j < firstCols; j++) {
                if (matrix[i][j] != secondMatrix[i][j]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
