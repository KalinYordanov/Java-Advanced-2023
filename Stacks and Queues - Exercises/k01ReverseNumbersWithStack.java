package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class k01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            int currentNumber = Integer.parseInt(input[i]);
            numbers.push(currentNumber);

        }
        for (Integer output :
                numbers) {
            System.out.print(numbers.pop()+ " ");
        }

    }
}
