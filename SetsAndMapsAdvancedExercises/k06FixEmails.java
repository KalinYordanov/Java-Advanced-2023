package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class k06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        LinkedHashMap<String, String> personData = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {

            }else {
                personData.put(name, email);
            }
            name = scanner.nextLine();

        }

        personData.entrySet().forEach(entry ->System.out.println(entry.getKey()+ " -> " + entry.getValue()));
      //  personData.entrySet().removeIf(stringStringEntry -> stringStringEntry.getValue().endsWith("us")
        //        || stringStringEntry.getValue().endsWith("uk") || stringStringEntry.getValue().endsWith("com"));
    }
}
