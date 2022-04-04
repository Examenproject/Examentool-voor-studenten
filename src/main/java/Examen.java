import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Examen {
    private String naam;
    private int examenId;// dit is de unieke id uit examens.json
    private int totaalVragen;
    private static ArrayList<Vraag> vragen = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public Examen(int examenId) {
        this.examenId = examenId;
        getData();
    }

    private void getData() {
        JSONObject examenObject = JSON.getExamen(examenId);
        this.totaalVragen = JSON.toInt(examenObject.get("totaalVragen"));
        this.naam = examenObject.get("naam").toString();

        JSONArray vragenJsonArray = (JSONArray) examenObject.get("vragen");
        //vraag alle data op en generate een vragen array.
        //pass null naar studentAntwoord

        for (Object vraagJson : vragenJsonArray) {
            JSONObject vraagObject = (JSONObject) vraagJson;

            String vraag = vraagObject.get("vraag").toString();
            String antwoord = vraagObject.get("antwoord").toString();
            int punten = JSON.toInt(vraagObject.get("punten"));

            vragen.add(new Vraag(vraag, antwoord, null, punten));
        }
    }

    public String getNaam() {
        return this.naam;
    }

    public ArrayList<Vraag> getVragen() {
        return vragen;
    }

    public int getTotaalVragen() {
        return totaalVragen;
    }

    public int getExamenId() {
        return examenId;
    }


    public static void maakExamen() {
        System.out.println("Welk examen wil je maken?");
        Printer.Examenlijst();
        int input = scanner.nextInt();


        while (input > JSON.getExamList().size()) {
            System.out.println("Verkeerde input, probeer opnieuw");
            input = scanner.nextInt();
        }
        Examen examen = JSON.getExamenObject(input);
        ArrayList<Vraag> tempVraag = new ArrayList<>();
        for (int i = 0; i < vragen.size(); i++) {
            tempVraag.add(vragen.get(i));
        }
        Collections.shuffle(tempVraag);
        tempVraag.remove(17);
        tempVraag.remove(16);
        tempVraag.remove(15);
        tempVraag.remove(14);
        tempVraag.remove(13);
        tempVraag.remove(12);
        tempVraag.remove(11);
        tempVraag.remove(10);
        for(Vraag vraag : tempVraag){
            System.out.println(vraag.getVraag());
        }
    }


}


