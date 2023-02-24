package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class k02WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String basePath = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPatch = basePath + "\\input.txt";
        String outputPatch = basePath + "\\output.txt";

        List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

        OutputStream outputStream = new FileOutputStream(outputPatch);
        try (InputStream inputStream = new FileInputStream(inputPatch)) {
            int readByte = inputStream.read();
            while (readByte >= 0) {
                if (!punctuation.contains((char) readByte)) {
                    outputStream.write(readByte);
                }

                readByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outputStream.close();
    }
}
