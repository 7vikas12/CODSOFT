
import java.util.Scanner;

class BankAccount{
    private double balance;
      
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    boolean withdraw(double amount){
        if(balance > 0 && amount <= balance){
           balance-=amount;
           return true;
        }else{
            return false;
        }
    }

    public void deposit(double amount){
        if(amount > 0)
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account){
        this.account = account;
        this.sc = new Scanner(System.in);
        }

    public void start(){
        int choice;
        do{
         System.out.println("-----ATM MENU-----");
         System.out.println("1. Check balance");
         System.out.println("2. Deposite");
         System.out.println("3. Withdraw");
         System.out.println("4. Exit");
         System.out.println("Enter your choice: ");
         choice = sc.nextInt();

         switch(choice){
            case 1: checkBalance();
                     break;
            case 2: deposit();
                      break;
            case 3: withdraw();
                      break;
            case 4:System.out.println("Thank you for using ATM");
                     break;
            default:
                    System.out.println("Invalid choice please select correct choice");

         }
        }while(choice !=4);
    }
     private void checkBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }


    private void deposit() {
        System.out.print("Enter deposit amount: ₹");
        double amount = sc.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    private void withdraw() {
        System.out.print("Enter withdrawal amount: ₹");
        double amount = sc.nextDouble();
        if (amount > 0 && account.withdraw(amount)) {
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Withdrawal failed. Check amount and balance.");
        }
    }


}


public class ATMSystem {
     public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.start(); // Start ATM interface
    }
}
