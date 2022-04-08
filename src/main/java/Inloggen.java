import java.util.Scanner;

public class Inloggen {
    static Scanner scanner = new Scanner(System.in);
    public static Student aanmelden() {
        Student student;
        int studentNummer = 0;
        String naamInput = scanner.nextLine();
        String achternaamInput = scanner.nextLine();
        String wachtwoordInput = scanner.nextLine();

        studentNummer = JSON.addStudent(naamInput, achternaamInput, wachtwoordInput);
        student = JSON.getStudent(studentNummer);
        return student;
    }
        //input is a number
    public static Student inloggen(String firstInput){
        int studentNummer = Integer.parseInt(firstInput);
        String wachtwoordInput = scanner.nextLine();

        boolean isIngelogd = JSON.studentLogin(studentNummer, wachtwoordInput);

        while (!isIngelogd) {
            System.out.println("Incorrecte validatie. Vul je studentnummer en wachtwoord opnieuw in.");
            studentNummer = scanner.nextInt();
            scanner.nextLine();

            wachtwoordInput = scanner.nextLine();

            isIngelogd = JSON.studentLogin(studentNummer, wachtwoordInput);
        }

        return JSON.getStudent(studentNummer);
    }
}

