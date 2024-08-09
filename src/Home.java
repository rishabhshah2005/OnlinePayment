import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

class Home {
    Scanner inp;
    int id;
    SQLQueries quer;

    Home(int id, Scanner sc) throws ClassNotFoundException, SQLException {
        this.id = id;
        inp = sc;
        quer = new SQLQueries();
    }

    public void printMenu() {
        System.out.println("1) Pay");
        System.out.println("2) Check your account balance");
        System.out.println("3) View transaction history");
        System.out.println("4) Search through payments");
        System.out.println("5) Change settings");
        System.out.println("6) Exit");
        System.out.println("7) Sign Out");
    }

    void main() throws SQLException, ClassNotFoundException, IOException {
        int index = 0;
        while (index != 7) {
            printMenu();
            index = Misc.checkInt(inp, "Enter index: ");
            inp.nextLine();
            switch (index) {
                case 1:
                    Misc.cls();
                    pay();
                    index = 0;
                    break;
                case 2:
                    checkBalance();
                    index = 0;
                    break;
                case 3:
                    Transactions tr = new Transactions(id);
                    tr.main(inp);
                    index = 0;
                    break;
                case 4:
                    SearchPayments sp = new SearchPayments(id);
                    sp.main(inp);
                    index = 0;
                    break;
                case 5:
                    SettingsPage stp = new SettingsPage(id);
                    try {
                        stp.main(inp);
                    } catch (UserDeleted e) {
                        index = 6;
                        Misc.cls();
                        System.out.println(Misc.ANSI_RED + "USER DELETED!!" + Misc.ANSI_RESET);
                        break;
                    }
                    index = 0;
                    break;
                case 6:
                    Misc.cls();
                    quer.con.close();
                    System.exit(0);
                    break;
                case 7:
                    Misc.cls();
                    quer.con.close();
                    File f = new File("login.txt");
                    f.delete();
                    break;
                default:
                    break;
            }

        }
    }

    void pay() throws SQLException {
        System.out.print("Enter username of whom you want to pay: ");
        String payee = inp.nextLine();
        double amount = 0;

        String pin = "";
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter your pin(" + (5 - i) + " tries left): ");
            pin = inp.nextLine();

            if (quer.checkPin(id, pin)) {
                break;
            }
            System.out.println(Misc.ANSI_RED + "Wrong PIN!!" + Misc.ANSI_RESET);
            if (i == 4) {
                System.out.println(Misc.ANSI_RED + "You are out of tries!!" + Misc.ANSI_RESET);
                return;
            }
        }
        try {
            System.out.print("Enter amount: ");
            amount = inp.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Intput type not supported!!");
            pay();
        }
        quer.payAmount(payee, amount, id);
    }

    void checkBalance() throws SQLException {
        Double bal = quer.checkBalance(id);
        Misc.cls();
        System.out.println("Your balance is : $" + bal);
    }
}
