package SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class k03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> productTable = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] track = scanner.nextLine().split("\\s+");
            productTable.addAll(Arrays.asList(track));
        }
        System.out.print(String.join(" ",productTable));
    }
}
