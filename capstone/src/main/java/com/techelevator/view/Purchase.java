package com.techelevator.view;

import com.techelevator.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchase {

    private static final String FEED_MONEY = "Feed Money";
    private static final String SELECT_PRODUCT = "Select Product";
    private static final String FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};
    private double moneyIn = 0;

    private VendingMachine vendingMachine;

    public Purchase (VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void openPurchaseOptions(Customer customer) {
        vendingMachine.loadItems();
        Scanner scanner = new Scanner(System.in);
        //can we access our map from our vendingMachine class?
        try  {
            while (true) {
                //create a variable that lets us display array options.
                //System.out.println(OPTIONS);
                System.out.println("Current Money Provided: $ " + moneyIn);
                Menu menu = new Menu(System.in, System.out);
                String choice = (String) menu.getChoiceFromOptions(OPTIONS);



                if (choice.equals(FEED_MONEY)) {

                    //we can't feed money twice
                    //feed money only works on initial input

                    System.out.println("How much money do you want to enter? ");
                    String moneyInStr = scanner.nextLine();
                    Double moneyDbl = Double.parseDouble(moneyInStr);

                    System.out.println("Current Money Provided: $ " + moneyInStr);
                    vendingMachine.setMoney(moneyDbl);

                    //why do we need to do this
                    System.out.println((String) menu.getChoiceFromOptions(OPTIONS));

                } else if (choice.equals(SELECT_PRODUCT)) {
                    //will need logic to update quantity as items are removed
                    vendingMachine.openVendingOptions(customer);
                    System.out.println("Please choose an option and input the slot ID");
                    String slotChoice = scanner.nextLine();
                    vendingMachine.purchase(slotChoice);

                    //if slotChoice equals getSlotKey, return item type
                    //if user input equals chip, sout "crunch, crunch, yum"
                    //if user input equals candy, sout "munch, munch, yum"
                    //if user input equals drink, sout "glug, glug, yum"
                    //if user input equals gum, sout "chew, chew, yum"

                    // try to access loadItems method to get type value

                    //subtract quantity from inventory
                    //if product doesn't exist
                    //inform customer and return them to purchase menu

                    System.out.println((String) menu.getChoiceFromOptions(OPTIONS));
                } else if (choice.equals(FINISH_TRANSACTION)){
                    break;
                }
                //System.out.println(choice);
            }

        } catch (Exception ex) {
            System.out.println("Oops, something went wrong!");
        }
    }
    //this is for math logic
}
