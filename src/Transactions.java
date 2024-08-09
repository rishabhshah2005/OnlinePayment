import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;

import DS.LinkedListPrac;

public class Transactions {
    String user;
    SQLQueries quer;
    LinkedListPrac<Transaction> trans_arr = new LinkedListPrac<>() {
        @Override
        public void viewAll() {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                        "" + temp.val.getTime() };
                System.out.println(Misc.padAllRight(line, 25));
                temp = temp.next;
            }
            System.out.println();
        }

        public void viewReciv(String user) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.to_.equals(user)) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }

        public void viewSent(String user) {
            Node temp = head;
            if (head == null) {
                System.out.println("No transactions have been made");
                return;
            }
            String[] heading = { "To", "From", "Amount", "Type", "Time" };
            System.out.println(Misc.padAllRight(heading, 25, "\u001B[33m"));
            while (temp != null) {
                if (temp.val.from_.equals(user)) {
                    String[] line = { temp.val.to_, temp.val.from_, "$" + temp.val.getAmount(), temp.val.getType(),
                            "" + temp.val.getTime() };
                    System.out.println(Misc.padAllRight(line, 25));
                }
                temp = temp.next;
            }
            System.out.println();
        }
    };
    LinkedListPrac<User> user_arr = new LinkedListPrac<>();
    ResultSet rs;

    public Transactions(int id) throws ClassNotFoundException, SQLException {
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

    void viewAll() {
        Misc.cls();
        trans_arr.viewAll();
    }

    void viewRecived() {
        Misc.cls();
        trans_arr.viewReciv(user);
    }

    void viewSent() {
        Misc.cls();
        trans_arr.viewSent(user);
    }

    void display() {
        trans_arr.display();
    }

    void printMenu() {
        System.out.println("1) View all transactions");
        System.out.println("2) View Sent transactions");
        System.out.println("3) View Recieved transactions");
        System.out.println("4) Exit");
    }

    void main(Scanner inp) {

        int index = 0;
        while (index != 4) {
            printMenu();
            index = Misc.checkInt(inp, "Enter index: ");
            switch (index) {
                case 1:
                    viewAll();
                    index = 0;
                    break;
                case 2:
                    viewSent();
                    index = 0;
                    break;
                case 3:
                    viewRecived();
                    index = 0;
                    break;
                case 4:
                    Misc.cls();
                    break;

                default:
                    System.out.println("Enter correct index");
                    break;
            }

        }

    }
}
