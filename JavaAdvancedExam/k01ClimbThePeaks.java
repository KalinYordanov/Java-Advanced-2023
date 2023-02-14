package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class k01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> foodQuantitiesInput = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> staminaQuantityInput = Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(foodQuantitiesInput);
        Deque<Integer> foodQuantities = new ArrayDeque<>(foodQuantitiesInput);
        Deque<Integer> staminaQuantities = new ArrayDeque<>(staminaQuantityInput);
        List<Peak> conqueredPeaks = new ArrayList<>();

        Deque<Peak> peaks = new ArrayDeque<>();
        peaks.offer(new Peak("Vihren", 80));
        peaks.offer(new Peak("Kutelo", 90));
        peaks.offer(new Peak("Banski Suhodol", 100));
        peaks.offer(new Peak("Polezhan", 60));
        peaks.offer(new Peak("Kamenitza", 70));

        while (peaks.size() > 0 && foodQuantities.size() > 0 && staminaQuantities.size() > 0) {
            int currentSum = foodQuantities.pop() + staminaQuantities.pop();
            if (peaks.peek().getDifficulty() <= currentSum) {
                conqueredPeaks.add(peaks.pop());
            }
        }
        if (peaks.size() == 0) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (conqueredPeaks.size() > 0) {
            System.out.println("Conquered peaks:");
            for (Peak peak : conqueredPeaks) {
                System.out.println(peak.getName());
            }

        }
    }

    private static class Peak {
        private String name;
        private int difficulty;

        public Peak(String name, int difficulty) {
            this.name = name;
            this.difficulty = difficulty;
        }

        public String getName() {
            return name;
        }

        public int getDifficulty() {
            return difficulty;
        }
    }
}
