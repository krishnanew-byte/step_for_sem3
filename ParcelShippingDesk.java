
import java.util.*;

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double getCharge();

    double getInsurance() {
        return 0.0;
    }

    double getTotal() {
        return getCharge() + getInsurance();
    }
}

interface Insurable {
    double INSURANCE_RATE = 0.02;
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) {
        super(w, v);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    @Override
    double getInsurance() {
        return value * INSURANCE_RATE;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) {
        super(w, v);
    }

    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    @Override
    double getInsurance() {
        return value * INSURANCE_RATE;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel p;

            switch (type) {
                case "STANDARD":
                    p = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    p = new Express(weight, value);
                    break;
                case "FRAGILE":
                    p = new Fragile(weight, value);
                    break;
                default:
                    continue;
            }

            double charge = p.getCharge();
            double insurance = p.getInsurance();
            double total = p.getTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
