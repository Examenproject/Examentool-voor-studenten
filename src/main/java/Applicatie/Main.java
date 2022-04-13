package Applicatie;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import Services.*;
public class Main {

    public static Student student;

    public static void main(String[] args) {
        Student student = null;

        Scanner scanner = new Scanner(System.in);

        //laat het inlog menu zien
        Printer.Inloggen();

        //kan een nummer zijn of "aanmelden"
        String firstInput = scanner.nextLine();

        if ("aanmelden".equalsIgnoreCase(firstInput)) {
            //start het aanmelden proces
            Printer.Registreren();
            student = Inloggen.aanmelden();
        } else {
            student = Inloggen.inloggen(firstInput);
        }

        //print het hoofdmenu uit met alle opties
        int invoer = -1;
        Printer.Hoofdmenu(student);

        while (invoer != 9) {
            if (invoer != -1) {
                Printer.simpelHoofdMenu(student);
            }

            invoer = scanner.nextInt();
            scanner.nextLine();

            if (invoer == 1) {
                //lijst met examens
                Printer.Examenlijst();

                Printer.wachtOpGebruiker();
            } else if (invoer == 2) {
                //lijst met studenten
                Printer.Studentenlijst();

                Printer.wachtOpGebruiker();
            } else if (invoer == 3) {
                //examen afnemen
                ExamenAfnemen examenAfnemen = new ExamenAfnemen(student);
                examenAfnemen.maakExamen();

                Printer.wachtOpGebruiker();
            } else if (invoer == 4) {
                //examen inzien
                System.out.println("Welk examen wil je inzien?");
                Printer.getGemaakteExamens(JSON.getGemaakteExamens(student.getStudentNummer()));

                int examenNummer = scanner.nextInt();
                GemaaktExamen gemaaktExamen = new GemaaktExamen(examenNummer);
                gemaaktExamen.examenInzien();

                Printer.wachtOpGebruiker();
            } else if (invoer == 5) {
                //lijst met beste studenten
                Scoreboard scoreboard = new Scoreboard();
                scoreboard.besteStudenten();

                Printer.wachtOpGebruiker();
            } else if (invoer == 6) {
                //welke examens heeft een student gehaald?
                Student.gemaakteExamens();

                Printer.wachtOpGebruiker();
            }else if (invoer == 7) {
                //Controleer of een student geslaagd is voor een examen
                Student.controleerGeslaagdVoorExamen();
                Printer.wachtOpGebruiker();
            }
            else if (invoer == 8) {
                //uitschrijven student
                Student.uitschrijven(student);

            } else if (invoer == 9) {
                //exit
                System.exit(0);
            }
        }
    }
}

