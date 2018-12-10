package Java;

import com.sun.istack.internal.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicalNote {
    private String note = "a";
    private String octave = "0";
    private int hold = 0;
    private int postWait = 0;

    MusicalNote(@NotNull String note, @NotNull String octave, @NotNull int hold, @NotNull int postWait) {
        this.note = note;
        this.octave = octave;
        try {
            this.hold = hold;
        } catch (NumberFormatException ignored) {}

        try {
            this.postWait = postWait;
        } catch (NumberFormatException ignored) {}
    }

    private void setNote(@NotNull String note) {
        this.note = note;
    }

    private void setOctave(@NotNull String octave) {
        this.octave = octave;
    }

    private void setHold(@NotNull int hold) {
        this.hold = hold;
    }

    private void setPostWait (@NotNull int postWait){
        this.postWait = postWait;
    }

    public String getOctave() {
        return octave;
    }

    public String getNote() {
        return note;
    }

    public int getHold() {
        return hold;
    }

    public int getPostWait() {
        return postWait;
    }

    public static MusicalNote parse(String string){
        try {
            JSONObject j = new JSONObject(string);
            return new MusicalNote(j.getString("Note"), j.getString("Octave"), j.getInt("Hold"), j.getInt("PostWait"));
        } catch (JSONException e) {
            String note = "a";
            String octave = "00";
            int hold = 1;
            int postWait = 1;

            int noteLength = "Note:".length();
            int octaveLength = "Octave:".length();
            int holdLength = "Time:".length();
            int postWaitLength = "PostWait:".length();

            if (string.contains("Note:")) {
                int noteIn = string.indexOf("Note:");
                note = string.substring(noteIn + noteLength, noteIn + noteLength + 2);
                if (note.contains(" "))
                    note = note.substring(0, note.lastIndexOf(' '));
            }
            if(string.contains("Octave:")) {
                int octaveIn = string.indexOf("Octave:");
                octave = string.substring(octaveIn + octaveLength, octaveIn + octaveLength + 2);
                if (octave.contains(" "))
                    octave = octave.substring(0, octave.lastIndexOf(" "));
            }
            if (string.contains("Hold:")) {
                int holdIn = string.indexOf("Hold:");
                hold = Integer.parseInt(string.substring(holdIn + holdLength, holdIn + holdLength + 1));
            }
            if (string.contains("PostWait:")) {
                int postWaitIn = string.indexOf("PostWait:");
                postWait = Integer.parseInt(string.substring(postWaitIn + postWaitLength, postWaitIn + postWaitLength + 1));
            }

            return new MusicalNote(note, octave, hold, postWait);
        }
    }
}
