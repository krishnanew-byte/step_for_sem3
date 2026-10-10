
import java.util.Scanner;

abstract class Travel {
    static final double BOOKING_FEE = 50.0;

    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 2.0;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 2500.0 + distance * 4.0;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel travel;

            switch (mode) {
                case "BUS":
                    travel = new Bus(distance);
                    break;

                case "TRAIN":
                    travel = new Train(distance);
                    break;

                case "FLIGHT":
                    travel = new Flight(distance);
                    break;

                default:
                    throw new IllegalArgumentException(
                        "Invalid travel mode"
                    );
            }

            double total = travel.calculateTotal();

            System.out.printf("%s: %.2f%n", mode, total);
        }

        sc.close();
    }
}
