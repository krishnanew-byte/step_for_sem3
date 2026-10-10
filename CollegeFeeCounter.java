
import java.util.*;

abstract class CollegeStudent {
    static final double TRANSPORT_FEE = 12000.0;
    String name;

    CollegeStudent(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getExtraFee() {
        return 0.0;
    }

    boolean usesBus() {
        return false;
    }

    double calculateFee() {
        return getTuition() + getExtraFee()
             + (usesBus() ? TRANSPORT_FEE : 0.0);
    }
}

class DayScholar extends CollegeStudent {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000.0;
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

class Hosteller extends CollegeStudent {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000.0;
    }

    @Override
    double getExtraFee() {
        return 60000.0;
    }
}

class Scholar extends CollegeStudent {
    Scholar(String name) {
        super(name);
    }

    double getTuition() {
        return 20000.0;
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            CollegeStudent s;

            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    s = new Scholar(name);
                    break;
                default:
                    continue;
            }

            double fee = s.calculateFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
