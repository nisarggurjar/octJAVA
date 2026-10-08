class BankAccount {
    // 1. Private fields: Cannot be accessed or modified directly outside this class
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor initializes valid state
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Set to 0.0.");
        }
    }

    // 2. Read-Only access: Getter without setter prevents modifying the account number
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    // Setter with validation
    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Invalid name provided.");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    // 3. Controlled mutations via business methods instead of a raw setBalance()
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("Deposited: $%.2f | New Balance: $%.2f%n", amount, this.balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > this.balance) {
            System.out.println("Transaction declined: Insufficient funds.");
        } else {
            this.balance -= amount;
            System.out.printf("Withdrew: $%.2f | Remaining Balance: $%.2f%n", amount, this.balance);
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("AC-98765", "Nisarg Gurjar", 1000.0);

        // account.balance = -5000; // COMPILE ERROR: balance has private access

        // Modifying state through validated business rules
        account.deposit(500);
        account.withdraw(2000); // Trigger validation failure: Insufficient funds
        account.withdraw(300);

        System.out.printf("Final Balance for %s: $%.2f%n", account.getAccountHolder(), account.getBalance());
    }
}