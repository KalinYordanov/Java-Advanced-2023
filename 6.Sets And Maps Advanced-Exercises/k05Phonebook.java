package SetsAndMapsAdvancedExercises;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class k05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String , String> phoneBook = new LinkedHashMap<>();


       while (true){
           String input = scanner.nextLine();
           if (input.equals("search")){
               String searchName = scanner.nextLine();
               while (!searchName.equals("stop")){
                    if (!phoneBook.containsKey(searchName)){
                        System.out.println("Contact " + searchName +" does not exist.");
                    }else {
                        System.out.println(searchName + " -> " + phoneBook.get(searchName));
                    }
                   searchName = scanner.nextLine();
               }
               break;

           }else {
                String name = input.split("-")[0];
                String number = input.split("-")[1];
                phoneBook.put(name,number);
           }
       }

    }
}
