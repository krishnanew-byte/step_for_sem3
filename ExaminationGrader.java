import java.util.*;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String questionText,
             String correctAnswer,
             String studentAnswer,
             double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();

    abstract String getType();
}

class MultipleChoice extends Question {

    MultipleChoice(String q,
                   String correct,
                   String student,
                   double points) {

        super(q, correct, student, points);
    }

    double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TrueFalse extends Question {

    TrueFalse(String q,
              String correct,
              String student,
              double points) {

        super(q, correct, student, points);
    }

    double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }

    String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {

    EssayQuestion(String q,
                  String correct,
                  String student,
                  double points) {

        super(q, correct, student, points);
    }

    double grade() {

        String answer =
                studentAnswer.toLowerCase();

        String[] keywords =
                correctAnswer.split(",");

        int count = 0;

        for (String keyword : keywords) {

            keyword =
                    keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            double points =
                    Double.parseDouble(parts[6].trim());

            Question question;

            if (type.equals("MCQ")) {

                question = new MultipleChoice(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            } else if (type.equals("TF")) {

                question = new TrueFalse(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);

            } else {

                question = new EssayQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points);
            }

            double score = question.grade();

            System.out.printf(
                    "%s: %.2f%n",
                    question.getType(),
                    score);

            totalScore += score;
        }

        System.out.printf(
                "Total Score: %.2f%n",
                totalScore);

        sc.close();
    }
}