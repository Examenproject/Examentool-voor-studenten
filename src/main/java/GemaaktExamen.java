import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
    private ArrayList<Vraag> vragen = new ArrayList<>();

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

    public void examenInzien(){
        Scanner scanner = new Scanner(System.in);
        int teller = 0;
        ArrayList<GemaaktExamen> examens = JSON.getGemaakteExamens(this.studentNummer);
        for(GemaaktExamen examen : examens){
            if(examen.getId() == id){
                ArrayList<Vraag> vragen = examen.getVragen();
                for(Vraag vraag : vragen){
                    String input = null;
                    System.out.println("=================================");
                    System.out.println("Vraag : " + vraag.getVraag());
                    System.out.println("Antwoord : " + vraag.getAntwoord());
                    System.out.println("Gegeven antwoord : " + vraag.getStudentAntwoord());
                    System.out.println("=================================");
                    while(input == null && teller < vragen.size() -1){
                        System.out.println("Druk op enter om naar de volgende vraag te gaan.");
                        input = scanner.nextLine();
                    }
                    teller++;
                }
            }
        }
    }

    public String getExamenNaam() {
        return examenNaam;
    }

    public int getId() {
        return id;
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
