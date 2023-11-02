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

//    private static final String FEED_MONEY = "Please enter your money now!";
//    private static final String SELECT_PRODUCT = "Which product do ya want?";
//    private static final String FINISH_TRANSACTION = "Thank you, Come Again!";
//    private static final String[] OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};

    //Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
    //        printMap(treeMap);
    private Map<String, Product> productList = new TreeMap<String, Product>();

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

//                System.out.println(line);
//                System.out.println(name);
//                System.out.println(price);
//                System.out.println(type);

//                System.out.println(linePart);

            }
        } catch (Exception ex) {
            System.out.println("Figure this out later");
        }
    }

    public void openVendingOptions(Customer customer) {
        //displaying what's available to them

        for(Map.Entry<String, Product> newMap: productList.entrySet()) {

            Product product = newMap.getValue();

            //map.put("apple", 5);
            //        map.put("banana", 3);
            //        map.put("cherry", 8);map.put("apple", 5);
            //        map.put("banana", 3);
            //        map.put("cherry", 8);v


            System.out.println(product.getSlot() + " | " + product.getName() + " | " + product.getPrice() + " | " + product.getType() + " | " + "Quantity remaining: " + quantity);
//            productList.get("A2");

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


}

//create a new class that holds these fields, create a new product class for each item and add it to map
// ie A1 has all of the things