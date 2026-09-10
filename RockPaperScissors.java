import java.util.*;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0, losses = 0, draws = 0;

        System.out.println("Enter number of rounds:");
        int n = sc.nextInt();

        System.out.println("\nRound\tPlayer\t\tComputer\tResult");

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String player = sc.next();

            String computer = moves[r.nextInt(3)];

            String result = playRound(player, computer);

            System.out.println(i + "\t" + player + "\t\t" +
                               computer + "\t\t" + result);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("\nFinal Summary");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");
    }
}