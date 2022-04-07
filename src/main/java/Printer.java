import java.util.ArrayList;

public class Printer {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void Inloggen() {
        System.out.println("=================================\n" +
                "\n" +
                "Inloggen:\n" +
                "\n" +
                "Geef eerst uw studentennummer en daarna het wachtwoord\n" +
                "\n" +
                "- *Het studentennummer is minimaal \uD835\uDFF4 cijfers lang en is uniek*\n" +
                "\n" +
                "Nog geen account? Type \"aanmelden\" om een account toe te voegen\n" +
                "\n" +
                "=================================");
    }

    public static void Registreren() {
        System.out.println("=================================\n" +
                "\n" +
                "Geef uw naam, achternaam en daarna het wachtwoord wat u wilt gebruiken. Druk op Enter na het invoeren van elke waarde.\n" +
                "\n" +
                "=================================");
    }

    public static void Hoofdmenu() {
        System.out.println("" + ANSI_RED +
                "███████╗██╗░░██╗░█████╗░███╗░░░███╗███████╗███╗░░██╗████████╗░█████╗░░█████╗░██╗░░░░░\n" +
                "██╔════╝╚██╗██╔╝██╔══██╗████╗░████║██╔════╝████╗░██║╚══██╔══╝██╔══██╗██╔══██╗██║░░░░░\n" +
                "█████╗░░░╚███╔╝░███████║██╔████╔██║█████╗░░██╔██╗██║░░░██║░░░██║░░██║██║░░██║██║░░░░░\n" +
                "██╔══╝░░░██╔██╗░██╔══██║██║╚██╔╝██║██╔══╝░░██║╚████║░░░██║░░░██║░░██║██║░░██║██║░░░░░\n" +
                "███████╗██╔╝╚██╗██║░░██║██║░╚═╝░██║███████╗██║░╚███║░░░██║░░░╚█████╔╝╚█████╔╝███████╗\n" +
                "╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░░╚════╝░░╚════╝░╚══════╝\n" +
                "\n" + ANSI_RESET +
                "=================================\n" +
                "Hallo, maak een keuze:\n" +
                "\n" +
                "1. Lijst met examens\n" +
                "2. Lijst met studenten\n" +
                "3. Examen maken\n" +
                "4. Examen inzien\n" +
                "5. Beste studenten\n" +
                "6. Welke examens heeft een student gehaald\n" +
                "7. Welke student heeft de meeste examens gehaald\n"+
                "8. Uitschrijven student\n" +
                "9. Programma beëindigen\n" +
                "\n" +
                "=================================");
    }
    public static void simpelHoofdMenu(){
        System.out.println("=================================\n" +
                "Hallo, maak een keuze:\n" +
                "\n" +
                "1. Lijst met examens\n" +
                "2. Lijst met studenten\n" +
                "3. Examen maken\n" +
                "4. Examen inzien\n" +
                "5. Beste studenten\n" +
                "6. Welke examens heeft een student gehaald\n" +
                "7. Welke student heeft de meeste examens gehaald\n"+
                "8. Uitschrijven student\n" +
                "9. Programma beëindigen\n" +
                "\n" +
                "=================================");
    }

    public static void Examenlijst() {
        System.out.printf("=================================\n"+"Examenlijst: \n"+"\n");
        for (int  i = 0;  i < JSON.getExamList().size();  i++) {
            String examen = JSON.getExamList().get(i).getNaam();
            System.out.printf("%s\n", examen);
        }
    }
    public static void getGemaakteExamens(ArrayList<GemaaktExamen> gemaaktExamens){
        for(GemaaktExamen gemaaktExamen : gemaaktExamens){
            System.out.println("ID: " + gemaaktExamen.getId());
            System.out.println("Naam : " + gemaaktExamen.getExamenNaam());
            System.out.println("============================");
        }
    }

    public static void Studentenlijst() {
        String naam;
        int studentennummer;
        System.out.printf("=================================\n");
        for (int  i = 0;  i < JSON.getStudentList().size();  i++) {
            naam = JSON.getStudentList().get(i).getNaam();
            studentennummer = JSON.getStudentList().get(i).getStudentNummer();
            System.out.printf("Naam:%s\nStudentennummer:%d\n\n",naam ,studentennummer);
        }
    }

    public static void Award(String naam) {
        System.out.printf(ANSI_YELLOW + "     _______________\n" +
                "    |@@@@|     |####|\n" +
                "    |@@@@|     |####|\n" +
                "    |@@@@|     |####|\n" +
                "    \\@@@@|     |####/\n" +
                "     \\@@@|     |###/\n" +
                "      `@@|_____|##'\n" +
                "           (O)\n" +
                "        .-'''''-.\n" +
                "      .'  * * *  `.\n" +
                "     :  *       *  :\n" +
                "    : ~  student  ~ :\n" +
                "    : ~ A W A R D ~ :\n" +
                "     :  *       *  :\n" +
                "      `.  * * *  .'\n" +
                "        `-.....-'\n" + ANSI_RESET +
                "This award belongs to: " + naam + "\n\n");
    }

    public static void StudentScore(int length, int num, String naam, double gemiddelde, int gehaaldeExamens, int totaalGemaakteExamens){
        String format = "%d. %-" + (length + 2) + "s %2d van de %2d examens  gemiddelde %.1f%n";
        System.out.printf(format, num, naam, gehaaldeExamens, totaalGemaakteExamens, gemiddelde);
    }

    public static void Uitschrijven() {
        System.out.printf("=================================\n" +
                "Voer uw wachtwoord in als u zich wilt uitschrijven\n" +
                "=================================");
    }

    public static void Vraag(String question, int index) {
        System.out.printf("=================================\n" +
                "vraag %d/10\n" +
                "Vraag: %s\n",index, question);
    }

    public static void Gehaald(Boolean gehaald, double cijfer) {
        String gehaaldTekst;
        if (gehaald) {
            gehaaldTekst = "wel";
        } else {
            gehaaldTekst = "niet";
        }
        System.out.printf("=================================\n" +
                "examen %s gehaald met een  %.1f\n" + "exit\n", gehaaldTekst, cijfer);
    }
}
