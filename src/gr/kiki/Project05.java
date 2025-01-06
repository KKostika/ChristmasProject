package gr.kiki;

import java.util.Scanner;

public class Project05 {


    private static boolean[][] seats = new boolean[30][12];
    private static String userChoice;

    public static void main(String[] args) {
        char[] col = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};
        //   boolean[][] seats = new boolean[30][12];

        Scanner scanner = new Scanner(System.in);
        int charIndex = 0;
        int seatIndex;
        boolean test = true;
        String userPath;
        String cancelChoice;

        System.out.println("Καλώς ήρθατε στο θεατρό!");
        while (test) {
            System.out.println("Επιλέξτε 'B' για κράτηση ή 'C' για ακύρωση.");
            userPath = scanner.next().toUpperCase();
            if (userPath.equals("B")) {
                System.out.println("Παρακαλώ επιλέξτε μια θέση.");
                userChoice = scanner.next().toUpperCase();

                for (int c = 0; c < col.length; c++) {
                    if (userChoice.charAt(0) == col[c]) {
                        charIndex = c;
                    }
                }
                seatIndex = Integer.parseInt(String.valueOf(userChoice.substring(1,userChoice.length()) ));
                book(seatIndex, charIndex);

            }  else if(userPath.equals("C")) {
                System.out.println("Παρακαλώ επιλέξτε την θέση που θα θέλετε να ακυρώσουμε");
                cancelChoice = scanner.next().toUpperCase();

                for (int c = 0; c < col.length; c++) {
                    if (cancelChoice.charAt(0) == col[c]) {
                        charIndex = c;
                    }
                }

                seatIndex = Integer.parseInt(String.valueOf(userChoice.substring(1,userChoice.length()) ));
                System.out.println(charIndex + " " + seatIndex);
                cancel(seatIndex, charIndex);


            } else {
                System.out.println("Η επιλογή δεν είναι έγκυρη.Παρακαλώ προσπαθήστε ξανά.");
            }

            test = exit();

        }
    }

    public static void book(int row, int col) {
        //    boolean[][] seats = new boolean[row][col];

        System.out.println("row:"+row+",col:"+col);
        if (row > 30 || col > 12) {
            System.out.println("Η θέση είναι λανθασμένη. Παρακαλώ προσπαθήστε ξανά.");
            return;
        }


        if (!seats[row - 1][col]) {
            seats[row - 1][col] = true;
            System.out.println("Η θέση " + userChoice + " κρατήθηκε με επιτυχία.");

        } else {
            System.out.println("Η θέση " + userChoice + " είναι ήδη κρατημένη.");
        }

    }


    public static void cancel(int row, int col) {

        if ( row > 30 || col > 12) {
            System.out.println("Η θέση είναι λανθασμένη. Παρακαλώ προσπαθήστε ξανά.");
            return;
        }
        if (seats[row - 1][col]) {
            seats[row - 1][col ] = false;
            System.out.println("Η θέση " + col + row + " ακυρώθηκε με επιτυχία.");

        } else {
            System.out.println("Δεν υπάρχει κράτηση για την θέση " + col + row + ".");
        }

    }

    private static boolean exit() {
        String moreBook;
        boolean con = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Θέλετε να συνεχίσετε;");
        System.out.println("Επιλέξτε 'y' για συνέχεια ή 'n' για έξοδο.");
        moreBook = scanner.next().toUpperCase();
        if (moreBook.equals("N")) {
            con = false;
            System.out.println("Ευχαριστούμε.");
        } return con;
    }

}


