import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Examen {
    private String naam;
    private int examenId;// dit is de unieke id uit examens.json
    private int totaalVragen;
    private ArrayList<Vraag> vragen = new ArrayList<>();

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
}


