import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

abstract class LibraryItem {
    String title;
    LocalDate currentDate = LocalDate.of(2023, 10, 26);

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowDays();

    LocalDate getDueDate() {
        return currentDate.plusDays(getBorrowDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int space = line.indexOf(' ');

            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") &&
                title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(
                    item.title + ": " +
                    item.getDueDate().format(formatter)
            );
        }

        sc.close();
    }
}