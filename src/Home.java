import java.sql.SQLException;
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
        System.out.println("6) Sign Out");
    }

    void main() throws SQLException {
        int index = 0;
        while (index != 6) {
            printMenu();
            System.out.print("Enter index: ");
            index = inp.nextInt();
            inp.nextLine();
            switch (index) {
                case 1:
                    Misc.cls();
                    pay();
                    break;
                case 2:
                    checkBalance();
                    break;
                case 6:
                    quer.con.close();
                    break;
                default:
                    break;
            }
        }
    }

    void pay() throws SQLException {
        System.out.print("Enter username of whom you want to pay: ");
        String payee = inp.nextLine();
        System.out.print("Enter amount: ");
        double amount = inp.nextDouble();
        quer.payAmount(payee, amount, id);
    }

    void checkBalance() throws SQLException {
        Double bal = quer.checkBalance(id);
        System.out.println("Your balance is : $" + bal);
    }
}
