import java.sql.Timestamp;

class Misc {
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Exception in cls()");
            System.out.println(e);
        }
    }

    public static String leftPadding(String input, char ch, int L) {

        String result = String.format("%" + L + "s", input).replace(' ', ch);

        // Return the resultant string
        return result;
    }

    // Function to perform right padding
    public static String rightPadding(String input, char ch, int L) {

        String result = String.format("%" + (-L) + "s", input).replace(' ', ch);

        // Return the resultant string
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

    public static void welcome() {
        System.out.println("__          __  ______   _         _____    ____    __  __   ______ \r\n" + //
                " \\ \\        / / |  ____| | |       / ____|  / __ \\  |  \\/  | |  ____|\r\n" + //
                "  \\ \\  /\\  / /  | |__    | |      | |      | |  | | | \\  / | | |__   \r\n" + //
                "   \\ \\/  \\/ /   |  __|   | |      | |      | |  | | | |\\/| | |  __|  \r\n" + //
                "    \\  /\\  /    | |____  | |____  | |____  | |__| | | |  | | | |____ \r\n" + //
                "     \\/  \\/     |______| |______|  \\_____|  \\____/  |_|  |_| |______|");
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

class User {
    int user_id;
    String username;

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public User(int user_id, String username) {
        this.user_id = user_id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [" + user_id + ":" + username + "]";
    }

}
