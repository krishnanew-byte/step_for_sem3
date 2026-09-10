import java.util.Scanner;

public class BankTransactionReferenceGenerator {

    static String normalizeReference(String raw) {

        raw = raw.trim();

        String bank = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return bank + rest;
    }

    static String validateAndFormat(String reference) {

        if (reference.length() != 14)
            return "Invalid: wrong length";

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i)))
                return "Invalid: bank code must be 3 letters";
        }

        // Check remaining characters are digits
        for (int i = 3; i < reference.length(); i++) {

            if (!Character.isDigit(reference.charAt(i)))
                return "Invalid: body must contain only digits";
        }

        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        String formattedDate =
                date.substring(0, 2) + "/" +
                date.substring(2, 4) + "/" +
                date.substring(4, 6);

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(bank);
        sb.append("] DATE: ");
        sb.append(formattedDate);
        sb.append(" | SEQ: ");
        sb.append(sequence);

        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));
    }
}