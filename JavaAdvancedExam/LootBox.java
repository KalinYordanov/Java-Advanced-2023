package ExamPrep17october22;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ;

        //first loot FIFO
        //second loot LIFO

        ArrayDeque<Integer> firstLootBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondLooBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondLooBox::push);

        int firstItemFirstBox = firstLootBox.peek();
        int lastItemSecondBox = secondLooBox.peek();
        int result = 0;
        while (!isEmptyBox(firstLootBox) && !isEmptyBox(secondLooBox)) {


            int numberFBox = firstItemFirstBox;
            int numberSecBox = lastItemSecondBox;
            int sum = numberFBox + numberSecBox;
            if (sum % 2 == 0) {
                result += sum;
                firstLootBox.pop();
            } else {
                firstLootBox.add(lastItemSecondBox);
            }

            secondLooBox.poll();
            if (!isEmptyBox(firstLootBox) && !isEmptyBox(secondLooBox)) {
                firstItemFirstBox = firstLootBox.peek();
                lastItemSecondBox = secondLooBox.peek();
            }

        }


        if (isEmptyBox(firstLootBox)) {
            System.out.println("First lootbox is empty");
        } else if (isEmptyBox(secondLooBox)) {
            System.out.println("Second lootbox is empty");
        }
        if (result >= 100) {
            System.out.printf("Your loot was epic! Value: %d", result);
        } else {
            System.out.printf("Your loot was poor... Value: %d", result);
        }

        //You need to start from the first item in the first box and sum it up with the last item in the second box.
        // If the sum of their values is an even number, add the summed item to your collection of claimed items and remove them both from the boxes.
        // Otherwise, remove the last item from the second box and add it to the last position in the first box.
        // You need to stop summing items when one of the boxes becomes empty.


    }

    private static boolean isEmptyBox(ArrayDeque<Integer> box) {
        if (box.isEmpty()) {
            return true;
        }
        return false;
    }
}
