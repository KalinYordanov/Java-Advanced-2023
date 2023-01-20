package StreamsFilesAndDirectoriesLab;
import java.io.*;
import java.util.Scanner;
public class k03CopyBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String basePath = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPatch = basePath + "\\input.txt";
        String outputPatch = basePath + "\\03output.txt";

        try (InputStream inputStream = new FileInputStream(inputPatch);
             OutputStream outputStream = new FileOutputStream(outputPatch)) {
            int readByte = inputStream.read();
            while (readByte >= 0){
                if (readByte == 10 || readByte == 32){
                outputStream.write(readByte);
                }else {
                    String number = String.valueOf(readByte);
                    for (int i = 0; i < number.length(); i++) {
                        outputStream.write(number.charAt(i));
                    }

                }

                readByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
