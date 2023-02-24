package SetsAndMapsAdvancedLab;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class k02SoftuniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> guest = new TreeSet<>();

        while (!input.equals("PARTY")){
            guest.add(input);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")){
            guest.remove(input);

            input = scanner.nextLine();
        }
        System.out.println(guest.size());
        for (String guests : guest) {
            System.out.println(guests);
        }
    }
}
