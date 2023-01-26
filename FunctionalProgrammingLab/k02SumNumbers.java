package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class k02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        List<String> numbers = Arrays.stream(scanner.next().split(", "))
                .collect(Collectors.toList());
        BiFunction<Integer, String, Integer> parseAndAdd = (acc, cur) -> acc + Integer.parseInt(cur);

        for (String number :
                numbers) {
            sum = parseAndAdd.apply(sum, number);
        }
        System.out.println("Count = " + numbers.size());
        System.out.print("Sum = " + sum);
    }
}
