
import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    double weeklySalary;

    FullTime(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    double calculatePay() {
        return weeklySalary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Staff staff;

            switch (type) {
                case "FULLTIME":
                    double salary = sc.nextDouble();
                    staff = new FullTime(name, salary);
                    break;

                case "HOURLY":
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    staff = new Hourly(name, hours, rate);
                    break;

                case "INTERN":
                    double stipend = sc.nextDouble();
                    staff = new Intern(name, stipend);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid staff type");
            }

            double pay = staff.calculatePay();

            System.out.printf("%s: %.2f%n", name, pay);
            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}
