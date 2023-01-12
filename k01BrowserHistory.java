package stacksAndQueuesLab;
import java.util.ArrayDeque;
import java.util.Scanner;

public class k01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        String currentInput = scanner.nextLine();

        while (!currentInput.equals("Home")){

            if (currentInput.equals("back") ){
                if (history.size() == 1 || history.isEmpty()) {
                    System.out.println("no previous URLs");
                    currentInput = scanner.nextLine();

                    continue;
                }

                    history.pop();

            }else {
                history.push(currentInput);

            }
            System.out.println(history.peek());



            currentInput = scanner.nextLine();
        }

    }
}
