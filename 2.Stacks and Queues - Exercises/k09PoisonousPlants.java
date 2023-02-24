package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class k09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plants = Integer.parseInt(scanner.nextLine());

        int[] pesticide = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> pesticideStack = new ArrayDeque<>();
        ArrayDeque<Integer> alivePlantsStack = new ArrayDeque<>();

        for (int entry : pesticide) {
            pesticideStack.push(entry);
        }
        int daysWithDeath = 0;
        boolean isThereDeathPlant = true;
        while (isThereDeathPlant) {
            while (pesticideStack.size() != 1) {
                int plantOne = pesticideStack.pop();
                int plantTwo = pesticideStack.peek();
                if (plantOne <= plantTwo) {
                    alivePlantsStack.push(plantOne);
                }
            }
            for (Integer entry : alivePlantsStack) {
                pesticideStack.push(alivePlantsStack.pop());
            }
            if (pesticideStack.size() != plants){
                isThereDeathPlant = true;
            }else {
                isThereDeathPlant = false;
            }
            plants = pesticideStack.size();

            if (isThereDeathPlant){
                daysWithDeath++;
            }
        }
        System.out.println(daysWithDeath);
    }
}
