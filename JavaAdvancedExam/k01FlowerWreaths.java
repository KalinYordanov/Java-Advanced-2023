import java.util.*;

public class k01FlowerWreaths {

    private static final int SUM_FOR_WREATH = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        ArrayDeque<Integer> roses = new ArrayDeque<>();

        String input = scanner.nextLine();

        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);

        input = scanner.nextLine();
        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(roses::offer);

        List<Integer> flowersCol = new ArrayList<>();
        int sumWreath = 0;


        while (!lilies.isEmpty() && !roses.isEmpty()) {

            int currentLilies = lilies.poll();
            int currentRose = roses.peek();
            int sumFlower = currentLilies + currentRose;

            if (sumFlower == SUM_FOR_WREATH) {
                sumWreath++;
                roses.pop();

            } else if (sumFlower > SUM_FOR_WREATH) {
                currentLilies -= 2;
                lilies.offer(currentLilies);

            } else {
                flowersCol.add(currentLilies);
                flowersCol.add(currentRose);
                roses.pop();
            }
        }
        int sumStoredFlower = flowersCol
                .stream()
                .mapToInt(Integer::intValue)
                .sum() / SUM_FOR_WREATH;

        int allWreath = sumStoredFlower + sumWreath;

        if (allWreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", allWreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - allWreath);
        }
    }
}
