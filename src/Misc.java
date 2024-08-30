import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

class UserDeleted extends Exception {
}

class Misc {
    static Random r = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m\u001B[1m";
    public static final String ANSI_GREEN = "\u001B[92m\u001B[1m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Exception in cls()");
            System.out.println(e);
        }
    }

    public static boolean generateOTP(Scanner inp) {
        JFrame f = new JFrame("OTP");
        JLabel otp_lab;
        int otp = r.nextInt(1000, 9999);
        otp_lab = new JLabel("Your OTP is: " + otp, SwingConstants.CENTER);
        otp_lab.setFont(new Font("Arial", Font.BOLD, 25));

        f.setSize(300, 100);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.add(otp_lab, BorderLayout.CENTER);

        f.setLocationRelativeTo(null);
        f.setAlwaysOnTop(true);
        f.setVisible(true);
        System.out.print("Enter otp: ");
        int ans = inp.nextInt();
        if (ans == otp) {
            f.dispose();
            return true;
        } else {
            f.dispose();
            return false;
        }

    }

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

    public static String formatTimestamp(Timestamp t) {
        return sdf.format(t).toUpperCase();
    }

    public static String leftPadding(String input, char ch, int L) {
        String result = String.format("%" + L + "s", input).replace(' ', ch);
        return result;
    }

    public static String rightPadding(String input, char ch, int L) {
        String result = String.format("%" + (-L) + "s", input).replace(' ', ch);
        return result;
    }

    public static String padAllRight(String[] arr, int L) {
        String res = "";
        for (String string : arr) {
            string = String.format("%-" + L + "s", string);
            res += string;
        }
        return res;
    }

    public static String padAllRight(String[] arr, int L, String color) {
        String res = "";
        for (String string : arr) {
            string = String.format("%-" + L + "s", string);
            res += string;
        }
        return color + res + "\u001B[0m";
    }

    public static Timestamp convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date parsedDate = sdf.parse(date);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        return timestamp;

    }

    public static void welcome() {
        System.out.println(ANSI_GREEN + "\r\n" + //
                "  _____           _          ___            \r\n" + //
                "  \\_   \\_ __  ___| |_ __ _  / _ \\__ _ _   _ \r\n" + //
                "   / /\\/ '_ \\/ __| __/ _` |/ /_)/ _` | | | |\r\n" + //
                "/\\/ /_ | | | \\__ \\ || (_| / ___/ (_| | |_| |\r\n" + //
                "\\____/ |_| |_|___/\\__\\__,_\\/    \\__,_|\\__, |\r\n" + //
                "                                      |___/ \r\n" + //
                "" + ANSI_RESET);
    }

    public static int checkInt(Scanner inp, String s) {
        int n = 0;
        try {
            System.out.print(s);
            n = inp.nextInt();
        } catch (Exception e) {
            System.out.println("Input Type not supported");
            inp.nextLine();
            return checkInt(inp, s);
        }
        return n;
    }
}

class Transaction {
    int ref_no;
    double amount;
    String type, from_, to_;
    Timestamp time;

    public int getRef_no() {
        return ref_no;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getFrom_() {
        return from_;
    }

    public String getTo_() {
        return to_;
    }

    public Timestamp getTime() {
        return time;
    }

    public Transaction(double amount, String to_, String from_, String type, Timestamp time) {
        this.amount = amount;
        this.type = type;
        this.from_ = from_;
        this.to_ = to_;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", type=" + type + ", from_=" + from_ + ", to_=" + to_ + ", time="
                + time + "]";
    }

}