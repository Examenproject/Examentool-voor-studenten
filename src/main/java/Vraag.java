public class Vraag {
    private String vraag;
    private String antwoord;
    private String studentAntwoord;
    private int punten;

    Vraag(String vraag, String antwoord, String studentAntwoord, int punten){
        this.vraag = vraag;
        this.studentAntwoord = studentAntwoord;
        this.antwoord = antwoord;
        this.punten = punten;
    }

    public void setStudentAntwoord(String userInput){
        this.studentAntwoord = userInput;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public String getVraag() {
        return vraag;
    }

    public int getPunten() {
        return punten;
    }

    public String getStudentAntwoord() {
        return studentAntwoord;
    }
}
