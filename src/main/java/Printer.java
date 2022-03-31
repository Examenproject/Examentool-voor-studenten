import java.util.ArrayList;

public class Printer {
    public Printer(){

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
        System.out.println("=================================\n" +
                "Examenlijst: \n" +
                "\n" +
                "1. Reken examen\n" +
                "2. Topo examen\n" +
                "\n" +
                "=================================");
    }

    public static void Studentenlijst() {
        System.out.println("=================================\n" +
                "  Naam:      Studentennummer:\n");

    }

    public static void BesteStudent() {
        System.out.println("     _______________\n" +
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
                "Naam:      Studentennummer:     Percentage:\n" +
                "Joe        12345678             100%");
    }

    public static void Uitschrijven() {
        System.out.println("=================================\n" +
                "Weet u zeker dat u wilt uitschrijven?\n" +
                "1.terug naar hoofdmenu\n" +
                "2.uitschrijven\n" +
                "=================================");
    }

    public static void Vraag() {
        System.out.println("=================================\n" +
                "vraag ?/10\n" +
                "Vraag: ???\n" +
                "a.???\n" +
                "b.???\n" +
                "c.???");
    }

    public static void Gehaald() {
        System.out.println("=================================\n" +
                "examen (niet) gehaald met een  4/10\n" +
                "1. exit");
    }
}
