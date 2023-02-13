package ExamPrep17october22;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PastryShop01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] liquidInfo = scanner.nextLine().split("\\s+");

        Deque<Integer> liquids = new ArrayDeque<>();

        for (String liquid :
                liquidInfo) {
            liquids.offer(Integer.parseInt(liquid));
        }
        String[] ingredientsInfo = scanner.nextLine().split("\\s+");

        Deque<Integer> ingredients = new ArrayDeque<>();

        for (String ingredient : ingredientsInfo) {
            ingredients.push(Integer.parseInt(ingredient));
        }
        int biscuitCount = 0, cakeCount = 0, pastryValue = 0, paiValue = 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            Integer liquid = liquids.poll();
            Integer ingredient = ingredients.pop();
            int possible = liquid + ingredient;

            switch (possible) {
                case 25:
                    biscuitCount++;
                    break;
                case 50:
                    cakeCount++;
                    break;
                case 75:
                    pastryValue++;
                    break;
                case 100:
                    paiValue++;
                    break;
                default:
                    ingredients.push(ingredient + 3);
                    break;
            }
        }
        if (biscuitCount > 0 && cakeCount > 0 && pastryValue > 0 && paiValue > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(liquids.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(ingredients.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.printf("Biscuit: %d%nCake: %d%nPie: %d%nPastry: %d%n", biscuitCount, cakeCount, paiValue, pastryValue);
    }
}
