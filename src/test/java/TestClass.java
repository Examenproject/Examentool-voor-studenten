import org.junit.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import Applicatie.*;
import Services.*;
public class TestClass {

    @Test
    public void testStudentNaam() {
        String expected = "Karel";
        String actual = JSON.getStudent(12345678).getNaam();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testStudentNummer() {
        int expected = 12345678;
        int actual = JSON.getStudent(12345678).getStudentNummer();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGemiddelde() {
        double expected = 1.0;
        double actual = JSON.getStudent(12345678).getGemiddelde();
        Assert.assertEquals(expected, actual, 0.0001);
    }


    //test of het cijfer goed berekend wordt
    @Test
    public void testBerekenCijfer(){
        GemaaktExamen gemaaktExamen = JSON.getExamenAntwoordenObject(76345973);
        ArrayList<Vraag> examenvragen = gemaaktExamen.getVragen();
        double punt = 0;
        //compare user antwoord met goed
        for (int i = 0; i < 10; i++) {
            if (examenvragen.get(i).getStudentAntwoord().equalsIgnoreCase(examenvragen.get(i).getAntwoord())){
                punt++;
            }
        }

        Assert.assertEquals(punt/10*9+1, gemaaktExamen.getCijfer(), 0.0001);

    }




    //Controleer of het checken van antwoorden goed gaat. Hierbij testen we een goed antwoord en een fout antwoord.
    @Test
    public void testStelVraag(){
        for(int i = 0; i<2; i++){
            if(i == 0){
                int goed = 0;
                int fout = 0;
                Vraag testVraag = new Vraag("Wat is 1 + 1", "2", null, 1);
                String antwoord = "2";
                System.setIn(new ByteArrayInputStream(antwoord.getBytes()));
                Scanner scanner = new Scanner(System.in);
                String studentAntwoord = scanner.nextLine();
                if (studentAntwoord.equalsIgnoreCase(testVraag.getAntwoord())) {
                    goed++;
                } else {
                    fout++;
                }
                Assert.assertEquals(1, goed);
            }
            else if (i == 1){
                int goed = 0;
                int fout = 0;
                Vraag testVraag = new Vraag("Wat is 1 + 1", "2", null, 1);
                String antwoord = "3";
                System.setIn(new ByteArrayInputStream(antwoord.getBytes()));
                Scanner scanner = new Scanner(System.in);
                String studentAntwoord = scanner.nextLine();
                if (studentAntwoord.equalsIgnoreCase(testVraag.getAntwoord())) {
                    goed++;
                } else {
                    fout++;
                }
                Assert.assertEquals(1, fout);
            }
        }
    }

    //Controleert of het inloggen van een student correct verloopt.
    //Hierbij testen we verschillende combinaties van goede en foute studentnummers en wachtwoorden.
    @Test
    public void testInloggen(){
        for(int i = 0; i<4; i++){
            if(i==0){
                int studentNummer = 1234;
                String wachtwoord = "1234";
                System.setIn(new ByteArrayInputStream(wachtwoord.getBytes()));
                Scanner scanner = new Scanner(System.in);
                boolean isIngelogd = JSON.studentLogin(studentNummer, scanner.nextLine());
                Assert.assertTrue(isIngelogd);
            }
            else if(i==1){
                int studentNummer = 1234;
                String wachtwoord = "fout";
                System.setIn(new ByteArrayInputStream(wachtwoord.getBytes()));
                Scanner scanner = new Scanner(System.in);
                boolean isIngelogd = JSON.studentLogin(studentNummer, scanner.nextLine());
                Assert.assertFalse(isIngelogd);
            }
            else if(i==2){
                int studentNummer = 10;
                String wachtwoord = "1234";
                System.setIn(new ByteArrayInputStream(wachtwoord.getBytes()));
                Scanner scanner = new Scanner(System.in);
                boolean isIngelogd = JSON.studentLogin(studentNummer, scanner.nextLine());
                Assert.assertFalse(isIngelogd);
            }
            else{
                int studentNummer = 10;
                String wachtwoord = "fout";
                System.setIn(new ByteArrayInputStream(wachtwoord.getBytes()));
                Scanner scanner = new Scanner(System.in);
                boolean isIngelogd = JSON.studentLogin(studentNummer, scanner.nextLine());
                Assert.assertFalse(isIngelogd);
            }
        }
    }
    
    @Test
    public void testGeslaagd(){
        GemaaktExamen gemaaktExamen = JSON.getExamenAntwoordenObject(76345973);
        ArrayList<Vraag> examenVragen = gemaaktExamen.getVragen();
        double punten = 0;
        for(int i=0; i< examenVragen.size(); i++){
            if(examenVragen.get(i).getStudentAntwoord().equalsIgnoreCase(examenVragen.get(i).getAntwoord())){
                punten++;
            }
        }
        double cijfer = punten/ examenVragen.size()*9+1;
        boolean geslaagd = false;
        if(cijfer >= 5.5){
            geslaagd=true;
        }
        Assert.assertEquals(geslaagd, gemaaktExamen.isGeslaagd());
    }
}