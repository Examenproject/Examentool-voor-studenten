
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class LijstMetExamens {
    //zie voorbeeld code beneden.
}
/*public class LijstMetExamens {

    public static void main(String[] args) throws FileNotFoundException {
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/resources/LijstMetExamens.json")){
            Object object = jsonParser.parse(reader);
            JSONArray examens = (JSONArray) object;
            examens.forEach(emp -> parseExamObject((JSONObject) emp));
        } catch (IOException | ParseException e) {
            System.out.println(e);
        }
    }
    public static void parseExamObject(JSONObject examen){
        JSONObject examenObject = (JSONObject) examen.get("examen");
        String naamExamen = (String) examenObject.get("naam");
        System.out.println(naamExamen);
    }
}
Deze code werkt als je een array in je json file hebt. Dus in ons geval bij de lijst met examens staan er meerdere examens die allemaal naam en id hebben. Op deze manier laat hij een voor een de naam zien.
*/
/*public class LijstMetExamens {
    public static void main(String[]args){
        JSONParser parser = new JSONParser();
        try{
            Object object = parser.parse(new FileReader("src/main/resources/LijstMetExamens.json"));
            JSONObject jsonObject = (JSONObject) object;
            String naamExamen = (String) jsonObject.get("naam");
        }catch (Exception e){

        }
    }
}
Deze code werkt als in de json file bijvoorbeeld dit staat:
{
"naam": "test"
"leeftijd" : "15"
}
Alles mag dus maar 1x voorkomen. Als je een array in de file hebt zoals wij met examens zullen hebben, dan moet je de andere code gebruiken.
*/

