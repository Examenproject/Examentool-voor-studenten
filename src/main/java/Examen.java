import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Examen {
    private String naam;
    private int examenId;// dit is de unieke id uit examens.json
    private int totaalVragen;
    private ArrayList<Vraag> vragen;

    public Examen(String naam, int examenId){
        this.naam = naam;
        this.examenId = examenId;
        getData();
    }

    private void getData(){
        JSONObject examenObject = JSON.getExamen(examenId);
        this.totaalVragen = JSON.toInt(examenObject.get("totaalVragen"));
        vragen = (JSONArray) examenObject.get("vragen");
        //vraag alle data op en generate een vragen array.
        //pass null naar studentAntwoord
    }
}
