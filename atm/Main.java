import java.util.Scanner;

// Custom Exception 1
class InvalidAmountException extends RuntimeException {
    InvalidAmountException(String message) {
        super(message);
    }
}

// Custom Exception 2
class InsufficientBalanceException extends RuntimeException {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom Exception 3
class DailyLimitExceededException extends RuntimeException {
    DailyLimitExceededException(String message) {
        super(message);
    }
}

// Account Class
class Account {
    int accountNumber;
    String accountHolder;
    double balance;
    double todayWithdrawal;

    Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.todayWithdrawal = 0;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid Amount.\nAmount should be greater than zero.");
        }

        balance = balance + amount;
        System.out.println("Deposit Successful.");
        System.out.println("Current Balance : ₹" + balance);
    }

    void withdraw(double amount) {

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid Amount.\nAmount should be greater than zero.");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance.");
        }

        if (todayWithdrawal + amount > 25000) {
            throw new DailyLimitExceededException("Daily Withdrawal Limit Exceeded.\nMaximum Daily Limit : ₹25000");
        }

        balance = balance - amount;
        todayWithdrawal = todayWithdrawal + amount;

        System.out.println("Withdrawal Successful.");
        System.out.println("Remaining Balance : ₹" + balance);
    }

    void checkBalance() {
        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance : ₹" + balance);
        System.out.println("Today's Withdrawal : ₹" + todayWithdrawal);
    }
}

// ATM Class
class ATM {

    Account account;

    ATM(Account account) {
        this.account = account;
    }

    void depositMoney(double amount) {
        try {
            account.deposit(amount);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    void withdrawMoney(double amount) {
        try {
            account.withdraw(amount);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (DailyLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    void checkAccount() {
        account.checkBalance();
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account acc = new Account(12345678, "Durga", 50000);

        ATM atm = new ATM(acc);

        int choice;

        do {

            System.out.println("\n=============================");
            System.out.println("        ATM SYSTEM");
            System.out.println("=============================");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount : ");
                    double deposit = sc.nextDouble();
                    atm.depositMoney(deposit);
                    break;

                case 2:
                    System.out.print("Enter Withdrawal Amount : ");
                    double withdraw = sc.
                    nextDouble();
                    atm.withdrawMoney(withdraw);
                    break;

                case 3:
                    atm.checkAccount();
                    break;

                case 4:
                    System.out.println("Thank You for Using Our ATM.");
                    System.out.println("Visit Again!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}