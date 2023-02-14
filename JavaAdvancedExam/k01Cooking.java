package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class k01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //FIFO
        ArrayDeque<Integer> liquid = new ArrayDeque<>();
        //LIFO
        ArrayDeque<Integer> ingredien = new ArrayDeque<>();
        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;
        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquid::offer);
        input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredien::push);
        Map<String, Integer> cookedFoods = new TreeMap<>();

        while (!liquid.isEmpty() && !ingredien.isEmpty()) {
            int firstLiquid = liquid.poll();
            int firstIngredien = ingredien.peek();
            int sum = firstLiquid + firstIngredien;
            switch (sum) {
                case 25:
                    bread++;
                    ingredien.pop();
                    break;
                case 50:
                    cake++;
                    ingredien.pop();
                    break;
                case 75:
                    pastry++;
                    ingredien.pop();
                    break;
                case 100:
                    fruitPie++;
                    ingredien.pop();
                    break;
                default:
                    int lastIngredient = ingredien.pop();
                    ingredien.push(lastIngredient + 3);
                    break;
            }

        }
        if (!isAllCoke(bread, cake, pastry, fruitPie)) {
            System.out.printf("Ugh, what a pity! You didn't have enough materials to cook everything.%n");
        } else {
            System.out.printf("Wohoo! You succeeded in cooking all the food!%n");
        }
        if (liquid.isEmpty()) {
            System.out.printf("Liquids left: none%n");
        } else {
            String remainingLiquid = liquid.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.printf("Liquids left: %s%n",remainingLiquid);
        }
        if (ingredien.isEmpty()) {
            System.out.printf("Ingredients left: none%n");
        } else {
            String remainingIngre = ingredien.stream()
                            .map(String::valueOf)
                                    .collect(Collectors.joining(", "));
            System.out.printf("Ingredients left: %s%n",remainingIngre);
        }
        System.out.printf("Bread: %d%n" +
                "Cake: %d%n" +
                "Fruit Pie: %d%n" +
                "Pastry: %d%n", bread, cake, fruitPie, pastry);
    }

    public static boolean isAllCoke(int bread, int cake, int pastry, int fruitPie) {
        if (bread != 0 && cake != 0 && pastry != 0 && fruitPie != 0) {
            return true;
        }
        return false;
    }
}
