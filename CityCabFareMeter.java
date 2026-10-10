
import java.util.*;

abstract class Cab {
    static final double MIN_FARE = 100.0;

    abstract double getRate();

    double calculateFare(double km, boolean night) {
        double fare = Math.max(MIN_FARE, km * getRate());

        if (night) {
            fare *= 1.20;
        }

        return fare;
    }
}

interface NightService {
}

class Mini extends Cab {
    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    double getRate() {
        return 14.0;
    }
}

class SUV extends Cab implements NightService {
    double getRate() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini();
                    break;
                case "SEDAN":
                    cab = new Sedan();
                    break;
                case "SUV":
                    cab = new SUV();
                    break;
                default:
                    continue;
            }

            boolean night = time.equals("NIGHT");

            if (night && !(cab instanceof NightService)) {
                System.out.println(
                    type + ": night service not available"
                );
                continue;
            }

            double fare = cab.calculateFare(km, night);
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
