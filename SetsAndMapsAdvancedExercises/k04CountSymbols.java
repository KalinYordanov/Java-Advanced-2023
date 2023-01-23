package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class k04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            char currentSymbols = text.charAt(i);
            if (!symbols.containsKey(currentSymbols)) {

                symbols.put(currentSymbols, 1);
            } else {
                int currentCound = symbols.get(currentSymbols);
                symbols.put(currentSymbols, ++currentCound);
            }
        }
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
