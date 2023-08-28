/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.json.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author DoD_Admin
 */
public class ReportMods {


    public ArrayList<Report> createArrayList() {

        ArrayList<Report> ReportList = new ArrayList<>();


        Report report2 = new Report("Report B", "2", 0.1, 2.0);
        Report Report3 = new Report("Report C", "3", 0.4, 5.0);
        Report Report4 = new Report("Report D", "4", 0.3, 2.5);
        Report Report5 = new Report("Report E", "5", 1.1, 2.3);
        Report Report6 = new Report ("Report H", "54", 1.3, 3.3);

        ReportList.add(report2);
        ReportList.add(Report3);
        ReportList.add(Report4);
        ReportList.add(Report5);


        //  Report MyFirstReport = ReportList.get(0);
        //   System.out.println("Name: " + MyFirstReport.getName());
        //  System.out.println("ID: " + MyFirstReport.getID());
        //  System.out.println("X cord: " + MyFirstReport.getXcord());
        //  System.out.println("Y cord: " + MyFirstReport.getYcord());


        return ReportList;
    }

    /**
     *
     * @param reportList
     * @param id
     * @return
     */
    public Report deleteReport(ArrayList<Report> reportList, int id) {
        for (Report report : reportList) {
            if (report.getID().equals(id)) {
                reportList.remove(report);
                return report;

            }
        }
        System.out.println("report deleted!   here are your remaining reports:  " + reportList.toString());
        return null;
    }

    public Report deleteReport(ArrayList<Report> reportList, String name) {
        for (Report report : reportList) {
            if (report.getName().equals(name)) {
                reportList.remove(report);
                return report;

            }
        }
        System.out.println("report deleted!   here are your remaining reports:  " + reportList.toString());
        return null;
    }

    public void addReport(HashMap<String, String> resultMap, ArrayList<Report> reportList) {


        Report report = new Report(
                resultMap.get("name"),
                resultMap.get("id"),
                Double.parseDouble(resultMap.get("xCord")),
                Double.parseDouble(resultMap.get("yCord"))
        );
        reportList.add(report);
        System.out.println(report);
        //System.out.println(reportList);


    }

    public Report searchReport(ArrayList<Report> reportList, String searchValue, String searchBy) {

        Report result = null;

        for (Report searchReport : reportList) {
            switch (searchBy.toUpperCase()) {
                case "ID":
                    if (searchReport.getID().equals(searchValue)) {
                        result = searchReport;
                    }
                    break;
                case "NAME":
                    if (searchReport.getName().equals(searchValue)) {
                        result = searchReport;
                    }
                    break;
                case "XCORD":
                    if (searchReport.getXcord() == Double.parseDouble(searchValue)) {
                        result = searchReport;
                    }
                    break;
                case "YCORD":
                    if (searchReport.getYcord() == Double.parseDouble(searchValue)) {
                        result = searchReport;
                    }
                    break;


            }
            // System.out.println("True");
        }
        return result;
    }


    public String searchJsonFile(String searchByThis, String searchValue) {
       // List<String> foundResults = new ArrayList<>();
        String foundResult = null;


        InputStream inputStream = ReportMods.class.getResourceAsStream("reportdata.json");
        try (JsonReader jsonReader = Json.createReader(new InputStreamReader(inputStream))) {
            JsonArray jsonArray = jsonReader.readArray();

            for (JsonObject searchResult : jsonArray.getValuesAs(JsonObject.class))
//               {
//                   if(searchResult.getString("Name").equals(searchThis)) {
//                   System.out.println("This is a test line");
//               }
//               }
            {

                switch (searchByThis.toUpperCase()) {
                    case "NAME":
                        if (searchResult.getString("name").equalsIgnoreCase(searchValue)) {
                            foundResult = searchResult.getString("name");

                        }
                        break;
                    case "ID":
                        if (searchResult.getInt("id") == Integer.parseInt(searchValue)) {
                            foundResult = String.valueOf(searchResult.getInt("id"));
                        }
                        break;
                    case "XCORD":
                        double xCordVal = Double.parseDouble(searchValue);
                        if (searchResult.getJsonNumber("X Cord").doubleValue() == xCordVal) {
                            foundResult = String.valueOf(searchResult.getJsonNumber("X Cord").doubleValue());
                        }
                        break;
                    case "YCORD":
                        double yCordVal = Double.parseDouble(searchValue);
                        if (searchResult.getJsonNumber("Y Cord").doubleValue() == yCordVal) {
                            foundResult = String.valueOf(searchResult.getJsonNumber("Y Cord").doubleValue());
                        }
                        break;
                    default:
                        break;
                }
                //String jsonReportName = searchResult.getString("name");

            }

        }
//        if (foundResults.size() > 1) {
//            System.out.println("Duplicates found" + foundResults);
//        }
        System.out.println("here is your found report from the Json file:  " + foundResult);

        return foundResult;

    }
   /* Report report = null;
        for (Report item : reportList) {
            if (item.getName().equalsIgnoreCase(name)) {

                report = item;

            }
        }
        if (report == null) {
            System.out.println("No report found");
        }

        return report;
    }*/

/*    public Report searchReport(ArrayList<Report>, String name, searchObj) {
        Report searchObj = null;

    }*/


 /*       Report reportSearch = new Report(
                resultMap.get("name"));
        for (Report searchReport : reportList) {
            if (reportList.contains(resultMap.get("name"));
            System.out.println("True");
    }*/
}


//found a few good examples online that I will be testing before implementing.
//   public Report SearchbyName(ArrayList<Report> ReportList, String name) {
//      Report result = null;
//       for (Report report : ReportList) {
//          if (report.getName().equalsIgnoreCase(name)) {
//               result = report;
//               System.out.println("found result!");
//              for (Report Reports : ReportList) {
//                  System.out.println(Reports);
//              }
//            break;
//          } else {
//               System.out.println("No Report found");

//         }
//       }

//       return result;
//   }
//}
// for (Report Reports : reportList) {
//     System.out.println(Reports);
//  }
   

   
