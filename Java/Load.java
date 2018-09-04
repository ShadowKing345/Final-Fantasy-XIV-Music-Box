package Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Load {

    private static Scanner scanner;

    static List<MusicalNote> ReadFile(String fileLocation){
        List<MusicalNote> data = new ArrayList<>();
        openFile(fileLocation);
        while(scanner.hasNext()){
           data.add(MusicalNote.parse(scanner.nextLine()));
        }
        closeFile();
        return data;
    }

    private static void openFile(String filePath){
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.print( filePath + " not found");
        }
    }

    private static void closeFile(){
        scanner.close();
    }

}
