package FunctionalProgrammingExercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class k01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

        Consumer<String> printNames = name -> System.out.println(name);

        for (String name : names) {
            printNames.accept(name);
        }

    }
}
