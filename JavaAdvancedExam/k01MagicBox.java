package JavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class k01MagicBox {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQue = new ArrayDeque<>();

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        int valueOfSum = 0;


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBoxQue::offer);


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);


        while (!firstBoxQue.isEmpty() && !secondBoxStack.isEmpty()) {

            int firstItem = firstBoxQue.peek();
            int secondItem = secondBoxStack.pop();

            int sumOfBox = firstItem + secondItem;

            if (sumOfBox % 2 == 0) {
                valueOfSum += sumOfBox;
                firstBoxQue.poll();

            } else {
                firstBoxQue.offer(secondItem);
            }

        }

        String emptyBoxOutput = firstBoxQue.isEmpty() ? "First magic box is empty." : "Second magic box is empty.";

        String itemsValue = valueOfSum >= 90
                ? "Wow, your prey was epic! Value: "
                : "Poor prey... Value: " ;

        System.out.println(emptyBoxOutput);
        System.out.println(itemsValue + valueOfSum);

    }
}
