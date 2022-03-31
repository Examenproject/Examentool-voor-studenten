import java.util.ArrayList;

public class Student {
    private String naam;
    private String achterNaam;
    private int studentNummer;
    private String wachtwoord;
    private int gehaaldeExamens;
    public ArrayList<GemaaktExamen> examens = new ArrayList<>();

    Student(String naam, String achterNaam, int studentNummer, int gehaaldeExamens, ArrayList<GemaaktExamen> examens) {
        this.naam = naam;
        this.achterNaam = achterNaam;
        this.studentNummer = studentNummer;
        this.gehaaldeExamens = gehaaldeExamens;
        this.examens = examens;
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
}
