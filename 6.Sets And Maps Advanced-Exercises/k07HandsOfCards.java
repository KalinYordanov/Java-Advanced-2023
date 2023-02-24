package SetsAndMapsAdvancedExercises;

import java.util.*;

public class k07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       Map<String, Set<String>> playersPoint = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] carsArray = input.split(": ")[1].split(", ");
            Set<String> cards = new HashSet<>(Arrays.asList(carsArray));
            if (!playersPoint.containsKey(name)) {
                playersPoint.put(name, cards);
            } else {
                Set<String> currentCars = playersPoint.get(name);
                currentCars.addAll(cards);
                playersPoint.put(name, currentCars);
            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> player :
                playersPoint.entrySet()) {
            int point = calculatePoints(player.getValue());
            System.out.printf("%s: %d%n",player.getKey(),point);
        }
    }

    private static int calculatePoints(Set<String> value) {

        int sum = 0;
        HashMap<Character, Integer> powers = getLettersPower();
        for (String card : value) {
            if (card.contains("10")){

                sum += 10 * powers.get(card.charAt(2));
                continue;
            }
            char first = card.charAt(0);
            char second = card.charAt(1);

            sum += powers.get(first) * powers.get(second);
        }
        return sum;
    }
    private static HashMap<Character ,Integer> getLettersPower(){
        HashMap<Character,Integer> power = new HashMap<>();
        power.put('1',1);
        power.put('2',2);
        power.put('3',3);
        power.put('4',4);
        power.put('5',5);
        power.put('6',6);
        power.put('7',7);
        power.put('8',8);
        power.put('9',9);
        power.put('J',11);
        power.put('Q',12);
        power.put('K',13);
        power.put('A',14);
        power.put('S',4);
        power.put('H',3);
        power.put('D',2);
        power.put('C',1);
        return power;
    }
}
