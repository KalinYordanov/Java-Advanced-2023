package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class k06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeForNames = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> nameSize = name -> name.length() <= sizeForNames;

        Arrays.stream(names).filter(nameSize)
                .forEach(System.out::println);

    }
}
