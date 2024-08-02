import java.io.Console;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

// TODO: make a feature to break from recursive loops

public class LoginPage {
    public static void main(String[] args)
            throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        Misc.cls();
        Misc.welcome();

        Scanner sc = new Scanner(System.in);
        SQLQueries quer = new SQLQueries();
        Console cons = System.console();


        int ind = 0;
        while (ind != 3) {
            System.out.println("1) Login");
            System.out.println("2) SignUp");
            System.out.println("3) Exit");

            System.out.print("Enter your choice: ");
            try {
                ind = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input type not supported!!");
            }
            switch (ind) {
                case 1:
                    System.out.print("Enter username: ");
                    sc.nextLine();
                    String user = sc.nextLine();
                    System.out.print("Enter password: ");
                    char[] p = cons.readPassword();
                    String pass = new String(p);

                    int id = quer.checkUsernamePass(user, pass);
                    if (id != 0) {
                        Misc.cls();

                        System.out.println(Misc.ANSI_GREEN + "Login Successfull!!" + Misc.ANSI_RESET);
                        Home h = new Home(id, sc);
                        h.main();
                    } else {
                        Misc.cls();
                        System.out.println(Misc.ANSI_RED + "Wrong username or password!!" + Misc.ANSI_RESET);
                    }
                    ind = 0;
                    break;
                case 2:
                    sc.nextLine();
                    quer.insertNewUser(sc);
                    ind = 0;
                    break;
                case 3:
                    quer.con.close();
                    break;

                default:
                    System.out.println("Enter correct index");
                    break;
            }

        }
        sc.close();

    }
}
