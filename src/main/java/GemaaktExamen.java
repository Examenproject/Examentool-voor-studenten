import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class GemaaktExamen {
    private String examenNaam;
    private int uniekExamenId;// unieke examen id examens.json
    private int id;//gemaakt examen id examenAntwoorde.json
    private int totaalVragen;
    private int poging;
    private String date;
    private double cijfer;
    private int studentNummer;
    private boolean geslaagd;
    private ArrayList<Vraag> vragen;

    GemaaktExamen(int uniekGemaaktExamenId) {
        this.id = uniekGemaaktExamenId;
        getData();
    }

    private void getData(){
        JSONObject examenObject = JSON.getExamenAntwoorden(id);
        this.totaalVragen = JSON.toInt(examenObject.get("totaalVragen"));
        this.uniekExamenId = JSON.toInt(examenObject.get("examenID"));
        this.examenNaam = examenObject.get("naam").toString();
        this.poging = JSON.toInt(examenObject.get("poging"));
        this.date = examenObject.get("date").toString();
        this.cijfer = (double) examenObject.get("cijfer");
        this.studentNummer = JSON.toInt(examenObject.get("studentNummer"));

        if(this.cijfer >= 5.5){
            this.geslaagd = true;
        }else{
            this.geslaagd = false;
        }




        JSONArray vragenJsonArray = (JSONArray) examenObject.get("vragen");

        for(Object vraagJson: vragenJsonArray){
            JSONObject vraagObject = (JSONObject) vraagJson;

            String vraag = vraagObject.get("vraag").toString();
            String antwoord = vraagObject.get("antwoord").toString();
            String studentAntwoord = vraagObject.get("studentAntwoord").toString();
            int punten = JSON.toInt(vraagObject.get("punten"));

            vragen.add(new Vraag(vraag, antwoord, studentAntwoord, punten));
        }
    }

    public String getExamenNaam() {
        return examenNaam;
    }

    public int getId() {
        return id;
    }

    public int getTotaalVragen() {
        return totaalVragen;
    }

    public ArrayList<Vraag> getVragen() {
        return vragen;
    }

    public double getCijfer() {
        return cijfer;
    }

    public int getPoging() {
        return poging;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public int getUniekExamenId() {
        return uniekExamenId;
    }

    public String getDate() {
        return date;
    }

    public boolean isGeslaagd() {
        return geslaagd;
    }
}
