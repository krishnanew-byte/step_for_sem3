import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    // Encapsulation
    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility
    static boolean isEligible(double cgpa) {

        return cgpa >= 7.5;
    }

    // Combined eligibility
    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Calculate composite score
    double getCompositeScore() {

        return cgpa * 10 + codingScore * 0.5;
    }

    // Sort in descending order
    public int compareTo(Candidate other) {

        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted =
            new Candidate[candidates.length];

        int count = 0;

        // Find eligible candidates
        for (int i = 0; i < candidates.length; i++) {

            if (isEligible(candidates[i].cgpa) ||
                isEligible(
                    candidates[i].cgpa,
                    candidates[i].codingScore
                )) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        // Create array of exact size
        Candidate[] finalList =
            new Candidate[count];

        for (int i = 0; i < count; i++) {
            finalList[i] = shortlisted[i];
        }

        // Sort using compareTo()
        Arrays.sort(finalList);

        // Create result
        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result
                   + (i + 1)
                   + ". "
                   + finalList[i].name
                   + " ("
                   + finalList[i].getCompositeScore()
                   + ")";

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate("Aisha", 8.2, 40),

            new Candidate("Rohit", 6.8, 65),

            new Candidate("Meena", 6.0, 90),

            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}