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

        Printer.Examenlijst();
        Printer.Studentenlijst();
        /*GemaaktExamen gemaaktExamen = JSON.getGemaakteExamens(12345678).get(0);
        gemaaktExamen.examenInzien();*/
    }
}