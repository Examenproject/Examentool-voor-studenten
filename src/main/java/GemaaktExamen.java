import java.util.Date;

public class GemaaktExamen {
    private String examenNaam;
    private int id;
    private int totaalVragen;
    private int poging;
    private Date date;
    private double cijfer;
    private int studentNummer;
    private boolean geslaagd;



    GemaaktExamen(String examenNaam, int id, int totaalVragen) {
        this.examenNaam = examenNaam;
        this.totaalVragen = totaalVragen;
        this.id = id;
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
}
