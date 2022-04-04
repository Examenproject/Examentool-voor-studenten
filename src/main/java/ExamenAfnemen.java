import java.util.ArrayList;
import java.util.Scanner;

public class ExamenAfnemen {
    String studentAntwoord;
    public void stelVraag(ArrayList<String> vragenLijst){

        for (int i = 0; i < vragenLijst.size(); i++) {
            Printer.Vraag(vragenLijst.get(i));
        }

        
        //Vraag.setAntwoord();
    }
}
