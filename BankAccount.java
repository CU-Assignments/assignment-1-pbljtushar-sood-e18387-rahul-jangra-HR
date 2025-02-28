import java.util.Scanner;

class BankAccount {
    // Private variables for account details
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    // Constructor to initialize the account
    public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter and Setter for account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // Getter and Setter for account number
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter and Setter for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient balance! Withdrawal denied.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("\nAccount Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Account creation
        System.out.println("Enter account holder's name:");
        String name = scanner.nextLine();
        
        System.out.println("Enter account number:");
        int accountNumber = scanner.nextInt();
        
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();
        
        // Create the bank account
        BankAccount account = new BankAccount(name, accountNumber, initialBalance);
        
        // Display account details
        account.displayAccountDetails();
        
        boolean exit = false;
        
        // Menu for deposit and withdrawal operations
        while (!exit) {
            System.out.println("\nBanking Operations:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an operation (1-4): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayAccountDetails();
                    break;
                case 4:
                    System.out.println("Exiting the banking system. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
