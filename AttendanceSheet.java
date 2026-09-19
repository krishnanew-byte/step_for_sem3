class AttendanceSheet {
    private String[] students;
    private int count;

    AttendanceSheet(int size) {
        students = new String[size];
        count = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (count < students.length) {
            students[count] = name;
            count++;
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count = " + sheet.getPresentCount());
        System.out.println("Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Chen present? " + sheet.isPresent("Chen"));
    }
}