
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExamenAfnemen {
    Scanner scanner = new Scanner(System.in);
    double goed = 0;
    int fout = 0;
    private ArrayList<Vraag> randomVragen;
    boolean geslaagd;
    int uniekExamenID;
    int studentNummer;

    public ExamenAfnemen(Student student) {

        studentNummer = student.getStudentNummer();
    }

    public void maakExamen() {
        System.out.println("Welk examen wil je maken?");
        Printer.Examenlijst();
        int input = scanner.nextInt();

        uniekExamenID = input;

        scanner.nextLine();


        while (input > JSON.getExamList().size()) {
            System.out.println("Verkeerde input, probeer opnieuw");
            input = scanner.nextInt();
            scanner.nextLine();
        }

        Examen examen = JSON.getExamenObject(input);
        ArrayList<Vraag> examenVragen = examen.getVragen();

        randomVragen = new ArrayList<Vraag>();

        Collections.shuffle(examenVragen);

        for (int i = 0; i < 10; i++) {

            randomVragen.add(examenVragen.get(i));
        }

        stelVraag(randomVragen);
    }

    public void stelVraag(ArrayList<Vraag> vragenLijst) {
        String StudentAntwoord;

        for (int i = 0; i < vragenLijst.size(); i++) {
            Printer.Vraag(vragenLijst.get(i).getVraag(), i + 1);
            StudentAntwoord = scanner.nextLine();

            if (StudentAntwoord.equalsIgnoreCase(vragenLijst.get(i).getAntwoord())) {
                goed++;
            } else {
                fout++;
            }
            vragenLijst.get(i).setStudentAntwoord(StudentAntwoord);

        }
        berekenCijfer(vragenLijst);


    }


    public void berekenCijfer(ArrayList<Vraag> vragenlijst) {
        // 9 * S / L +N = Cijfer    <--- formule cijfer berekenen
        Double cijfer = 9.0 * goed / randomVragen.size() + 1.0;
        for (int i = 0; i < vragenlijst.size(); i++) {
            System.out.println(vragenlijst.get(i).getStudentAntwoord());
            System.out.println(vragenlijst.get(i).getAntwoord());
        }
        int gemaaktExamenID = JSON.saveGemaaktExamen(uniekExamenID, studentNummer, vragenlijst, cijfer);
        GemaaktExamen gemaaktExamen = JSON.getExamenAntwoordenObject(gemaaktExamenID);
        Printer.Gehaald(gemaaktExamen.isGeslaagd(), cijfer);

    }


}
