import org.junit.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
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

}