package StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class k06SortLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String basePath = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPatch = basePath + "\\input.txt";
        String outputPatch = basePath + "\\06output.txt";

        Path path = Paths.get(inputPatch);
       List<String> sortedLines = Files.readAllLines(path)
                .stream()
                .sorted()
                .collect(Collectors.toList());

       Path output = Paths.get(outputPatch);
       Files.write(output,sortedLines);
    }
}
