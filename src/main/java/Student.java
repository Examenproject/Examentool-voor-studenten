import java.util.ArrayList;

public class Student {
    private String naam;
    private String achterNaam;
    private int studentNummer;
    private String wachtwoord;
    private int gehaaldeExamens;
    private double gemiddelde;
    public ArrayList<GemaaktExamen> examens = new ArrayList<>();

    Student(String naam, String achterNaam, int studentNummer, int gehaaldeExamens, ArrayList<GemaaktExamen> examens, double gemiddelde) {
        this.naam = naam;
        this.achterNaam = achterNaam;
        this.studentNummer = studentNummer;
        this.gehaaldeExamens = gehaaldeExamens;
        this.examens = examens;
        this.gemiddelde = gemiddelde;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public String getNaam() {
        return naam;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public int getGehaaldeExamens() {
        return gehaaldeExamens;
    }

    public ArrayList<GemaaktExamen> getExamens() {
        return examens;
    }

    public double getGemiddelde() {
        return gemiddelde;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void gemaaktExamen() {
        ArrayList<GemaaktExamen> gemaaktExamen = JSON.getGemaakteExamens(studentNummer);
        for (GemaaktExamen gemaaktExamen1 : gemaaktExamen) {
            
            if (gemaaktExamen1.isGeslaagd()) {
                System.out.printf("%s is gehaald met het cijfer : %.1f.\n",gemaaktExamen1.getExamenNaam(),gemaaktExamen1.getCijfer());
            }
        }
    }
}