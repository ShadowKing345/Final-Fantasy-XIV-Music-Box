package Java;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties prop = new Properties();
    String noteC = String.valueOf(KeyEvent.VK_Q), noteCs = String.valueOf(KeyEvent.VK_2), noteD = String.valueOf(KeyEvent.VK_W), noteEb = String.valueOf(KeyEvent.VK_3), noteE = String.valueOf(KeyEvent.VK_E), noteF = String.valueOf(KeyEvent.VK_R), noteFs = String.valueOf(KeyEvent.VK_5),
            noteG = String.valueOf(KeyEvent.VK_T), noteGs = String.valueOf(KeyEvent.VK_6), noteA = String.valueOf(KeyEvent.VK_Y),
            noteB = String.valueOf(KeyEvent.VK_7), noteBb = String.valueOf(KeyEvent.VK_U), noteC1 = String.valueOf(KeyEvent.VK_I),
            decreaseOctave = String.valueOf(KeyEvent.VK_CONTROL), increaseOctave = String.valueOf(KeyEvent.VK_SHIFT), tempo = "2500";

    void saveConfig(){
        prop.setProperty("Note_C", noteC);
        prop.setProperty("Note_Cs", noteCs);
        prop.setProperty("Note_D", noteD);
        prop.setProperty("Note_Eb", noteEb);
        prop.setProperty("Note_E", noteE);
        prop.setProperty("Note_F", noteF);
        prop.setProperty("Note_Fs", noteFs);
        prop.setProperty("Note_G", noteG);
        prop.setProperty("Note_Gs", noteGs);
        prop.setProperty("Note_A", noteA);
        prop.setProperty("Note_Bb", noteB);
        prop.setProperty("Note_B", noteBb);
        prop.setProperty("Note_C1", noteC1);
        prop.setProperty("DecreaseOctave", decreaseOctave);
        prop.setProperty("IncreaseOctave", increaseOctave);
        prop.setProperty("Tempo", tempo);

        try {
            prop.store(new FileOutputStream("Config.cfg"), null);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    void load(){
        try {
            prop.load(new FileInputStream("Config.cfg"));
        } catch (FileNotFoundException e){
            System.out.println(e.getLocalizedMessage());
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        noteC = prop.getProperty("Note_C");
        noteCs = prop.getProperty("Note_Cs");
        noteD = prop.getProperty("Note_D");
        noteEb = prop.getProperty("Note_Eb");
        noteE = prop.getProperty("Note_E");
        noteF = prop.getProperty("Note_F");
        noteFs = prop.getProperty("Note_Fs");
        noteG = prop.getProperty("Note_G");
        noteGs = prop.getProperty("Note_Gs");
        noteA = prop.getProperty("Note_A");
        noteBb = prop.getProperty("Note_Bb");
        noteB = prop.getProperty("Note_B");
        noteC1 = prop.getProperty("Note_C1");
        decreaseOctave = prop.getProperty("DecreaseOctave");
        increaseOctave = prop.getProperty("IncreaseOctave");
        tempo = prop.getProperty("Tempo");
    }
}
