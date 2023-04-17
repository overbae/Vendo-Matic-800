package com.techelevator;

import java.math.BigDecimal;


public class VendingMachine {

    private Inventory inventory; // inventory of items in the vending machine
    private Money balance; // balance of money inserted into the vending machine
    private SalesLog salesLog; // sales log of items sold from the vending machine

    /**
     * Constructs a new VendingMachine object and initializes its inventory and sales log.
     * Also loads the inventory data from the file into the inventory.
     */
    public VendingMachine() {
        this.inventory = new Inventory();
        this.balance = new Money();
        this.salesLog = new SalesLog();
        inventory.inventoryLoader();
    }

    /**
     * Displays the items available for purchase in the vending machine.
     */
    public void displayItems() {
        inventory.itemDisplay();
    }

    /**
     * Adds money to the balance of the vending machine and logs it in the sales log.
     * @param amount the amount of money to be added to the vending machine
     */
    public void addMoney(BigDecimal amount) {
        balance.addCash(amount);
        salesLog.log(" FEED MONEY:", balance.getBalance().subtract(amount), balance.getBalance());
    }

    /**
     * Purchases an item from the vending machine with the given code.
     * @param code the code of the item to be purchased
     */
    public void makePurchase(String code) {
        try {
            Item item = inventory.getItem(code);
            if (item == null) {
                throw new CodeNotFoundException("\u001B[31mINVALID CODE. PLEASE TRY AGAIN. \n\u001B[0m");

            }
            if (item.getPrice().compareTo(balance.getBalance()) > 0) {
                throw new InsufficientFundsException("\u001B[31mINSUFFICIENT FUNDS! PLEASE ADD MORE MONEY TO MAKE A PURCHASE. \n\u001B[0m");

            }
            if (item.getQuantity() == 0) {
                throw new OutOfStockException("\u001B[31mITEM IS OUT OF STOCK! SORRY!\u001B[0m\n");

            }
            balance.moneySubtracted(item.getPrice());
            item.setQuantity(item.getQuantity() - 1);
            salesLog.log(" " + item.getName() + " " + code + ":", balance.getBalance().add(item.getPrice()), balance.getBalance());
            System.out.println(item.getSound());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (CodeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns the change in the vending machine and resets the balance to zero.
     * @return the change in the vending machine
     */
    public String returnChange() {
        String change = balance.coinReturn();
        balance = new Money();
        return change;
    }

    /**
     * Completes the transaction by returning the change and printing it to the console.
     * @return the change in the vending machine
     */
    public String completeTransaction() {
        String change = returnChange();
        return change;
    }

    /**
     * Gets the current balance in the vending machine.
     * @return the current balance in the vending machine
     */
    public BigDecimal getBalance() {
        return balance.getBalance();
    }

}
