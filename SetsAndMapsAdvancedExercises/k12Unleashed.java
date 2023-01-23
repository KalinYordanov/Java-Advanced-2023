package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class k12Unleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> concert = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            if (!input.contains("@") || input.charAt(input.indexOf('@') - 1) != ' ') {
                continue;
            }
            String singer = input.substring(0, input.indexOf("@") - 1);
            int firstIndexOfNumber = 0;
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if (Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' ') {
                    firstIndexOfNumber = i;
                }
            }
            if (firstIndexOfNumber == 0) {
                continue;
            }
            String venue = input.substring(input.indexOf("@") + 1, firstIndexOfNumber - 1);
            String numbers = input.substring(firstIndexOfNumber);
            int price = Integer.parseInt(numbers.split(" ")[0]);
            int capacity = Integer.parseInt(numbers.split(" ")[1]);

            if (!concert.containsKey(venue)) {
                LinkedHashMap<String, Integer> singers = new LinkedHashMap<>();
                singers.put(singer, price * capacity);
                concert.put(venue, singers);
            } else {
                LinkedHashMap<String, Integer> currentSingers = concert.get(venue);
                currentSingers.putIfAbsent(singer, currentSingers.get(singer) + price * capacity);
                concert.put(venue, currentSingers);
            }

            input = scanner.nextLine();
        }
        for (String venue :
                concert.keySet()) {
            System.out.println(venue);
            LinkedHashMap<String, Integer> singers = concert.get(venue);
            singers.entrySet().stream().sorted((sum1, sum2) -> sum2.getValue().compareTo(sum1.getValue()));
        }
    }
}
