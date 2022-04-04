import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Student student;

    public static void main(String[] args) {
        //login system maken die ene User object returned
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

        if("aanmelden".equalsIgnoreCase(firstInput)){
            Printer.Registreren();
            String naamInput = scanner.nextLine();
            String achternaamInput = scanner.nextLine();
            String wachtwoordInput = scanner.nextLine();

            studentNummer = JSON.addStudent(naamInput, achternaamInput, wachtwoordInput);
            student = JSON.getStudent(studentNummer);
        }else{
            //input is a number
            studentNummer = Integer.parseInt(firstInput);
            String wachtwoordInput = scanner.nextLine();

            boolean isIngelogd = JSON.studentLogin(studentNummer, wachtwoordInput);

            while(!isIngelogd){
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
        while(invoer != 7) {
            if(invoer != -1) {
                Printer.simpelHoofdMenu();
            }
            invoer = scanner.nextInt();
            if (invoer == 1) {
                Printer.Examenlijst();
            } else if (invoer == 2) {
                Printer.Studentenlijst();
            } else if (invoer == 3) {
                new ExamenMaken();
            } else if (invoer == 4) {
                System.out.println("Welk examen wil je inzien?");
                Printer.getGemaakteExamens(JSON.getGemaakteExamens(studentNummer));
                int examenNummer = scanner.nextInt();
                GemaaktExamen gemaaktExamen = new GemaaktExamen(examenNummer);
                gemaaktExamen.examenInzien();

            } else if (invoer == 5) {
                //lijst met beste studenten
            } else if (invoer == 6){
                //uitschrijven student
            }
        }
    }
}