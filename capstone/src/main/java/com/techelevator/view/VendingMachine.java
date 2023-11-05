package com.techelevator.view;

import com.techelevator.Customer;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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

    public double getChange(int i){
        return change;
    }
    public void setChange (double change){
        this.change = change;
    }

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

                String[] linePart = lines.split("\\|");

                String slot = linePart[0];
                String name = linePart[1];
                Double price = Double.parseDouble(linePart[2]);
                String type = linePart[3];

                Product product = new Product(slot, name, price, type);

                productList.put(slot, product);

            }
        } catch (Exception ex) {
            System.out.println("Figure this out later");
        }
    }

    public void openVendingOptions(Customer customer) {

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
            balance -= product.getPrice();
            product.logTransaction();
        }
    }

    public int[] getTheCoins(){
        System.out.println("Your change is: " + balance);

        double allTheMoney = balance;
        int[] coinValues = {25, 10, 5};
        int[] count = new int[coinValues.length];
        int cents = (int)(allTheMoney * 100);
        for(int i = 0; i < coinValues.length; i++){
            count[i] = cents/coinValues[i];
            cents %= coinValues[i];
            if(i == 0){
                System.out.println("Quarters: " + count[i]);
            } else if(i == 1){
                System.out.println("Dimes: " + count[i]);
            } else if(i == 2){
                System.out.println("Nickels: " + count[i]);
            }
        }
        balance = 0;
        System.out.println("New, updated balance = " + balance);
        return count;
    }

    public void logTransaction(){
    }

    public void setBalance(double v) {
        //Had to create this method in order to .setBalance(1.00) in the test case.
    }
}
