package SetsAndMapsAdvancedLab;

import java.util.*;

public class k03Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> secondOne = new LinkedHashSet<>();

        String[] inputOne = scanner.nextLine().split(" ");
        for (int i = 0; i < inputOne.length; i++) {
            int current = Integer.parseInt(inputOne[i]);
            deckOne.add(current);
        }
        String[] inputTwo = scanner.nextLine().split(" ");
        for (int i = 0; i < inputTwo.length; i++) {
            int current = Integer.parseInt(inputTwo[i]);
            secondOne.add(current);
        }
       Iterator<Integer> iteratorOne =  deckOne.iterator();
       Iterator<Integer> iteratorSecond =  secondOne.iterator();
        int step = 1;
        for (int round = 0; round < 50; round++) {
            if (deckOne.isEmpty()){

                break;
            }else if (secondOne.isEmpty()){

                break;
            }

            Integer fighterOne = deckOne.iterator().next();
            Integer fighterTwo = secondOne.iterator().next();

            deckOne.remove(fighterOne);
            secondOne.remove(fighterTwo);

            if (fighterOne > fighterTwo) {
                deckOne.add(fighterOne);
                deckOne.add(fighterTwo);
            } else if (fighterTwo > fighterOne) {
                secondOne.add(fighterOne);
                secondOne.add(fighterTwo);
            }
        }

        if (deckOne.isEmpty() || deckOne.size() < secondOne.size()){
            System.out.println("Second player win!");
        }else if (secondOne.isEmpty() || deckOne.size() > secondOne.size()){
            System.out.println("First player win!");

        }else{
            System.out.println("Draw");

        }
    }
}
