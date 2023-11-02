package com.techelevator.view;

import com.techelevator.Customer;

public class Purchase {

    private static final String FEED_MONEY = "Feed Money";
    private static final String SELECT_PRODUCT = "Select Product";
    private static final String FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};
    private double moneyIn = 0;


    public void openPurchaseOptions(Customer customer){
        Menu menu = new Menu();
        String choice = (String) menu.getChoiceFromOptions(OPTIONS);

        System.out.println(choice);
    }
    //this is for math logic
}
