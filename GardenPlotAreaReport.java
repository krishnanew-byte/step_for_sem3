
import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    double radius = sc.nextDouble();
                    plot = new Circle(owner, radius);
                    break;

                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plot = new Rectangle(owner, length, width);
                    break;

                case "TRIANGLE":
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plot = new Triangle(owner, base, height);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid shape");
            }

            double area = plot.calculateArea();

            System.out.printf(
                "%s (%s): %.2f%n", owner, shape, area
            );

            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}
