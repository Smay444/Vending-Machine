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
    private Product product;

    public Purchase (VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void openPurchaseOptions(Customer customer) {
        Scanner scanner = new Scanner(System.in);

        try  {
            while (true) {

                Menu menu = new Menu(System.in, System.out);
                String choice = (String) menu.getChoiceFromOptions(OPTIONS);

                if (choice.equals(FEED_MONEY)) {

                    System.out.println("How much money do you want to enter? ");
                    String moneyInStr = scanner.nextLine();
                    Double moneyDbl = Double.parseDouble(moneyInStr);
                    if(moneyDbl < 0) {
                        System.out.println("You cannot remove money from the machine, " +
                                "if you would like your change back, please select Finish Transaction");
                        System.out.println("Please reenter a positive amount if you'd like to make a purchase");
                    } else if(moneyDbl > 0){
                        vendingMachine.setMoney(moneyDbl + vendingMachine.getMoney());
                        System.out.println("Current Money Provided: $ " + (vendingMachine.getMoney()));
                    }

                } else if (choice.equals(SELECT_PRODUCT)) {
                    //will need logic to update quantity as items are removed
                    vendingMachine.openVendingOptions(customer);
                    System.out.println("Please choose an option and input the slot ID");
                    String slotChoice = scanner.nextLine().toUpperCase();
                    vendingMachine.purchase(slotChoice);

                    System.out.println("Current Money Provided: $ " + (vendingMachine.getMoney()));

                } else if (choice.equals(FINISH_TRANSACTION)){

                    vendingMachine.getTheCoins();
                    System.out.println("Thank you, come again!");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Oops, something went wrong!");
        }
    }
}
