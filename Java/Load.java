package Java;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Load{

    private static Scanner scanner;

    static String ReadFile(String filePath) throws FileNotFoundException {
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getLocalizedMessage());
        }

        String data = "";
        while(scanner.hasNext()){
           data += scanner.nextLine() + "\n";
        }
        scanner.close();
        return data;
    }
}
