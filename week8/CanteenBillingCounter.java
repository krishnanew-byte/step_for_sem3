import java.util.Scanner;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateBill();

    abstract String getType();
}

class StudentCustomer extends Customer {

    StudentCustomer(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount * 0.90;
    }

    String getType() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {

    StaffCustomer(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount * 0.95;
    }

    String getType() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {

    GuestCustomer(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new StudentCustomer(amount);
            } else if (type.equals("STAFF")) {
                customer = new StaffCustomer(amount);
            } else {
                customer = new GuestCustomer(amount);
            }

            double finalAmount = customer.calculateBill();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}