package FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class k11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guest = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command = scanner.nextLine();
        while (!command.equals("Print")) {
            String[] commandParts = command.split(";");
            String addOurRemove = commandParts[0];
            String filterType = commandParts[1];
            String parameter = commandParts[2];
            if (addOurRemove.equals("Add filter")) {
                filters.add(filterType + ";" + parameter);
            } else {
                filters.remove(filterType + ";" + parameter);
            }
            command = scanner.nextLine();
        }
        filters.forEach(filter -> {
            Predicate<String> toApply = getPredicate(filter);
            guest.removeIf(toApply);
        });
        if (!guest.isEmpty()){
            guest.forEach(name -> System.out.print(name + " "));
        }

    }

    private static Predicate<String> getPredicate(String filter) {
        String[] filterParts = filter.split(";");
        String filterType = filterParts[0];
        String parameter = filterParts[1];
        switch (filterType) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "End with":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            case "Contains":
                return s -> s.contains(parameter);

        }
        return null;
    }
}
