import java.util.ArrayList;
import java.util.Date;

public class GemaaktExamen {
    private String examenNaam;
    private int uniekExamenId;
    private int id;
    private int totaalVragen;
    private int poging;
    private Date date;
    private double cijfer;
    private int studentNummer;
    private boolean geslaagd;
    private ArrayList<Vraag> vragen;



    GemaaktExamen(int uniekExamenId) {
        this.uniekExamenId = uniekExamenId;
        getData();
    }

    private void getData(){
        //geen null geven als studentAntwoord
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
