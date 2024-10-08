import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.sql.*;

public class LoginPage {
    public static void main(String[] args)
            throws IOException, InterruptedException, SQLException, ClassNotFoundException {
        Misc.cls();
        Misc.welcome();

        Scanner sc = new Scanner(System.in);
        SQLQueries quer = new SQLQueries();
        Console cons = System.console();
        File f = new File("login.txt");
        if (f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String user = "";
            String pass = "";
            user = br.readLine();
            pass = br.readLine();
            br.close();
            fr.close();
            if (user != null && pass != null) {
                int id = quer.checkUsernamePass(user, pass);
                if (id != 0) {
                    Home h = new Home(id, sc, quer);
                    h.main();
                }
            }
        }

        int ind = 0;
        while (ind != 3) {
            System.out.println("1) Login");
            System.out.println("2) SignUp");
            System.out.println("3) Exit");

            ind = Misc.checkInt(sc, "Enter your choice: ");

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
                        boolean otp_check = Misc.generateOTP(sc);
                        if (!otp_check) {
                            Misc.cls();
                            System.out.println(Misc.ANSI_RED + "Enter correct OTP" + Misc.ANSI_RESET);
                            break;
                        }
                        Misc.cls();
                        sc.nextLine();
                        System.out.print("Do you want to stay signed in?? (y/n): ");
                        String ans = sc.nextLine();
                        while (!(ans.equals("y") || ans.equals("n"))) {
                            System.out.println("Enter correct option!!");
                            System.out.print("Do you want to stay signed in?? (y/n): ");
                            ans = sc.nextLine();
                        }
                        if (ans.equals("y")) {
                            // File f = new File("login.txt");
                            FileWriter fw = new FileWriter(f);
                            fw.write(user + "\n");
                            fw.write(pass);
                            fw.close();
                        }
                        Misc.cls();
                        System.out.println(Misc.ANSI_GREEN + "Login Successfull!!" + Misc.ANSI_RESET);
                        Home h = new Home(id, sc, quer);
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
