import java.io.*;

public class k05LineNumbers {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        String inputPath = basePath + "\\inputLineNumbers.txt";
        String outPath = basePath + "\\3output.txt";

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputPath)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            int lineCount = 1;

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(String.format("%d. %s", lineCount++, line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
