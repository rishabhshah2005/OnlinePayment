import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.ZoneId;

import DS.LinkedListPrac;

public class SearchPayments {
    String user;
    SQLQueries quer;
    ResultSet rs;

    LinkedListPrac<Transaction> trans_arr = new LinkedListPrac<>() {
        public void searchByType(String type) {

            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.type.equals(type)) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }

        public void searchToUser(String user) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.to_.equals(user) || temp.val.from_.equals(user)) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }

        public void searchMaxAmnt(double x) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.amount <= x) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }

        public void searchMinAmnt(double x) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.amount >= x) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }

        public void searchXAmnt(double x) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.amount == x) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }

        public void showBefore(Timestamp t) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.time.before(t)) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }

        public void showAfter(Timestamp t) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.time.after(t)) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }

        public void showOn(Timestamp t) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            LocalDateTime org = LocalDateTime.ofInstant(t.toInstant(), ZoneId.of("Asia/Kolkata"));
            while (temp != null) {
                LocalDateTime d = LocalDateTime.ofInstant(temp.val.time.toInstant(), ZoneId.of("Asia/Kolkata"));

                if (d.getDayOfYear() == org.getDayOfYear() && d.getYear() == org.getYear()) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }
    };

    /*
     * -- search by type
     * -- search by min amount
     * -- search by date
     * -- search by user
     */
    public SearchPayments(int id) throws ClassNotFoundException, SQLException {
        quer = new SQLQueries();
        user = quer.getUsername(id);
        rs = quer.getTransactions(user);
        while (rs.next()) {
            double amount = rs.getDouble("amount");
            String to_ = rs.getString("to_");
            String from_ = rs.getString("from_");
            String type = rs.getString("type");
            Timestamp time = rs.getTimestamp("time");
            Transaction t = new Transaction(amount, to_, from_, type, time);
            trans_arr.addFirst(t);
        }
    }

    void searchByDate(Scanner inp) {
        Misc.cls();
        System.out.println("1) Before X date");
        System.out.println("2) After X date");
        System.out.println("3) On X date");
        System.out.println("4) Exit");
        System.out.print("Enter index: ");
        int index = inp.nextInt();
        switch (index) {
            case 1:
                System.out.print("Enter date in dd-mm-yyyy format: ");
                inp.nextLine();
                String dat = inp.nextLine();
                try {
                    trans_arr.showBefore(Misc.convert(dat));
                } catch (Exception e) {
                    System.out.println("Enter date in correct format!!");
                }
                break;
            case 2:
                System.out.print("Enter date in dd-mm-yyyy format: ");
                inp.nextLine();
                String dat1 = inp.nextLine();
                try {
                    trans_arr.showAfter(Misc.convert(dat1));
                } catch (Exception e) {
                    System.out.println("Enter date in correct format!!");
                }
                break;
            case 3:
                System.out.print("Enter date in dd-mm-yyyy format: ");
                inp.nextLine();
                String dat2 = inp.nextLine();
                try {
                    trans_arr.showOn(Misc.convert(dat2));
                } catch (Exception e) {
                    System.out.println("Enter date in correct format!!");
                }
                break;

            default:
                break;
        }
    }

    void searchByAmount(Scanner inp) {
        Misc.cls();
        System.out.println("1) At most X amount");
        System.out.println("2) At least X amount");
        System.out.println("3) X amount");
        System.out.println("4) Exit");
        System.out.print("Enter index: ");
        int index = inp.nextInt();
        switch (index) {
            case 1:
                System.out.print("Enter max amount: ");
                double x = inp.nextDouble();
                trans_arr.searchMaxAmnt(x);
                break;
            case 2:
                System.out.print("Enter min amount: ");
                double y = inp.nextDouble();
                trans_arr.searchMinAmnt(y);
                break;
            case 3:
                System.out.print("Enter max amount: ");
                double z = inp.nextDouble();
                trans_arr.searchXAmnt(z);
                break;
            case 4:
                break;
            default:
                System.out.println("Enter correct index!!");
                searchByAmount(inp);
                break;
        }
    }

    void printMenu() {
        System.out.println("1) Search by type");
        System.out.println("2) Search by amount");
        System.out.println("3) Search by date");
        System.out.println("4) Search by user");
        System.out.println("5) Exit");
    }

    void main(Scanner inp) {
        Misc.cls();
        int index = 0;
        while (index != 5) {
            printMenu();
            
            index = Misc.checkInt(inp, "Enter index: ");
            switch (index) {
                case 1:
                    Misc.cls();
                    System.out.print("Enter type of payment: ");
                    inp.nextLine();
                    String typ = inp.nextLine();
                    trans_arr.searchByType(typ);
                    index = 0;
                    break;
                case 2:
                    Misc.cls();
                    searchByAmount(inp);
                    index = 0;
                    break;
                case 3:
                    Misc.cls();
                    searchByDate(inp);
                    index = 0;
                    break;
                case 4:
                    Misc.cls();
                    System.out.print("Enter username you want to search: ");
                    inp.nextLine();
                    String usr = inp.nextLine();
                    trans_arr.searchToUser(usr);
                    index = 0;
                    break;
                case 5:
                    Misc.cls();
                    break;

                default:
                    System.out.println("Enter correct index");
                    index = 0;
                    break;
            }

        }

    }

}