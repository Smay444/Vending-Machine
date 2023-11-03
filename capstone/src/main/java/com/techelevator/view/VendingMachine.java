package com.techelevator.view;

import com.techelevator.Customer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.awt.SystemColor.menu;

public class VendingMachine {

    private int quantity = 5;

    private double balance = 0;
    double change = 0;

    public double getMoney() {
        return balance;
    }

    public void setMoney(double money) {
        this.balance = money;
    }

    public double getChange(){
        return change;
    }
    public void setChange (double change){
        this.change = change;
    }

//    private static final String FEED_MONEY = "Please enter your money now!";
//    private static final String SELECT_PRODUCT = "Which product do ya want?";
//    private static final String FINISH_TRANSACTION = "Thank you, Come Again!";
//    private static final String[] OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};

    //Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
    //        printMap(treeMap);
    private Map<String, Product> productList = new TreeMap<String, Product>();

    public Map<String, Product> getProductList() {
        return productList;
    }

    public void loadItems() {

        String fileName = "C:\\Users\\Student\\workspace\\oct-blue-capstone-1-team-5\\capstone\\vendingmachine.csv";

        File file = new File(fileName);

        try (Scanner fileReader = new Scanner(file)) {

            while (fileReader.hasNextLine()) {
                String lines = fileReader.nextLine();

                //split line var from file

                String[] linePart = lines.split("\\|");

                String slot = linePart[0]; // slot number
                String name = linePart[1];
                Double price = Double.parseDouble(linePart[2]);
                String type = linePart[3];

                //constructor or setter and then add product to map
                Product product = new Product(slot, name, price, type);

                productList.put(slot, product);

            }
        } catch (Exception ex) {
            System.out.println("Figure this out later");
        }
    }

    public void openVendingOptions(Customer customer) {
        //displaying what's available to them

        for (Map.Entry<String, Product> newMap : productList.entrySet()) {

            Product product = newMap.getValue();

            if (product.getQuantity() < 1) {
                System.out.println(product.getSlot() + " | " + product.getName() + " | " +
                        product.getPrice() + " | " + product.getType() + " | " + "Quantity remaining: SOLD OUT");
            } else {
                System.out.println(product.getSlot() + " | " + product.getName() + " | " +
                        product.getPrice() + " | " + product.getType() + " | " + "Quantity remaining: " + product.getQuantity());
            }

        }

        //ALLOW THE USER TO PUT MONEY IN
        //STORE THAT MONEY
        //PICK AN ITEM
        //TOTAL THE COST
        //GIVE CHANGE
        //FINISH TRANSACTION
        //STORE TRANSACTION INFO SOMEWHERE

        //display options???
        //loop to start purchasing items

    }

    public void purchase(String slot) {

        if (!productList.containsKey(slot)) { //if the slot selection does not exist in the map then
            System.out.println("Product not available. Please select a different option.");
        } else {
            Product product = productList.get(slot);
            if (balance < product.getPrice()) {
                System.out.println("Please put more money into the vending machine");

                return;

            } else if (product.getQuantity() < 1) {
                System.out.println("Item is currently sold out");
                return;

            } else if (product.getType().equals("Chip")) {
                System.out.println("Crunch Crunch, Yum!");
                product.setQuantity(product.getQuantity() - 1);
            } else if (product.getType().equals("Candy")) {
                System.out.println("Munch Munch, Yum!");
                product.setQuantity(product.getQuantity() - 1);
            } else if (product.getType().equals("Drink")) {
                System.out.println("Glug Glug, Yum!");
                product.setQuantity(product.getQuantity() - 1);
            } else if (product.getType().equals("Gum")) {
                System.out.println("Chew Chew, Yum!");
                product.setQuantity(product.getQuantity() - 1);
            }

            //what if user doesn't have enough money

            //product.setQuantity(product.getQuantity() - 1);

            balance -= product.getPrice();
            //System.out.println(balance);

        }
//          how to get feed money to acknowledge purchase method


        //print out remaining balance in vending machine
    }
    public double getChange(Double price){

        //if product cost < amt entered
        Product product = productList.get(price);
        VendingMachine vendingMachine = new VendingMachine();

        if (product.getPrice() < vendingMachine.getMoney()){
            change = vendingMachine.getMoney() - product.getPrice();

        }
        System.out.println("Your change is " + change);
        return change;

    }


//    public static double findBalance(double){
//        //moneyDbl - How to get this value to pass through this method?
//
//
//        return 0;
//    }


}

//create a new class that holds these fields, create a new product class for each item and add it to map
// ie A1 has all of the things