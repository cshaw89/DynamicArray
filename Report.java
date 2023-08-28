/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//import com.fasterxml.jackson.annotation.JasonProperty;

/**
 * @author DoD_Admin
 */
public class Report {
    //instance variables 

    private String name;
    private String id;
    private Double xCord;
    private Double yCord;

    Report(String name, String id, Double xCord, Double yCord) {
        this.name = name;
        this.id = id;
        this.xCord = xCord;
        this.yCord = yCord;
    }


    public String getName() {
        return name;
    }


    public String getID() {
        return id;
    }


    public Double getXcord() {
        return xCord;
    }


    public Double getYcord() {
        return yCord;
    }


    @Override
    public String toString() {
        return "Name: " + name + " ID: " + id + " XCord: " + xCord + " YCord: " + yCord;

    }
}

