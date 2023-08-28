

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JsonFileReader {

    //ReportMapper ?
    ArrayList<Report> ReportList = new ArrayList<>();

       public JsonArray readJson() {
           InputStream inputStream = JsonFileReader.class.getResourceAsStream("reportdata.json");

           try (JsonReader jsonReader = Json.createReader(new InputStreamReader(inputStream))) {
              JsonArray jsonArray = jsonReader.readArray();


               System.out.println(" Parsed from file:  " + jsonArray);

               return jsonArray;

           }

       }

       public JsonArray parseReportNames() {
           InputStream inputStream = JsonFileReader.class.getResourceAsStream("reportdata.json");

           try(JsonReader jsonReader = Json.createReader(new InputStreamReader(inputStream))) {
               JsonArray jsonArray = jsonReader.readArray();
           for (JsonObject reportObj : jsonArray.getValuesAs(JsonObject.class)) {
               String jsonReportName = reportObj.getString("name");
               System.out.println("Here is the report name  "  + jsonReportName);
           }
           }
           return null;

       }


       public JsonArray parseID() {

           InputStream inputStream = JsonFileReader.class.getResourceAsStream("reportdata.json");

           try(JsonReader jsonReader = Json.createReader(new InputStreamReader(inputStream))) {
               JsonArray jsonArray = jsonReader.readArray();
           for (JsonObject reportIDs : jsonArray.getValuesAs(JsonObject.class)) {
               int reportIDds = reportIDs.getInt("id");
               System.out.println("ID test" + reportIDds);
           }
           }
           return null;
       }
    public JsonArray parseXandYCords() {

        InputStream inputStream = JsonFileReader.class.getResourceAsStream("reportdata.json");

        try (JsonReader jsonReader = Json.createReader(new InputStreamReader(inputStream))) {
            JsonArray jsonArray = jsonReader.readArray();
            for (JsonObject reportXcords : jsonArray.getValuesAs(JsonObject.class)) {
                double Xcords = reportXcords.getJsonNumber("X Cord").doubleValue();
                System.out.println(Xcords);
            }
            for (JsonObject reportYcords : jsonArray.getValuesAs(JsonObject.class)) {
                double Ycords = reportYcords.getJsonNumber("Y Cord").doubleValue();
                System.out.println(Ycords);
            }

            return null;
        }
    }

    /*   public JsonArray parseJson() {
           //parse JsonArray for strings
           InputStream inputStream = JsonFileReader.class.getResourceAsStream("reportdata.json");
           try (JsonReader jsonReader = Json.createReader(new InputStreamReader(inputStream))) {
               // JsonArray jsonArray = jsonReader.readArray();
               // put input stream json file into an array
               //parse that array by types
               return jsonReader.readArray();
           inputArray = inputStream;
           for ( JsonArray parseJson : inputStream {

           }

       }
           return jsonReader.readArray();
       }*/

}
