package com.techelevator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product{

    private String slot;
    private String name;
    private Double price;
    private String type;
    private int quantity = 5;

    public Product(String slot, String name, Double price, String type){
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getSlot(){
        return slot;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public String getType(){
        return type;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void logTransaction(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        String dateAndTimeStamp = formatter.format(new Date());
        String totalTimeStamp = "Receipt: " + dateAndTimeStamp + " Name: "
                + getName() + " Slot: " + getSlot() + " Price: " + getPrice();
        String fileLocation = "C:\\Users\\Student\\workspace\\oct-blue-capstone-1-team-5\\capstone\\target\\Log.txt";
        File file = new File(fileLocation);
        try(PrintWriter writer = new PrintWriter(new FileWriter(file, true))){
            for(int i = 0; i < 1; i++){
                writer.println(totalTimeStamp);
            }

        } catch (Exception e){
            System.out.println("File not found");
        }
    }

}
