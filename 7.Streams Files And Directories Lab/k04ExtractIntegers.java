package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class k04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPatch = basePath + "\\input.txt";
        String outputPatch = basePath + "\\output4.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPatch));


        PrintStream writer = new PrintStream(new FileOutputStream(outputPatch));

        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }
            reader.next();
        }
    }
}
