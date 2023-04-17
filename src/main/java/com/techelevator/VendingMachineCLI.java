// Import necessary classes
package com.techelevator;
import com.techelevator.view.Menu;
import java.math.BigDecimal;

public class VendingMachineCLI {
	// Define constants for menu options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	// Declare class variables
	private Menu menu;
	private VendingMachine vendingMachine;

	// Constructor
	public VendingMachineCLI(Menu menu, VendingMachine vendingMachine) {
		this.menu = menu;
		this.vendingMachine = vendingMachine;
	}

	// Main run method
	public void run() {
		while (true) {
			// Display main menu and get user's choice
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// Display items in vending machine
				vendingMachine.displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// Display purchase menu options and get user's choice
				String[] purchaseMenuOptions = {"Feed Money", "Select Product", "Finish Transaction"};
				String purchaseChoice = (String) menu.getChoiceFromOptions(purchaseMenuOptions);

				if (purchaseChoice.equals("Feed Money")) {
					// Add money to vending machine balance
					boolean finishedAddingMoney = false;
					while (!finishedAddingMoney) {
						System.out.println("Please ENTER THE AMOUNT of money to feed, \u001B[31mOR\u001B[0m ENTER 'done' to finish: ");
						String input = menu.getScanner().nextLine();
						if (input.equals("done")) {
							finishedAddingMoney = true;
						} else {
							try {
								// Attempt to convert user input to int and add to balance
								int amountToAdd = Integer.parseInt(input);
								BigDecimal amountsAdded = new BigDecimal(amountToAdd);
								vendingMachine.addMoney(amountsAdded);
								System.out.println("Current balance: $" + vendingMachine.getBalance());
							} catch (NumberFormatException e) {
								// User input is not a valid int
								System.out.println("INVALID INPUT. Please ENTER A VALID amount of money, \u001B[31mOR\u001B[0m ENTER 'done' to finish: ");
							}
						}
					}
				} else if (purchaseChoice.equals("Select Product")) {
					// Select a product to purchase
					boolean finishedMakingSelections = false;
					while (!finishedMakingSelections) {
						vendingMachine.displayItems();
						System.out.println("Your current balance is: $" + vendingMachine.getBalance() + "\n" + "Please ENTER THE CODE of the product you wish to purchase, \u001B[31mOR\u001B[0m ENTER 'done' to finish: ");
						String input = menu.getScanner().nextLine();
						if (input.equals("done")) {
							finishedMakingSelections = true;
						} else {
							vendingMachine.makePurchase(input);
							System.out.println("Current balance: $" + vendingMachine.getBalance());
						}
					}
				}


			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				// Call the completeTransaction method of the VendingMachine and print its return value
				System.out.println(vendingMachine.completeTransaction());

				// Print a farewell message to the user
				System.out.println("Thank you for using the Vendo-Matic-800 \n" + "Have a good day!");

				// Exit the program with a status of 0 (successful)
				System.exit(0);
			}

		}
	}



	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out); // Create a new Menu object that reads input from the console and writes output to the console
		VendingMachine vendingMachine = new VendingMachine(); // Create a new VendingMachine object
		VendingMachineCLI cli = new VendingMachineCLI(menu, vendingMachine); // Create a new VendingMachineCLI object with the Menu and VendingMachine objects as parameters
		cli.run(); // Run the VendingMachineCLI by calling its run method
	}
}


