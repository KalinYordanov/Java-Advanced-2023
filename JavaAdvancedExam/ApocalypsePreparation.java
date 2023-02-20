import java.util.*;
import java.util.stream.Collectors;

public class dada {
    private static final int PATCH = 30;//MedKit
    private static final int BANDAGE = 40;
    private static final int MEDKIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Integer> textiles = new ArrayDeque<>();

        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textiles::offer);

        ArrayDeque<Integer> medicaments = new ArrayDeque<>();
        input = scanner.nextLine();

        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(medicaments::push);
        Map<String, Integer> collect = new TreeMap<>();
        collect.put("Patch", 0);
        collect.put("Bandage", 0);
        collect.put("MedKit", 0);


        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int firstTextiles = textiles.poll();
            int firstMedicament = medicaments.pop();

            int sum = firstTextiles + firstMedicament;

            if (sum == 30) {
                collect.put("Patch", collect.get("Patch") + 1);
            } else if (sum == 40) {
                collect.put("Bandage", collect.get("Bandage") + 1);
            } else if (sum >= 100) {
                collect.put("MedKit", collect.get("MedKit") + 1);
                if (medicaments.size() > 0) {
                    medicaments.push(medicaments.pop() + sum - 100);
                }
            } else {
                medicaments.push(firstMedicament + 10);
            }
        }

        collect = collect.entrySet().stream().filter(k -> k.getValue() != 0).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        if (textiles.size() == 0 && medicaments.size() == 0) {
            System.out.printf("Textiles and medicaments are both empty.%n");
        } else if (textiles.size() == 0) {
            System.out.printf("Textiles are empty.%n");
        } else {
            System.out.printf("Medicaments are empty.%n");
        }

        collect.entrySet()
                .stream()
                .sorted((k, v) -> k.getValue().compareTo(v.getValue()))
                .sorted((k, v) -> v.getValue().compareTo(k.getValue()))
                .forEach(k -> System.out.println((k.getKey() + " - ") + k.getValue()));


        if (textiles.size() == 0 && medicaments.size() > 0) {

            System.out.printf("Medicaments left: %s%n", String.join(", ", String.join(" ", String.valueOf(medicaments)
                    .replaceAll("\\[|\\]", ""))));
        }

        if (medicaments.size() == 0 && textiles.size() > 0) {
            System.out.printf("Textiles left: %s%n", String.join(", ", String.join(" ", String.valueOf(textiles)
                    .replaceAll("\\[|\\]", ""))));
        }

    }
}
