import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
    public void meesteExamens(){
        ArrayList<Student> studenten = JSON.getStudenten();
        //sort names
        Comparator<Student> comparator = Comparator.comparingInt(s -> s.getNaam().length());
        studenten.sort(comparator);
        Collections.reverse(studenten);

        int length = studenten.get(0).getNaam().length();

        //final Sort
        Comparator<Student> finalComparator = Comparator.comparingInt(Student::getGehaaldeExamens).thenComparingDouble(Student::getGemiddelde);
        studenten.sort(finalComparator);
        Collections.reverse(studenten);

        for(Student student : studenten){
            System.out.printf("%s heeft %d examens gehaald met een gemiddelde van %.1f.\n", student.getNaam(), student.getGehaaldeExamens(), student.getGemiddelde());
        }
    }
    public static void gemaakteExamens(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Van welke student wilt u de gehaalde examens inzien? (Vul een studentnummer in)");
        int input = scanner.nextInt();
        scanner.nextLine();
        Student student1 = JSON.getStudent(input);
        student1.gemaaktExamen();
    }
}