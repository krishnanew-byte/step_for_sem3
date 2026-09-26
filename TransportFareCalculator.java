import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class BusTransport extends Transport {

    BusTransport(double distance) {
        super(distance);
    }

    double calculateFare() {

        double fare =
                2 + (0.10 * distance);

        return Math.min(fare, 10);
    }

    String getType() {
        return "BUS";
    }
}

class TrainTransport extends Transport {

    TrainTransport(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    String getType() {
        return "TRAIN";
    }
}

class MetroTransport extends Transport {

    double peakHourFactor;

    MetroTransport(double distance,
                   double peakHourFactor) {

        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {

        return (1.50 + (0.20 * distance))
                * peakHourFactor;
    }

    String getType() {
        return "METRO";
    }
}

public class TransportFareCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double distance = sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {

                transport =
                        new BusTransport(distance);

            } else if (type.equals("TRAIN")) {

                transport =
                        new TrainTransport(distance);

            } else {

                double factor =
                        sc.nextDouble();

                transport =
                        new MetroTransport(
                                distance,
                                factor);
            }

            double fare =
                    transport.calculateFare();

            System.out.printf(
                    "%s: %.2f%n",
                    transport.getType(),
                    fare);

            total += fare;
        }

        System.out.printf(
                "Total: %.2f%n",
                total);

        
    }
}