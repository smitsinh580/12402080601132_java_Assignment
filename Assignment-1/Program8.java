import java.util.Scanner;

// Custom Exception
class InsufficientFundsException extends Exception {
    double shortage;

    InsufficientFundsException(double shortage) {
        this.shortage = shortage;
    }

    public String toString() {
        return "Insufficient funds! Short by: " + shortage;
    }
}

// Bank Account Class
class BankAccount {
    String name;
    double balance;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + "  Remaining Balance: " + balance);
        }
    }
}

// Main Class
public class Program8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(name, balance);

        while (true) {
            System.out.print("Enter amount to withdraw (0 to exit): ");
            double amt = sc.nextDouble();

            if (amt == 0) {
                System.out.println("Transaction ended.");
                break;
            }

            try {
                acc.withdraw(amt);
            } catch (InsufficientFundsException e) {
                System.out.println(e.toString());
            }
        }

        sc.close();
    }
}
