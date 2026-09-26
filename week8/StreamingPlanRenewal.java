import java.util.Scanner;
import java.time.LocalDate;

abstract class StreamingPlan {
    String name;
    LocalDate startDate;

    StreamingPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends StreamingPlan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate =
                    LocalDate.parse(date);

            StreamingPlan plan;

            if (type.equals("BASIC")) {

                plan =
                        new BasicPlan(name, startDate);

            } else if (type.equals("STANDARD")) {

                plan =
                        new StandardPlan(name, startDate);

            } else {

                plan =
                        new PremiumPlan(name, startDate);
            }

            LocalDate renewalDate =
                    plan.getRenewalDate();

            System.out.println(
                    plan.name + ": " + renewalDate);
        }

        sc.close();
    }
}