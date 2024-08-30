import java.sql.SQLException;
import java.util.Scanner;

public class SettingsPage implements Skeleton {
    SQLQueries quer;
    int id;

    public SettingsPage(int x, SQLQueries q) throws SQLException {
        quer = q;
        id = x;
    }

    public void printMenu() {
        System.out.println("1) Change username");
        System.out.println("2) Change password");
        System.out.println("3) Change Buisness Type");
        System.out.println(Misc.ANSI_RED + "4) DELETE ACCOUNT" + Misc.ANSI_RESET);
        System.out.println("5) Exit");
    }

    void changeUsername(Scanner inp) throws SQLException {
        System.out.print("Enter old username: ");

        String old_usr = inp.nextLine();
        System.out.print("Enter password: ");
        String pass = inp.nextLine();
        if (quer.checkUsernamePass(old_usr, pass) != 0) {
            System.out.print("Enter new username: ");
            String new_usr = inp.nextLine();
            if (quer.checkUsername(new_usr)) {
                Misc.cls();
                System.out.println(Misc.ANSI_RED + "Username already exists!!!" + Misc.ANSI_RESET);
                return;
            }
            quer.updateUser(new_usr, old_usr);
            System.out.println(Misc.ANSI_GREEN + "Username updated!!" + Misc.ANSI_RESET);

        } else {
            System.out.println("Username or password is wrong!!");
            changeUsername(inp);
        }

    }

    void changePassword(Scanner inp) throws SQLException {
        System.out.print("Enter username: ");
        String old_usr = inp.nextLine();
        System.out.print("Enter old password: ");
        String pass = inp.nextLine();
        if (quer.checkUsernamePass(old_usr, pass) != 0) {
            System.out.print("Enter new password: ");
            String new_usr = inp.nextLine();
            quer.updatePass(new_usr, old_usr);
            System.out.println(Misc.ANSI_GREEN + "Password updated!!" + Misc.ANSI_RESET);

        } else {
            System.out.println("Username or password is wrong!!");
            changeUsername(inp);
        }
    }

    void changeType(Scanner inp) throws SQLException {
        Misc.cls();
        System.out.print("Enter Type: ");
        String type = inp.nextLine();
        quer.updateType(id, type);
        System.out.println("Buisness Type updated");

    }

    void deleteUser(Scanner inp) throws SQLException, UserDeleted {
        System.out.print("Do you really want to delete your account (y/n): ");
        String ans = inp.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            System.out.print("Enter username: ");
            String usr = inp.nextLine();
            System.out.print("Enter password: ");
            String pass = inp.nextLine();
            if (quer.checkUsernamePass(usr, pass) == id) {
                System.out.print("Do you really want to proceed (y/n): ");
                ans = inp.nextLine();
                if (ans.equalsIgnoreCase("y")) {
                    quer.deleteUser(id);
                    throw new UserDeleted();
                } else {
                    return;
                }
            } else {
                System.out.println("Wrong username or password!!!");
            }
        } else {
            return;
        }
    }

    void main(Scanner inp) throws SQLException, UserDeleted {
        Misc.cls();
        int index = 0;
        while (index != 5) {
            printMenu();
            index = Misc.checkInt(inp, "Enter index: ");
            switch (index) {
                case 1:
                    Misc.cls();
                    inp.nextLine();
                    changeUsername(inp);
                    index = 0;
                    break;
                case 2:
                    Misc.cls();
                    inp.nextLine();
                    changePassword(inp);
                    index = 0;
                    break;
                case 3:
                    Misc.cls();
                    inp.nextLine();
                    changeType(inp);
                    index = 0;
                    break;
                case 4:
                    Misc.cls();
                    inp.nextLine();
                    deleteUser(inp);
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
