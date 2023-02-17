import java.util.*;


public class k01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femaleQueue::offer);


        int matchPeople = 0;

        while (!malesStack.isEmpty() && !femaleQueue.isEmpty()) {
            int firstMale = malesStack.peek();
            int firstFemale = femaleQueue.peek();

            if (firstMale <= 0) {
                malesStack.pop();
                continue;
            }

            if (firstFemale <= 0) {
                femaleQueue.poll();
                continue;
            }

            if (firstMale % 25 == 0) {
                malesStack.pop();
                if (!malesStack.isEmpty()) {
                    malesStack.pop();
                }
                continue;
            }

            if (firstFemale % 25 == 0) {
                femaleQueue.poll();
                if (!femaleQueue.isEmpty()) {
                    femaleQueue.poll();
                }
                continue;
            }

            if (firstMale == firstFemale) {
                malesStack.pop();
                femaleQueue.poll();
                matchPeople++;
            } else {
                femaleQueue.poll();
                malesStack.pop();
                malesStack.push(firstMale - 2);

                //      firstMale -= 2;
            }

        }

        System.out.printf("Matches: %d%n", matchPeople);
        if (!malesStack.isEmpty()) {
            System.out.print("Males left: ");
            Iterator i = malesStack.iterator();
            StringBuilder sb = new StringBuilder();
            for (; ; ) {
                sb.append(i.next());
                if (!i.hasNext()) {
                    break;
                }
                sb.append(", ");
            }
            System.out.println(sb);
        } else {
            System.out.printf("Males left: none%n");
        }
        if (!femaleQueue.isEmpty()) {
            System.out.print("Females left: ");
            Iterator i = femaleQueue.iterator();
            StringBuilder sb = new StringBuilder();
            for (; ; ) {
                sb.append(i.next());
                if (!i.hasNext()) {
                    break;
                }
                sb.append(", ");
            }
            System.out.println(sb);
        } else {
            System.out.printf("Females left: none");
        }
    }
}

