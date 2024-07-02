package Banking;

//public class Bank {
	

//}
import java.util.Scanner;

class Atm {
    private int pin = 123456; 
    private int p;
    private int attempts = 0;  // Added a counter for attempts

    void acceptInput() {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter the pin:");
        p = scan.nextInt();
    }

    boolean verify() {
        if (pin == p) {
            System.out.println("Collect your cash");
            return true;
        } else {
            System.out.println("Invalid card details, try again.");
            attempts++;
            return false;
        }
    }

    boolean isCardBlocked() {
        return attempts >= 3;  // Check if the card should be blocked
    }
}

class Bank1 {
    void initialization() {
        Atm atm = new Atm();

        while (!atm.isCardBlocked()) {
            atm.acceptInput();
            if (atm.verify()) {
                break;
            }
        }

        if (atm.isCardBlocked()) {
            System.out.println("Card blocked");
        }
    }
}

public class Bank{
    public static void main(String[] args) {
        Bank1 b = new Bank1();
        b.initialization();
    }
}
