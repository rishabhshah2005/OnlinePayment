import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

// TODO: make a feature to break from recursive loops

public class LoginPage {
    public static void main(String[] args)
            throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        Misc.welcome();

        Scanner inp = new Scanner(System.in);
        SQLQueries quer = new SQLQueries();
        Console cons = System.console();
        int currentUserID = -1;

        int index = 0;
        while (index != 3) {
            System.out.println("1) Login");
            System.out.println("2) SignUp");
            System.out.println("3) Exit");

            System.out.print("Enter your choice: ");
            index = inp.nextInt();
            switch (index) {
                case 1:
                    System.out.print("Enter username: ");
                    inp.nextLine();
                    String user = inp.nextLine();
                    System.out.print("Enter password: ");
                    char[] p = cons.readPassword();
                    String pass = new String(p);

                    int id = quer.checkUsernamePass(user, pass);
                    if (id != 0) {
                        Misc.cls();
                        currentUserID = id;
                        System.out.println("Login Successfull!!");
                    } else {
                        Misc.cls();
                        System.out.println("Wrong username or password!!");
                    }
                    break;
                case 2:
                    inp.nextLine();
                    quer.insertNewUser(inp);
                    break;

                default:
                    break;
            }
        }
        inp.close();

    }
}
