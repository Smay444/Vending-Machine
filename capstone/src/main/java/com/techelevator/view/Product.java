package com.techelevator.view;

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



    //write method for dynamic quantity


}
