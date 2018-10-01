package Java;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Load{

    private static Scanner scanner;

    static String ReadFile(String filePath){
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.print( filePath + " not found\nUsing example note");
            return "Notes:e Hold:1 Octave:00 PostWait:0";
        }

        String data = "";
        while(scanner.hasNext()){
           data += scanner.nextLine() + "\n";
        }
        scanner.close();
        return data;
    }

    static boolean VerifyFile(String filePath) {
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }
        return true;
    }
}
