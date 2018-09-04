package Java;

public class MusicalNote {
    private String note = "";
    private String octave = "0";
    private int time = 1;

    MusicalNote(String note, String octave, int time){
        this.note = note;
        this.octave = octave;
        this.time = time;
    }

    private void setNote(String note) {
        this.note = note;
    }

    private void setOctave(String octave) {
        this.octave = octave;
    }

    private void setTime(int time) {
        this.time = time;
    }

    public String getOctave() {
        return octave;
    }

    public int getTime() {
        return time;
    }

    public String getNote() {
        return note;
    }

    public static MusicalNote parse(String string){
        int noteIn = string.indexOf("Note:");
        int octaveIn = string.indexOf("Octave:");
        int timeIn = string.indexOf("Time:");

        String note = string.substring(noteIn + "Note:".length() + 2, noteIn + "Note:".length() + 3);
        String octave = string.substring(octaveIn + "Octave:".length(), octaveIn + "Octave:".length() + 2);
        int time = Integer.parseInt(string.substring(timeIn + "Time:".length(), timeIn + "Time:".length() + 1)) * 250;

        return new MusicalNote(note, octave, time);
    }
}
