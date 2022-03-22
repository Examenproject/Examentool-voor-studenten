
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Vul hier in welke file je wilt lezen:");
        String path = scanner.nextLine();
        JSONArray examens = JSON.readFile(path);
        for (Object examen : examens) {
            JSONObject jsonObject = (JSONObject) examen;
            System.out.println(jsonObject.get("naam"));
        }*/

//        ArrayList<Student> lijstMetStudenten = JSON.getStudenten(1);
//
//        System.out.println("De volgende leerlingen hebben deze toets gemaakt : ");
//
//        for (int i = 0; i < lijstMetStudenten.size(); i++) {
//            System.out.print("Naam : ");
//            System.out.print(lijstMetStudenten.get(i).getNaam());
//            System.out.print(" ");
//            System.out.print(lijstMetStudenten.get(i).getAchterNaam());
//            System.out.print(" | ");
//            System.out.print("Studentnummer: ");
//            System.out.print(lijstMetStudenten.get(i).getStudentNummer() + "\n");
//        }

        ArrayList<Examen> lijstMetExamens = JSON.getExamens(12345678);
        System.out.println("De volgende examens zijn gemaakt door deze leerling: ");
        for (int i = 0; i < lijstMetExamens.size(); i++) {
            System.out.print("Naam : ");
            System.out.print(lijstMetExamens.get(i).getNaam());
            System.out.print(" | ");
            System.out.print("Id: ");
            System.out.print(lijstMetExamens.get(i).getId());
            System.out.print(" | ");
            System.out.print("Totaal aantal vragen: ");
            System.out.print(lijstMetExamens.get(i).getTotaalVragen() + "\n");
        }
    }


}

class JSON {
    public static int toInt(Object input) {
        try {
            return (int) (long) input; // Maakt van een Object uit een .json file een int.
        } catch (Exception e) {
            return 0;
        }
    }

    public static JSONArray readFile(String path) { // Leest complete .json file uit en returned dit als een array.
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/" + path + ".json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray json = (JSONArray) obj;

            return json;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<Student> getStudenten(int examenId) {
        JSONArray studenten = readFile("studenten"); // Roept methode readFile aan die de hele file met studenten teruggeeft als array.
        ArrayList<Student> lijstMetStudenten = new ArrayList<>(); //In deze lijst met studenten worden alle studenten toegevoegd die een bepaald examen hebben gemaakt.

        for (Object student : studenten) { //Gaat alle studenten langs.

            JSONObject jsonObject = (JSONObject) student;
            JSONArray gemaakteExamens = (JSONArray) jsonObject.get("examens");

            for (int i = 0; i < gemaakteExamens.size(); i++) { // Gaat alle examen arrays per student af.
                int examenNummer = toInt(((JSONObject) (gemaakteExamens.get(i))).get("examenID"));
                if (examenNummer == examenId) { //Als het meegegeven examenId gelijk is aan een examenNummer in de array in de student, dan wordt deze student toegevoegd aan de ArrayList "lijstMetStudenten". Op deze manier krijg je in die ArrayList dus een overzicht van alle studenten die een bepaalde meegegeven toets hebben gemaakt.
                    lijstMetStudenten.add(new Student(jsonObject.get("naam").toString(), jsonObject.get("achternaam").toString(), toInt(jsonObject.get("nummer")), toInt(jsonObject.get("gehaaldeExamens"))));
                }
            }
        }
        return lijstMetStudenten;
    }

    public static ArrayList<Examen> getExamens(int studentNummer) {
        JSONArray studenten = readFile("studenten"); // Roept methode readFile aan die de hele file met studenten teruggeeft als array.
        ArrayList<Examen> lijstMetExamens = new ArrayList<>();

        for (Object student : studenten) { // Gaat alle studenten langs.
            JSONObject studentObject = (JSONObject) student;
            int studentId = toInt(studentObject.get("nummer"));

            if (studentId == studentNummer) { //Als een megegeven studentNummer gelijk is aan een in de studenten file gevonden studentNummer dan gaat hij verder de code in.
                JSONArray gemaakteExamens = (JSONArray) studentObject.get("examens");
                JSONArray examens = readFile("examens");

                for (Object examen : examens) { // Gaat alle examens af in de examens file.
                    JSONObject examenObject = (JSONObject) examen;

                    for (int i = 0; i < gemaakteExamens.size(); i++) { // Gaat alle examens af in die net gevonden student waarbij het studentnummer in de file gelijk is aan het meegegeven student nummer.
                        JSONObject studentExamens = (JSONObject) gemaakteExamens.get(i);

                        if (examenObject.get("id") == studentExamens.get("examenID")) {
                            lijstMetExamens.add(new Examen(examenObject.get("naam").toString(), toInt(examenObject.get("id")), toInt(examenObject.get("totaalVragen"))));
                        }
                    }
                }

            }
        }
        return lijstMetExamens;
    }

    public static JSONObject getStudent(int studentNummer) {
        JSONArray studenten = readFile("studenten");
        for (Object student : studenten) { // Gaat alle studenten in de studenten file langs.
            JSONObject jsonObject = (JSONObject) student;
            int studentId = toInt(jsonObject.get("nummer"));
            if (studentId == studentNummer) { // Als je meegegeven studentNummer gelijk is aan een in de file gevonden studentnummer dan geeft hij dat object terug. Dat is tenslotte de student naar wie je zoekt. Je krijgt alle eigenschappen van die student terug.
                return jsonObject;
            }
        }
        return null;
    }

    // Deze methode doet hetzelfde als de methode hierboven, maar dan voor examens en op basis van een examenId.
    public static JSONObject getExamen(int examenId) {
        JSONArray examens = readFile("examens");
        for (Object examen : examens) {
            JSONObject jsonObject = (JSONObject) examen;
            int examenNummer = toInt(jsonObject.get("id"));
            if (examenNummer == examenId) {
                return jsonObject;
            }
        }
        return null;
    }

    // Deze methode doet hetzelfde als de methode hierboven, maar dan voor de gegeven antwoorden op een bepaald examen van een persoon en op basis van het unieke id. Dit id kan maar 1x voorkomen in totaal.
    public static JSONObject getExamenAntwoorden(int uniekId) {
        JSONArray examenAntwoorden = readFile("examenAntwoorden");
        for (Object examenAntwoord : examenAntwoorden) {
            JSONObject jsonObject = (JSONObject) examenAntwoord;
            int id = toInt(jsonObject.get("id"));
            if (id == uniekId) {
                return jsonObject;
            }
        }
        return null;
    }
}
