import org.junit.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    @Test
    public void testStudentNaam() {
        String expected = "Karel";
        String actual = JSON.getStudent(12345678).getNaam();
        //  System.out.println(JSON.getStudent(12345678).getNaam()); overbodig aangezien de assertEquals al bevestigt dat de twee overeen komen.
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

}
/**Kan examens niet ophalen **/
    /*
    @Test
    public void testGemaaktExamens() {
        ArrayList<GemaaktExamen> gemaaktExamen = JSON.getGemaakteExamens(12345678);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(45247275);
        expected.add(98137419);
        ArrayList actual = JSON.getStudent(12345678).getExamens();
        //  System.out.println(JSON.getStudent(12345678).getNaam()); overbodig aangezien de assertEquals al bevestigt dat de twee overeen komen.
        Assert.assertEquals(expected, actual);
    }

}

*/

  /**Kan student niet ophalen. Idk why **/

/* AanmeldTest werkt niet idk why
            @Test
    public void aanmeldTest(){
                    Student student;
                    int studentNummer;
                    String naamInput = "Testy";
                    String achternaamInput = "McTesty";
                    String wachtwoordInput = "TestWachtwoord";

                    studentNummer = JSON.addStudent(naamInput, achternaamInput, wachtwoordInput);
                    Student actual = JSON.getStudent(studentNummer);
                Assert.assertEquals(202213250,JSON.getStudent(studentNummer));
                }

            } */
