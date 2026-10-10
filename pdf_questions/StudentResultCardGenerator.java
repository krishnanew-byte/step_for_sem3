import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 10: Student Result Card Generator
 * 
 * TASK:
 * Design a system for student result cards. Each student has a name and an array
 * of three marks. Implement a method to calculate the student's average mark.
 * Based on the average, assign a grade using the following conditions: 'B' for an
 * average of 75 or more, 'D' for an average between 40 and 59 (inclusive), and
 * other grades as per your design ('A' for >= 90, 'C' for 60 to 74, 'F' for < 40).
 * Finally, print the student's name in capital letters, their average mark (one
 * decimal place), and their assigned grade.
 * 
 * EXAMPLE:
 * Sample Input:
 * Asha [80, 90, 70]
 * Ravi [60, 55, 50]
 * Expected Output:
 * ASHA: Average 80.0, Grade B
 * RAVI: Average 55.0, Grade D
 * 
 * HINT:
 * Create a Student class with fields for name and marks array. Implement a method
 * within the Student class to calculate the average. Use conditional logic to
 * determine the grade based on the average. Convert the student's name to uppercase
 * for printing.
 */
class Student {
    private String name;
    private double[] marks;

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double calculateAverage() {
        if (marks == null || marks.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.length;
    }

    public char calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 90.0) {
            return 'A';
        } else if (avg >= 75.0) {
            return 'B';
        } else if (avg >= 60.0) {
            return 'C';
        } else if (avg >= 40.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printResultCard() {
        double avg = calculateAverage();
        char grade = calculateGrade();
        System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCardGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            // Parse lines formatted like: Asha [80, 90, 70] or Asha 80 90 70
            try {
                int openBracket = line.indexOf('[');
                int closeBracket = line.indexOf(']');
                if (openBracket != -1 && closeBracket != -1) {
                    String name = line.substring(0, openBracket).trim();
                    String marksPart = line.substring(openBracket + 1, closeBracket).trim();
                    String[] tokens = marksPart.split("[,\\s]+");
                    double[] marks = new double[tokens.length];
                    for (int i = 0; i < tokens.length; i++) {
                        marks[i] = Double.parseDouble(tokens[i]);
                    }
                    students.add(new Student(name, marks));
                } else {
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 2) {
                        String name = parts[0];
                        double[] marks = new double[parts.length - 1];
                        for (int i = 1; i < parts.length; i++) {
                            marks[i - 1] = Double.parseDouble(parts[i]);
                        }
                        students.add(new Student(name, marks));
                    }
                }
            } catch (Exception ignored) {
            }
        }

        if (!students.isEmpty()) {
            for (Student student : students) {
                student.printResultCard();
            }
        } else {
            // Default demo run
            System.out.println("--- Demo Runs ---");
            Student s1 = new Student("Asha", new double[]{80, 90, 70});
            Student s2 = new Student("Ravi", new double[]{60, 55, 50});
            s1.printResultCard();
            s2.printResultCard();
        }

        scanner.close();
    }
}
