package stacksAndQueuesExercises;
import java.util.ArrayDeque;
import java.util.Scanner;

public class k05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> open = new ArrayDeque<>();
        boolean areBalanse = false;


        for (char bracket: input.toCharArray()){

            if (bracket == '(' || bracket == '[' || bracket == '{'){
                open.push(bracket);

            }else if (bracket == ')' || bracket == ']' || bracket == '}'){
                    if (open.isEmpty()){
                        areBalanse = false;
                        break;
                    }
                char lastOpen = open.pop();

                if (lastOpen == '(' && bracket == ')'){
                    areBalanse = true;

                }else if (lastOpen == '[' && bracket == ']'){
                    areBalanse = true;

                }else if (lastOpen == '{' && bracket == '}') {
                    areBalanse = true;

                }else {
                    areBalanse = false;
                    break;
                }
            }
        }
        if (areBalanse){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
            
    }
}

