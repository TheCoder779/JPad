package FileEditing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public Scanner  fileReader;
    public File file;

    public FileReader(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        fileReader = new Scanner(file);
    }
}
