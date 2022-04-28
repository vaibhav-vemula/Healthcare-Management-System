import java.util.*;

public class Payment {
    Scanner input = new Scanner(System.in);
    public String CreditCardDetails(int fee) {
        System.out.println("\t\tCARD HOLDER Name: ");
        String temp = input.nextLine();
        System.out.println("\t\tCARD NUMBER : ");
        temp = input.nextLine();
        System.out.println("\t\tEXPIRY : ");
        temp = input.nextLine();
        System.out.println("\t\tCVV : ");
        temp = input.nextLine();
        temp = temp + " " + fee;
        System.out.println("Please Enter 1 to confirm Payment---");
        int x = input.nextInt();
        if (x == 1) {
            System.out.println("Your Payment is confirmed");
            return "Payed";
        } else {
            System.out.println("Your Appointment is cancelled");
            return "NotPayed";
        }
    }
}