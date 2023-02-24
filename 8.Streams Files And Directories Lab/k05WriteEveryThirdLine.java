package StreamsFilesAndDirectoriesLab;

import java.io.*;

public class k05WriteEveryThirdLine {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPatch = basePath + "\\input.txt";
        String outputPatch = basePath + "\\output4.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPatch))) {
            PrintStream write = new PrintStream(new FileOutputStream(outputPatch));
            int lineCount = 1;
            String line = reader.readLine();
            while (line != null){
                if (lineCount % 3 == 0){
                    write.println(line);
                }
                line = reader.readLine();
                lineCount++;
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
