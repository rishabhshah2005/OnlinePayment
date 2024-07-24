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

    public static void welcome() {
        System.out.println("__          __  ______   _         _____    ____    __  __   ______ \r\n" + //
                " \\ \\        / / |  ____| | |       / ____|  / __ \\  |  \\/  | |  ____|\r\n" + //
                "  \\ \\  /\\  / /  | |__    | |      | |      | |  | | | \\  / | | |__   \r\n" + //
                "   \\ \\/  \\/ /   |  __|   | |      | |      | |  | | | |\\/| | |  __|  \r\n" + //
                "    \\  /\\  /    | |____  | |____  | |____  | |__| | | |  | | | |____ \r\n" + //
                "     \\/  \\/     |______| |______|  \\_____|  \\____/  |_|  |_| |______|");
    }
}

class Transaction{
    int ref_no, to_id, from_id;
    double amount;
    String type;
    Timestamp time;
    public int getRef_no() {
        return ref_no;
    }
    public int getTo_id() {
        return to_id;
    }
    public int getFrom_id() {
        return from_id;
    }
    public double getAmount() {
        return amount;
    }
    public String getType() {
        return type;
    }
    public Timestamp getTime() {
        return time;
    }
    public Transaction(int ref_no, int to_id, int from_id, double amount, String type, Timestamp time) {
        this.ref_no = ref_no;
        this.to_id = to_id;
        this.from_id = from_id;
        this.amount = amount;
        this.type = type;
        this.time = time;
    }
    
}
