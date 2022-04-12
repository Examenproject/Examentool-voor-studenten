
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExamenAfnemen {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Vraag> randomVragen;
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

        //laat de gebruiker een examen kiezen
        while (input > JSON.getExamList().size()) {
            System.out.println("Verkeerde input, probeer opnieuw");
            input = scanner.nextInt();
            scanner.nextLine();
        }

        Examen examen = JSON.getExamenObject(input);
        ArrayList<Vraag> examenVragen = examen.getVragen();

        //genereer een nieuwe lijst met willekeurige vragen
        randomVragen = new ArrayList<>();

        Collections.shuffle(examenVragen);

        //sla 10 willekeurige vragen op in een nieuwe lijst
        for (int i = 0; i < 10; i++) {
            randomVragen.add(examenVragen.get(i));
        }

        stelVraag(randomVragen);
    }

    public void stelVraag(ArrayList<Vraag> vragenLijst) {
        String StudentAntwoord;
        double goed = 0;

        //stel de vraag
        for (int i = 0; i < vragenLijst.size(); i++) {
            Printer.Vraag(vragenLijst.get(i).getVraag(), i + 1);
            StudentAntwoord = scanner.nextLine();

            //+1 als het gegeven antwoord goed is
            if (StudentAntwoord.equalsIgnoreCase(vragenLijst.get(i).getAntwoord())) {
                goed++;
            }

            //sla het gegeven antwoord en vraag op
            vragenLijst.get(i).setStudentAntwoord(StudentAntwoord);
        }

        berekenCijfer(vragenLijst, goed);
    }


    public void berekenCijfer(ArrayList<Vraag> vragenlijst, double goed) {
        // 9 * S / L +N = Cijfer
        Double cijfer = 9.0 * goed / randomVragen.size() + 1.0;

        //als de nieuwe gemaakt examen op
        int gemaaktExamenID = JSON.saveGemaaktExamen(uniekExamenID, studentNummer, vragenlijst, cijfer);

        GemaaktExamen gemaaktExamen = JSON.getExamenAntwoordenObject(gemaaktExamenID);

        //laat de gebruiker zien of hij geslaagd is en print het cijfer uit
        Printer.Gehaald(gemaaktExamen.isGeslaagd(), cijfer);

        //link all id's terug naar de student in de JSON file
        JSON.updateStudent(studentNummer,gemaaktExamenID, uniekExamenID);
    }


}
