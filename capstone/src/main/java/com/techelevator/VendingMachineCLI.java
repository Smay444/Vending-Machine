package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Purchase;
import com.techelevator.view.VendingMachine;

public class VendingMachineCLI {

	private VendingMachine vendingMachine = new VendingMachine();
	private Purchase purchase = new Purchase();


	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "EXIT";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		Customer customer = new Customer();
		vendingMachine.loadItems();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vendingMachine.openVendingOptions(customer);
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchase.openPurchaseOptions(customer);
				// do purchase
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

//if I want to purchase item at A2, how can I provide product at A2 = the slot
//how could I get the entire product back if I know the slot number
//            ;
