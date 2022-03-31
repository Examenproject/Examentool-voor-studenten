public class Vraag {
    private String vraag;
    private String antwoord;
    private String studentAntwoord;
    private int punten;
    private int vraagId;

    Vraag(String vraag, int vraagId, String antwoord, int punten){
        this.vraag = vraag;
        this.vraagId = vraagId;
        this.antwoord = antwoord;
        this.punten = punten;
    }
    Vraag(String vraag, String antwoord, String studentAntwoord, int punten){

    }
}
