import java.util.ArrayList;

public class Printer {
    public Printer() {

    }

    public static void Inloggen() {
        System.out.println("=================================\n" +
                "\n" +
                "Inloggen:\n" +
                "\n" +
                "Geef eerst uw studentennummer en daarna het wachtwoord\n" +
                "\n" +
                "- *Het studentennummer is minimaal \uD835\uDFF4 cijfers lang en is uniek*\n" +
                "\n" +
                "Nog geen account? Typ aanmelden om een account toe te voegen\n" +
                "\n" +
                "=================================");
    }

    public static void Registreren() {
        System.out.println("=================================\n" +
                "\n" +
                "Geef uw studentennummer en daarna het wachtwoord wat u wilt gebruiken\n" +
                "\n" +
                "- *Het studentennummer is minimaal \uD835\uDFF4 cijfers lang en is uniek*\n" +
                "\n" +
                "=================================");
    }

    public static void Hoofdmenu() {
        System.out.println("" +
                "███████╗██╗░░██╗░█████╗░███╗░░░███╗███████╗███╗░░██╗████████╗░█████╗░░█████╗░██╗░░░░░\n" +
                "██╔════╝╚██╗██╔╝██╔══██╗████╗░████║██╔════╝████╗░██║╚══██╔══╝██╔══██╗██╔══██╗██║░░░░░\n" +
                "█████╗░░░╚███╔╝░███████║██╔████╔██║█████╗░░██╔██╗██║░░░██║░░░██║░░██║██║░░██║██║░░░░░\n" +
                "██╔══╝░░░██╔██╗░██╔══██║██║╚██╔╝██║██╔══╝░░██║╚████║░░░██║░░░██║░░██║██║░░██║██║░░░░░\n" +
                "███████╗██╔╝╚██╗██║░░██║██║░╚═╝░██║███████╗██║░╚███║░░░██║░░░╚█████╔╝╚█████╔╝███████╗\n" +
                "╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░░╚════╝░░╚════╝░╚══════╝\n" +
                "\n" +
                "=================================\n" +
                "Hallo, maak een keuze:\n" +
                "\n" +
                "1. Lijst met examens\n" +
                "2. Lijst met studenten\n" +
                "3. Examen maken\n" +
                "4. Examen inzien\n" +
                "5. beste studenten\n" +
                "6. Uitschrijven\n" +
                "7. Programma beëindigen\n" +
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

    public static void BesteStudent() {

        System.out.printf("     _______________\n" +
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
                "        `-.....-'\n" +
                "=================================\n" +
                "Naam:      Studentennummer:     Percentage:\n");
    }

    public static void Uitschrijven() {
        System.out.printf("=================================\n" +
                "Weet u zeker dat u wilt uitschrijven?\n" +
                "1.terug naar hoofdmenu\n" +
                "2.uitschrijven\n" +
                "=================================");
    }

    public static void Vraag(String question, String optie1, String optie2, String optie3) {
        System.out.printf("=================================\n" +
                "vraag ?/10\n" +
                "Vraag: %s\n" +
                "a.%s\n" +
                "b.%s\n" +
                "c.%s", question, optie1, optie2, optie3);
    }

    public static void Gehaald(Boolean gehaald, int cijfer) {
        System.out.printf("=================================\n" +
                "examen %s gehaald met een  %d\n" +
                "1. exit", gehaald, cijfer);
    }


}
