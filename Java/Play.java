package Java;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Play extends Thread {

    private static boolean loop = false;
    private static boolean stop = false;


    public void startSequence(int delay) {
        Robot robot;
        Delay(delay);
        {
            try {
                robot = new Robot();
                String filePath = Main_Old.fileLocation.getText();
                if (!Load.VerifyFile(filePath)) {
                    Play.setStop(true);
                    return;
                }

                List<MusicalNote> notes = new ArrayList<>();

                if (filePath.contains(".json") && filePath.substring(filePath.length() - ".json".length()).equals(".json")) {
                    try {
                        JSONObject j = new JSONObject(Load.ReadFile(filePath));
                        JSONArray jArray = j.getJSONArray("Notes");
                        for (int i = 0; i < jArray.length(); i++) {
                            JSONObject object = (JSONObject) jArray.get(i);
                            MusicalNote note = new MusicalNote(object.getString("Note"), object.getString("Octave"), object.getInt("Hold"), object.getInt("PostWait"));
                            notes.add(note);
                        }
                    } catch (JSONException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                } else {
                    String string = Load.ReadFile(filePath);
                    while (string.contains("\n")) {
                        int n = string.indexOf("\n");
                        if (string.equals("\n"))
                            break;
                        notes.add(MusicalNote.parse(string.substring(0, n)));
                        string = string.substring(n + 1, string.length() - 1);
                    }
                }


                for (MusicalNote n : notes) {
                    if (n.getOctave().equals("+1"))
                        robot.keyPress(Integer.parseInt(References.config.increaseOctave));

                    if (n.getOctave().equals("-1"))
                        robot.keyPress(Integer.parseInt(References.config.decreaseOctave));

                    switch (n.getNote()) {
                        case "c":
                            keyTyped(robot, Integer.parseInt(References.config.noteC), n.getHold());
                            break;
                        case "cs":
                            keyTyped(robot, Integer.parseInt(References.config.noteCs), n.getHold());
                            break;
                        case "d":
                            keyTyped(robot, Integer.parseInt(References.config.noteD), n.getHold());
                            break;
                        case "eb":
                            keyTyped(robot, Integer.parseInt(References.config.noteEb), n.getHold());
                            break;
                        case "e":
                            keyTyped(robot, Integer.parseInt(References.config.noteE), n.getHold());
                            break;
                        case "f":
                            keyTyped(robot, Integer.parseInt(References.config.noteF), n.getHold());
                            break;
                        case "fs":
                            keyTyped(robot, Integer.parseInt(References.config.noteFs), n.getHold());
                            break;
                        case "g":
                            keyTyped(robot, Integer.parseInt(References.config.noteG), n.getHold());
                            break;
                        case "gs":
                            keyTyped(robot, Integer.parseInt(References.config.noteGs), n.getHold());
                            break;
                        case "a":
                            keyTyped(robot, Integer.parseInt(References.config.noteA), n.getHold());
                            break;
                        case "b":
                            keyTyped(robot, Integer.parseInt(References.config.noteB), n.getHold());
                            break;
                        case "bb":
                            keyTyped(robot, Integer.parseInt(References.config.noteBb), n.getHold());
                            break;
                        case "c1":
                            keyTyped(robot, Integer.parseInt(References.config.noteC1), n.getHold());
                        default:
                            break;
                    }
                    robot.keyRelease(Integer.parseInt(References.config.increaseOctave));
                    robot.keyRelease(Integer.parseInt(References.config.decreaseOctave));
                    if (shouldStop())
                        break;
                    robot.delay(n.getPostWait());
                }
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    private static void keyTyped(Robot bot, int key, int hold) {
        bot.keyPress(key);
        bot.delay(hold);
        bot.keyRelease(key);
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

    public void run() {
        stop = false;
        startSequence(References.DelayTime);
        System.out.println("End");
    }

    public void setLoop(boolean state) {
        loop = state;
    }

    public boolean getLoop() {
        return loop;
    }

    public static void setStop(boolean stop) {
        Play.stop = stop;
    }

    public static boolean shouldStop() {
        return stop;
    }
}
