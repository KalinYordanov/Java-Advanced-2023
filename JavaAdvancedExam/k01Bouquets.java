import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class k01Bouquets {
    private static final int NEED_FLOWERS = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bouquets = 0;
        int leftFlowers = 0;
        String input = scanner.nextLine();

        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        input = scanner.nextLine();

        Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(daffodils::offer);

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {

            int firstTulip = tulips.peek();
            int firstDaffodil = daffodils.peek();
            int sumOfFlowers = firstTulip + firstDaffodil;

            if (sumOfFlowers == NEED_FLOWERS) {
                bouquets++;
                tulips.pop();
                daffodils.poll();

            } else if (sumOfFlowers > NEED_FLOWERS) {
                tulips.pop();
                tulips.push(firstTulip - 2);
            } else if (sumOfFlowers < NEED_FLOWERS) {
                tulips.pop();
                daffodils.pop();
                leftFlowers += sumOfFlowers;
            }
        }
        while (leftFlowers > NEED_FLOWERS) {
            leftFlowers -= 15;
            bouquets++;

        }
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }

    }
}
