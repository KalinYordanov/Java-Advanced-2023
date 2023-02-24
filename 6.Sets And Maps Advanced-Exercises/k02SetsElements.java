package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class k02SetsElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int firstSetSize = Integer.parseInt(input.split("\\s+")[0]);
        int secondSetSize = Integer.parseInt(input.split("\\s+")[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(firstSetSize);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>(secondSetSize);

        for (int number = 0; number < firstSetSize; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            firstSet.add(value);
        }
        for (int number = 0; number < secondSetSize; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            secondSet.add(value);
        }
        firstSet.retainAll(secondSet);
       // firstSet.forEach(number -> System.out.print(number + " "));
        for (Integer number :
                firstSet) {
            System.out.print(number + " ");
        }

    }
}
