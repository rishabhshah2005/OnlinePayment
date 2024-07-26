import java.sql.*;
import java.util.Scanner;

public class SQLQueries {

    String dburl = "jdbc:mysql://localhost:3306/payment";
    String dbuser = "root";
    String dbpass = "";

    Connection con;

    SQLQueries() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(dburl, dbuser, dbpass);
    }

    int checkUsernamePass(String user, String pass) throws SQLException {
        String sql = "select user_id from users where username=? and password=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, user);
        pst.setString(2, pass);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public void updateUser(String newVal, String oldVal) throws SQLException {
        String sql = "update users set username=? where username=?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, newVal);
        pst.setString(2, oldVal);
        pst.executeUpdate();
    }

    public void updatePass(String newVal, String oldVal) throws SQLException {
        String sql = "update users set password=? where username=?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, newVal);
        pst.setString(2, oldVal);
        pst.executeUpdate();
    }

    public void updateType(int id, String type) throws SQLException {
        String sql = "update users set buisness_type=? where user_id=?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, type);
        pst.setInt(2, id);
        pst.executeUpdate();
    }

    void deleteUser(int id) throws SQLException {
        String sql = "delete from users where user_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
    }

    private int getBranchID(Scanner inp) throws SQLException {
        String sql = "select * from banks";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int lastId = 0;
        while (rs.next()) {
            System.out.println(rs.getInt(1) + ") " + rs.getString(2) + " " + rs.getString(3));
            lastId = rs.getInt(1);
        }
        int id = -1;
        System.out.print("Enter bank id from the above options: ");
        try {
            id = inp.nextInt();
        } catch (Exception e) {
            System.out.println("INPUT NOT SUPPORTED");
            return getBranchID(inp);
        }
        if (id > lastId || id < 1) {
            Misc.cls();
            System.out.println("Enter Correct ID");
            return getBranchID(inp);
        } else {
            return id;
        }

    }

    private int takeAge(Scanner inp) {
        int age = -1;
        try {
            System.out.print("Enter age: ");
            inp.nextLine();
            age = inp.nextInt();
        } catch (Exception e) {
            System.out.println("Input not supported!!");
            return takeAge(inp);
        }
        while (age < 18) {
            if (age < 0) {
                System.out.println("Negative age is not allowed");
                System.out.print("Enter age: ");
                age = inp.nextInt();
                continue;
            }
            System.out.println("You must be at least 18 to open a account!!");
            System.out.print("Enter age: ");
            age = inp.nextInt();
        }
        return age;
    }

    public boolean checkUsername(String user) throws SQLException {
        String sql = "select * from users where username=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, user);
        ResultSet rs = pst.executeQuery();
        boolean found = rs.next();
        return found;
    }

    void insertNewUser(Scanner inp) throws SQLException {
        // TODO: check limits for all fields
        System.out.print("Enter firstname: ");
        String first = inp.nextLine();
        while (first.length() > 20) {
            System.out.println("firstname must be less than 20 characters!!");
            System.out.print("Enter firstname: ");
            first = inp.nextLine();
        }

        System.out.print("Enter lastname: ");
        String last = inp.nextLine();
        while (last.length() > 20) {
            System.out.println("lastname must be less than 20 characters!!");
            System.out.print("Enter lastname: ");
            last = inp.nextLine();
        }

        System.out.print("Enter mobile number: ");
        String mobile = inp.nextLine();
        while (mobile.length() != 10) {
            System.out.println("Mobile number has to be of 10 digits");
            System.out.print("Enter mobile number: ");
            mobile = inp.nextLine();
        }

        int id = getBranchID(inp);
        int age = takeAge(inp);

        inp.nextLine();
        System.out.print("Create username: ");
        String username = inp.nextLine();
        boolean found = checkUsername(username);
        while (found) {
            System.out.println(
                    Misc.ANSI_RED + "Username already exists. Please enter another username!!" + Misc.ANSI_RESET);
            System.out.print("Create username: ");
            username = inp.nextLine();
            found = checkUsername(username);
        }

        System.out.print("Create Password: ");
        String password = inp.nextLine();

        System.out.print("Create PIN: ");
        String pin = inp.nextLine();
        while (pin.length() != 6) {
            System.out.println("PIN has to be of 6 chars");
            System.out.print("Create PIN: ");
            pin = inp.nextLine();
        }

        String sql = "insert into users(first_name, last_name, age, mobile, current_bank_id, username, password, pin) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, first);
        pst.setString(2, last);
        pst.setInt(3, age);
        pst.setString(4, mobile);
        pst.setInt(5, id);
        pst.setString(6, username);
        pst.setString(7, password);
        pst.setString(8, pin);

        int res = pst.executeUpdate();
        if (res > 0) {
            Misc.cls();
            System.out.println("Account created successfully");
        } else {
            Misc.cls();
            System.out.println("Account not created :(");
        }
    }

    public int getUserID(String username) throws SQLException {
        String sql = "Select user_id from users where username=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        int id = -1;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;

    }

    public String getUsername(int id) throws SQLException {
        String sql = "Select username from users where user_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        String user = "";
        if (rs.next()) {
            user = rs.getString(1);
        }
        return user;

    }

    public double checkBalance(int id) throws SQLException {
        String sql = "select amount from balance where user_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getDouble(1);
    }

    public boolean checkPin(int id, String pin) throws SQLException {
        boolean found = false;
        String sql = "select * from users where user_id=? and pin=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setString(2, pin);
        ResultSet rs = pst.executeQuery();
        found = rs.next();
        return found;
    }

    public void payAmount(String user, double amount, int id) throws SQLException {
        String sql = "select amount from balance where user_id=?";
        int payee_id = getUserID(user);
        String payer = getUsername(id);
        if (payer.equals(user)) {
            System.out.println("You cant transfer money to your self!!");
            return;
        }
        if (payee_id == -1) {
            System.out.println("Username does not exist!!");
            return;
        }
        if (amount < 0) {
            System.out.println("Amount cant be negative!! Nice try :)");
            return;
        }

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        rs.next();
        double curr_balance = rs.getDouble(1);
        if (curr_balance < amount) {
            System.out.println(Misc.ANSI_RED + "Insufficient Balance($" + curr_balance + ")!!!" + Misc.ANSI_RESET);
            return;
        } else {
            double new_bal = curr_balance - amount;
            String add = "update balance set amount=? where user_id=?";
            String sub = "update balance set amount=amount+? where user_id=?";

            pst = con.prepareStatement(add);
            pst.setDouble(1, new_bal);
            pst.setInt(2, id);
            pst.execute();

            pst = con.prepareStatement(sub);
            pst.setDouble(1, amount);
            pst.setInt(2, payee_id);
            pst.execute();
            System.out.println(Misc.ANSI_GREEN + "Payment successfull!!!!" + Misc.ANSI_RESET);

            String hist = "INSERT INTO payment_history(to_, from_, amount) VALUES(?,?,?)";
            pst = con.prepareStatement(hist);
            pst.setString(1, user);

            pst.setString(2, payer);
            pst.setDouble(3, amount);
            pst.execute();
        }
    }

    public ResultSet getTransactions(String username) throws SQLException {
        String sql = "select * from payment_history where to_=? or from_=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, username);
        return pst.executeQuery();
    }

    public ResultSet getUsers(int id) throws SQLException {
        String sql = "select user_id, username from users";
        PreparedStatement pst = con.prepareStatement(sql);
        return pst.executeQuery();
    }
}
