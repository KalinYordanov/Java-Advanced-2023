package JavaAdvancedExam;

import java.util.*;

public class LootBox01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        int loot = 0;

        String input = scanner.nextLine();

        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstBoxItem = firstBoxQueue.peek();
            int secondBoxItem = secondBoxStack.pop();

            int sum = firstBoxItem + secondBoxItem;
            if (sum % 2 == 0) { // премахва и двата елемента от кутиите и добавя сумата им в loot
                firstBoxQueue.poll();
                loot += sum;
            }else {//премахваме елемента от втория box и го добавяме към първоя box
                firstBoxQueue.offer(secondBoxItem);
            }
        }
      if (firstBoxQueue.isEmpty()){
          System.out.println("First lootbox is empty");
      }else {
          System.out.println("Second lootbox is empty");
      }
      if (loot >= 100){
          System.out.printf("Your loot was epic! Value: %d",loot);
      }else {
          System.out.printf("Your loot was poor... Value: %d",loot);
      }
    }
}
