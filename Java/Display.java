package Java;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Display extends JPanel {

    JButton begin = new JButton("Begin");
    JButton stop = new JButton("Stop");

    Display() {
        this.setLayout(null);
        begin.setBounds(2, 417, 313, 40);
        begin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sequence t = new Sequence();
                t.start();
            }
        });
        this.add(begin);
        stop.setBounds(begin.getX() + begin.getWidth() + 10, begin.getY(), 313, 40);
        this.add(stop);
    }

    public void startSequence(int delay) {
        Robot robot;
        Delay(delay);
        {
            try {
                robot = new Robot();
                //TODO: Set the directory to be user defined.
                //You can change the file location here
                String directory = "src/Sheets/Music.txt";
                List<MusicalNote> notes = new ArrayList<>();

                if(directory.contains(".json") && directory.substring(directory.length() - ".json".length()) == ".json"){
                try {
                    JSONObject j = new JSONObject(Load.ReadFile(directory));
                    JSONArray jArray = j.getJSONArray("");
                    for (int i = 0; i < jArray.length(); i++){
                        JSONObject object = new JSONObject(jArray.get(i));
                        MusicalNote note = new MusicalNote(object.getString("Note"), object.getString("Octave"), object.getInt("Hold"), object.getInt("PostWait"));
                        notes.add(note);
                    }
                } catch (JSONException e){
                    System.out.println(e.getLocalizedMessage());
                }
                }else {
                    String string = (String) Load.ReadFile(directory);
                    while (string.contains("\n")) {
                        int n = string.indexOf("\n");
                        if (string.equals("\n"))
                            break;
                        notes.add(MusicalNote.parse(string.substring(0, n)));
                        string = string.substring(n + 1, string.length()-1);
                    }
                }


                for (MusicalNote n : notes) {
                    if (n.getOctave().equals("1"))
                        robot.keyPress(KeyEvent.VK_SHIFT);

                    if (n.getOctave().equals("-1"))
                        robot.keyPress(KeyEvent.VK_CONTROL);

                    switch (n.getNote()) {
                        case "q":
                            robot.keyPress(KeyEvent.VK_Q);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_Q);
                            break;
                        case "2":
                            robot.keyPress(KeyEvent.VK_2);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_2);
                            break;
                        case "w":
                            robot.keyPress(KeyEvent.VK_W);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_W);
                            break;
                        case "3":
                            robot.keyPress(KeyEvent.VK_3);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_3);
                            break;
                        case "e":
                            robot.keyPress(KeyEvent.VK_E);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_E);
                            break;
                        case "r":
                            robot.keyPress(KeyEvent.VK_R);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_R);
                            break;
                        case "5":
                            robot.keyPress(KeyEvent.VK_5);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_5);
                            break;
                        case "t":
                            robot.keyPress(KeyEvent.VK_T);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_T);
                            break;
                        case "6":
                            robot.keyPress(KeyEvent.VK_6);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_6);
                            break;
                        case "y":
                            robot.keyPress(KeyEvent.VK_Y);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_Y);
                            break;
                        case "7":
                            robot.keyPress(KeyEvent.VK_7);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_7);
                            break;
                        case "u":
                            robot.keyPress(KeyEvent.VK_U);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_U);
                            break;
                        case "i":
                            robot.keyPress(KeyEvent.VK_I);
                            robot.delay(n.getHold());
                            robot.keyRelease(KeyEvent.VK_I);
                        default:
                            break;
                    }
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    //TODO: add a wait for after note has been played
                }
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Delay(int milliseconds) {
        try {
            System.out.println("You have " + milliseconds + " to open ffIV.");
            Thread.sleep(milliseconds);
            System.out.println("Begin.");
        } catch (InterruptedException iex) {
            System.out.println(iex);
        }
    }

    class Sequence extends Thread{
        public void run() {
            do {
                //Adjust to increase or decrease initial delay
                startSequence(1000);
            } while (false);
            System.out.println("End");
            //TODO: Add a loop function
        }
    }
}
