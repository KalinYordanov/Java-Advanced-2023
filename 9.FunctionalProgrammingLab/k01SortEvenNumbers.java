package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class k01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());

        numbers.removeIf(num -> num % 2 != 0);
        //  numbers.forEach(num -> System.out.print(num + ", "));
        printWithSep(numbers);
        System.out.println();
        List<Integer> sortedNumbers = numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());

        printWithSep(sortedNumbers);
    }

    private static void printWithSep(List<Integer> sortedNumbers) {
        for (int i = 0; i < sortedNumbers.size(); i++) {
            System.out.print(sortedNumbers.get(i));
            if (i < sortedNumbers.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private static void printWitSeparator(List<Integer> list ){
        printWithSep(list);
    }

}
