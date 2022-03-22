public class Examen {
    private String naam;
    private int id;
    private int totaalVragen;

    Examen(String naam, int id, int totaalVragen) {
        this.naam = naam;
        this.totaalVragen = totaalVragen;
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public int getId() {
        return id;
    }

    public int getTotaalVragen() {
        return totaalVragen;
    }
}
