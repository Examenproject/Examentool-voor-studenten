import org.junit.*;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import Applicatie.*;
import Services.*;
public class TestClass {

    @Test
    public void testBerekenCijfer(){
        double goed;
        double expected;
        Integer[] vragenlijst = new Integer[10];
        for (int i = 0; i <= 3; i++) {
            if (i == 0){
                goed = 7;
                expected = 7.3;
                Double cijfer = 9.0 * goed / vragenlijst.length + 1.0;

                Assert.assertEquals(expected, cijfer,0.0001);
            }
            else if (i == 1){
                goed = 9;
                expected = 9.1;
                Double cijfer = 9.0 * goed / vragenlijst.length + 1.0;
                Assert.assertEquals(expected, cijfer,0.0001);
            }
            else if (i == 2){
                goed = 10;
                expected = 10;
                Double cijfer = 9.0 * goed / vragenlijst.length + 1.0;
                Assert.assertEquals(expected, cijfer,0.0001);
            }
            else if(i == 3){
                goed = 3;
                expected = 3.7;
                Double cijfer = 9.0 * goed / vragenlijst.length + 1.0;
                Assert.assertEquals(expected, cijfer,0.0001);
            }

        }

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