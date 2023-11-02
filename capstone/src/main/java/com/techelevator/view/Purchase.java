package com.techelevator.view;

import com.techelevator.Customer;

import java.util.Scanner;

public class Purchase {

    private static final String FEED_MONEY = "Feed Money";
    private static final String SELECT_PRODUCT = "Select Product";
    private static final String FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};
    private double moneyIn = 0;

    private VendingMachine vendingMachine = new VendingMachine();

    public void openPurchaseOptions(Customer customer) {
        try {
            while (true) {
                //create a variable that lets us display array options.
                //System.out.println(OPTIONS);

                //possible try catch
                System.out.println("Current Money Provided: $ " + moneyIn);
                Menu menu = new Menu(System.in, System.out);
                String choice = (String) menu.getChoiceFromOptions(OPTIONS);

                Scanner scanner = new Scanner(System.in);
                if (choice.equals(FEED_MONEY)) {

                    System.out.println("How much money do you want to enter? ");
                    String moneyInStr = scanner.nextLine();
                    Double moneyDbl = Double.parseDouble(moneyInStr);

                    System.out.println("Current Money Provided: $ " + moneyInStr);
                    System.out.println((String) menu.getChoiceFromOptions(OPTIONS));

                } else if (choice.equals(SELECT_PRODUCT)) { //this else if can not be reached, why?

                    vendingMachine.openVendingOptions(customer);

                    //subtract quantity from inventory
                    //if product doesn't exist
                    //inform customer and return them to purchase menu

                }

                //System.out.println(choice);
                break;
            }

        } catch (Exception ex) {
            System.out.println("Oops, something went wrong!");
        }
    }
    //this is for math logic
}
