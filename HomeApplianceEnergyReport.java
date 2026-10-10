
import java.util.*;

abstract class Appliance {
    static final double RATE = 8.0;
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits() {
        return getPower() * hours / 1000.0;
    }

    double getCost(boolean saver) {
        double units = getUnits();

        if (saver) {
            units *= 0.75;
        }

        return units * RATE;
    }

    double calculateUnits(boolean saver) {
        double units = getUnits();

        if (saver) {
            units *= 0.75;
        }

        return units;
    }
}

interface SaverMode {
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double getPower() {
        return 1500.0;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double getPower() {
        return 500.0;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = sc.hasNext("SAVER");

            if (saver) {
                sc.next();
            }

            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                case "WASHER":
                    a = new Washer(hours);
                    break;
                default:
                    continue;
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(
                    type + ": saver mode not supported"
                );
                continue;
            }

            double units = a.calculateUnits(saver);
            double cost = units * Appliance.RATE;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
