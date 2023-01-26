package JavaAdvancedExam;
import java.util.Scanner;
public class k02MouseCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char [][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String rowContent = scanner.nextLine();
            char[] rowSymbols = rowContent.toCharArray();
            matrix[row] = rowSymbols;
        }
        String command = scanner.nextLine();
        while (!command.equals("end")){




            command = scanner.nextLine();

        }

    }
}
