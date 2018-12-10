package Java;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Play extends Thread{

    static void play(int delay, String filePath) {
        Robot bot;
        Delay(delay);
        System.out.println("Begin.");
        try {
            bot = new Robot();
            String data = Load.ReadFile(filePath);

            List<MusicalNote> notes = new ArrayList<>();

            try {
                JSONObject json = new JSONObject(data);
                for (int i = 0; i < json.getJSONArray("Notes").length(); i++) {
                    JSONObject obj = (JSONObject) json.getJSONArray("Notes").get(i);
                    notes.add(MusicalNote.parse(obj.toString()));
                }
            } catch (JSONException ignored) {
               while (data.contains("\n")){
                    notes.add(MusicalNote.parse(data.substring(0, data.indexOf('\n'))));
               }
            }

            PlayNotes(bot, notes);
        }catch(AWTException | FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void PlayNotes(Robot bot, List<MusicalNote> notes) {
        for (MusicalNote n : notes) {
            if (n.getOctave().equals("+1"))
                bot.keyPress(Integer.parseInt(References.config.increaseOctave));

            if (n.getOctave().equals("-1"))
                bot.keyPress(Integer.parseInt(References.config.decreaseOctave));

            switch (n.getNote()) {
                case "c":
                    KeyTyped(bot, Integer.parseInt(References.config.noteC), n.getHold());
                    break;
                case "cs":
                    KeyTyped(bot, Integer.parseInt(References.config.noteCs), n.getHold());
                    break;
                case "d":
                    KeyTyped(bot, Integer.parseInt(References.config.noteD), n.getHold());
                    break;
                case "eb":
                    KeyTyped(bot, Integer.parseInt(References.config.noteEb), n.getHold());
                    break;
                case "e":
                    KeyTyped(bot, Integer.parseInt(References.config.noteE), n.getHold());
                    break;
                case "f":
                    KeyTyped(bot, Integer.parseInt(References.config.noteF), n.getHold());
                    break;
                case "fs":
                    KeyTyped(bot, Integer.parseInt(References.config.noteFs), n.getHold());
                    break;
                case "g":
                    KeyTyped(bot, Integer.parseInt(References.config.noteG), n.getHold());
                    break;
                case "gs":
                    KeyTyped(bot, Integer.parseInt(References.config.noteGs), n.getHold());
                    break;
                case "a":
                    KeyTyped(bot, Integer.parseInt(References.config.noteA), n.getHold());
                    break;
                case "b":
                    KeyTyped(bot, Integer.parseInt(References.config.noteB), n.getHold());
                    break;
                case "bb":
                    KeyTyped(bot, Integer.parseInt(References.config.noteBb), n.getHold());
                    break;
                case "c1":
                    KeyTyped(bot, Integer.parseInt(References.config.noteC1), n.getHold());
                default:
                    break;
            }
            bot.keyRelease(Integer.parseInt(References.config.increaseOctave));
            bot.keyRelease(Integer.parseInt(References.config.decreaseOctave));
        }
    }

    private static void KeyTyped(Robot bot, int key, int hold) {
        bot.keyPress(key);
        bot.delay(hold);
        bot.keyRelease(key);
    }

    private static void Delay(int milliseconds) {
        try {
            System.out.println("You have " + milliseconds + " to open ffIV.");
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
