/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author DoD_Admin
 */
public class FirstProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ReportMods reportMods = new ReportMods();

        ArrayList<Report> reportList = reportMods.createArrayList();
        HashMap<String, String> resultMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to search for a report?");

        String ReportRequest = scanner.nextLine();


        if (ReportRequest.equalsIgnoreCase("yes")) {
            System.out.println("Please provide field to search by (Name, ID, XCORD, YCORD):   ");
            String searchBy = scanner.nextLine();

            System.out.println("Please provide value to search against:  ");
            String reportSearch = scanner.nextLine();


            Report reportToSearch = reportMods.searchReport(reportList, reportSearch, searchBy);
            if (reportToSearch != null) {
                System.out.println("Here is your requested report:   " + reportToSearch);
            }
            }
        else if (!ReportRequest.equalsIgnoreCase("Yes")) {
                System.out.println("Ending Program");
            }
            //Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to enter a report?  ");

        String ReportResponse = scanner.nextLine();

            if (ReportResponse.equalsIgnoreCase("yes")) {
                System.out.println("Name?  ");

                resultMap.put("name", scanner.nextLine());
                System.out.println("ID?  ");
                resultMap.put("id", scanner.nextLine());

                System.out.println("X cord?  ");
                resultMap.put("xCord", scanner.nextLine());
                System.out.println("Y cord?   ");
                resultMap.put("yCord", scanner.nextLine());
                ; // call Report Mods Add report method
                reportMods.addReport(resultMap, reportList);


            }
            //Report ReportToAdd = reportMods.AddReport();
            else if (!ReportResponse.equalsIgnoreCase("Yes")) {


                System.out.println("Ending Program");

            }

            // Report report = new Report(scanner.findInLine(String Name),scanner.findInLine(int ID),scanner.findInLine(Double XCord),scanner.findInLine(Double YCord));
            //  Report ReportToAdd =  reportMods.AddReport();
        System.out.println("Would you like to Delete a report?  ");


        String ReportDelete = scanner.nextLine();

        if (ReportDelete.equalsIgnoreCase("yes")) {
            System.out.println("please enter an ID to remove:  ");
            resultMap.put("id", scanner.nextLine());
            reportMods.deleteReport(reportList, Integer.parseInt(resultMap.get("id")));

        }

        else if (!ReportDelete.equalsIgnoreCase("Yes")) {


            System.out.println("Ending Program");


            System.out.println("Would you like to view import report data?  ");

            String reportImport = scanner.nextLine();
            if(reportImport.equalsIgnoreCase("Yes")) {
                System.out.println("Please provide field to search by (Name, ID, Xcord, Ycord):  ");
            }
            String searchByThis = scanner.nextLine();
            System.out.println("What value are you looking for?");
            String searchValue = scanner.nextLine();

            String searchJsonFile = reportMods.searchJsonFile(searchByThis,searchValue);
            if (searchValue != null) {
                System.out.println("here is your request ID:" + searchValue);
            }




            scanner.close();

        }
      //  ArrayList<Report> ReporttoDeleteID = reportMods.DeleteReport(Integer.parseInt(ReportDelete));




            // ReportList.add(ReportToAdd);


           // for (Report Reports : reportList) {
           //     System.out.println(Reports);
          //  }


            //System.out.println(ReportList );
            // String ReportAdd = scanner.nextLine();
            // String ReportAdd = reportMods.AddReport( String name, int ID, double Xcord, double Ycord);
            // System.out.println("What is the Report Name");
            // String name = scanner.nextLine();
            // int ID = scanner.nextLine();
            //  Double Xcord = scanner.nextLine();
            // Double Ycord = scanner.nextLine();

            // reportMods.AddReport(ID, name, 0, 0);
            //for (Report Reports : ReportList) {
            // System.out.println("Name: " + Reports.getName());
            // System.out.println("ID: " + Reports.getID());
            // System.out.println("X cord: " + Reports.getXcord());
            // System.out.println("Y cord: " + Reports.getYcord());
            //  }



    }
}

