package Applicatie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import Services.*;

public class Student {
    private String naam;
    private String achterNaam;
    private int studentNummer;
    private int gehaaldeExamens;
    private double gemiddelde;
    public ArrayList<GemaaktExamen> examens = new ArrayList<>();

    public Student(String naam, String achterNaam, int studentNummer, int gehaaldeExamens, ArrayList<GemaaktExamen> examens, double gemiddelde) {
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

    public void gemaaktExamen() {
        ArrayList<GemaaktExamen> gemaaktExamen = JSON.getGemaakteExamens(studentNummer);
        for (GemaaktExamen gemaaktExamen1 : gemaaktExamen) {

            if (gemaaktExamen1.isGeslaagd()) {
                System.out.printf("%s is gehaald met het cijfer : %.1f.\n", gemaaktExamen1.getExamenNaam(), gemaaktExamen1.getCijfer());
            }
        }
    }

    public static void controleerGeslaagdVoorExamen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geef het studentnummer: ");
        int sNummerInput = scanner.nextInt();
        Student student = JSON.getStudent(sNummerInput);
        if(student == null){
            System.out.println("Deze student bestaat niet!");
            return;
        }

        System.out.println("Geef het examennummer: ");
        Printer.Examenlijst();
        int examenNummerInput = scanner.nextInt();

        //loop door alle gemaakte examens van deze student
        for(GemaaktExamen gE: JSON.getGemaakteExamens(student.getStudentNummer())){
            if(gE.getUniekExamenId() == examenNummerInput){
                if(gE.isGeslaagd()){
                    System.out.printf("Student(%s) is geslaagd voor %s(%d)%n", student.getStudentNummer(), gE.getExamenNaam(), gE.getUniekExamenId());
                    return;
                }
            }
        }

        System.out.printf("Student(%s) is niet geslaagd voor dit examen%n", student.getStudentNummer());
    }

    public static void gemaakteExamens() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Van welke student wilt u de gehaalde examens inzien? (Vul een studentnummer in)");
        int input = scanner.nextInt();
        scanner.nextLine();
        Student student1 = JSON.getStudent(input);
        student1.gemaaktExamen();
    }

    public static void uitschrijven(Student student) {
        Scanner scanner = new Scanner(System.in);
        Printer.Uitschrijven();
        String wachtwoordInput = scanner.nextLine();
        if (JSON.studentLogin(student.getStudentNummer(), wachtwoordInput)) {
            JSON.removeStudent(student.getStudentNummer());
            System.exit(0);
        }
    }
}