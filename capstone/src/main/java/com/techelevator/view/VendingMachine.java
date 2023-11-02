package com.techelevator.view;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private final int MAX_INVENTORY = 5;

    private Map<String, Product> productList = new HashMap<>();

    public void loadItems() {

        String fileName = "C:\\Users\\Student\\workspace\\oct-blue-capstone-1-team-5\\capstone\\vendingmachine.csv";

        File file = new File(fileName);

        try (Scanner fileReader = new Scanner(file)) {

            while (fileReader.hasNextLine()) {
                String lines = fileReader.nextLine();

                //split line var from file

                String[] linePart = lines.split("\\|");

                String line = linePart[0]; // slot number
                String name = linePart[1];
                Double price = Double.parseDouble(linePart[2]);
                String type = linePart[3];

                //constructor or setter and then add product to map
                Product product = new Product();

                System.out.println(line);
                System.out.println(name);
                System.out.println(price);
                System.out.println(type);

//                System.out.println(linePart);

            }
        } catch (Exception ex) {
            System.out.println("Figure this out later");
        }
    }
}

//create a new class that holds these fields, create a new product class for each item and add it to map
// ie A1 has all of the things