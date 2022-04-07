import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Student student;

    public static void main(String[] args) {
        //login system maken die een User object returned
        //user object assignen naar Student

        //loopen door elke gemaakte examen en dit ook assignen aan de Student met Examen Obejcts.
        //user.getGemaaktExamen();

        //Alle opties laten zien
        //Interface laten zien

        //vragen om input en het proces starten
        //Printer.Inloggen();
        //Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        //Printer.Examenlijst();

        //ExamenAfnemen.stelVraag(ArrayList<String>);

        Student student = null;

        Scanner scanner = new Scanner(System.in);

        //laat het inlog menu zien
        Printer.Inloggen();

        //kan een nummer zijn of "aanmelden"
        String firstInput = scanner.nextLine();

        int studentNummer = 0;

        if ("aanmelden".equalsIgnoreCase(firstInput)) {
            Printer.Registreren();
            String naamInput = scanner.nextLine();
            String achternaamInput = scanner.nextLine();
            String wachtwoordInput = scanner.nextLine();

            studentNummer = JSON.addStudent(naamInput, achternaamInput, wachtwoordInput);
            student = JSON.getStudent(studentNummer);
        } else {
            //input is a number
            studentNummer = Integer.parseInt(firstInput);
            String wachtwoordInput = scanner.nextLine();

            boolean isIngelogd = JSON.studentLogin(studentNummer, wachtwoordInput);

            while (!isIngelogd) {
                System.out.println("Incorrecte validatie. Vul je studentnummer en wachtwoord opnieuw in.");
                studentNummer = scanner.nextInt();
                scanner.nextLine();

                wachtwoordInput = scanner.nextLine();

                isIngelogd = JSON.studentLogin(studentNummer, wachtwoordInput);
            }

            student = JSON.getStudent(studentNummer);
        }

        //print het hoofdmenu uit met alle opties
        int invoer = -1;
        Printer.Hoofdmenu();
        while (invoer != 7) {
            if (invoer != -1) {
                Printer.simpelHoofdMenu();
            }

            invoer = scanner.nextInt();
            if (invoer == 1) {
                //lijst met examens
                Printer.Examenlijst();
            } else if (invoer == 2) {
                //lijst met studenten
                Printer.Studentenlijst();
            } else if (invoer == 3) {
                //examen maken
                ExamenAfnemen examenAfnemen = new ExamenAfnemen(student);
                examenAfnemen.maakExamen();
            } else if (invoer == 4) {
                //examen inzien
                System.out.println("Welk examen wil je inzien?");
                Printer.getGemaakteExamens(JSON.getGemaakteExamens(studentNummer));
                int examenNummer = scanner.nextInt();
                GemaaktExamen gemaaktExamen = new GemaaktExamen(examenNummer);
                gemaaktExamen.examenInzien();
            } else if (invoer == 5) {
                //lijst met beste studenten SCOREBOARD
                Scoreboard scoreboard = new Scoreboard();
                scoreboard.besteStudenten();
            } else if (invoer == 6) {
                System.out.println("Van welke student wilt u het examen inzien? (Vul een studentnummer in)");
                int input = scanner.nextInt();
                scanner.nextLine();
                Student student1 = JSON.getStudent(input);
                student1.gemaaktExamen();
                //welke examens heeft een student gehaald?
            } else if (invoer == 7) {
                //welke student heeft de meeste examens gehaald?
            } else if (invoer == 8) {
                //uitschrijven student
                scanner.nextLine();
                System.out.println("Voer uw wachtwoord in:");
                String wachtwoordInput = scanner.nextLine();
                if (JSON.studentLogin(student.getStudentNummer(), wachtwoordInput)) {
                    JSON.removeStudent(student.getStudentNummer());
                    System.exit(0);
                }

            } else if (invoer == 9) {
                //exit
                System.exit(0);
            }
        }
    }
}
