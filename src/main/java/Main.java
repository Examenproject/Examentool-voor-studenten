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

            if(JSON.studentLogin(studentNummer, wachtwoordInput)){
                student = JSON.getStudent(studentNummer);
            }
        }

        Printer.Hoofdmenu();

    }
}