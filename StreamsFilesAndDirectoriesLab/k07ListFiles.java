package StreamsFilesAndDirectoriesLab;

import java.io.File;

public class k07ListFiles {
    public static void main(String[] args) {
        String folderPack = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(folderPack);

        File[] nestedFiles = file.listFiles();

        for (File nestedFile : nestedFiles) {
            if (nestedFile.isFile()) {
                System.out.printf("%s: [%d]%n",nestedFile.getName(), nestedFile.length());
            }
        }
    }
}
