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

    private int getBranchID(Scanner inp) throws SQLException {
        String sql = "select * from banks";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int lastId = 0;
        while (rs.next()) {
            System.out.println(rs.getInt(1) + ") " + rs.getString(2) + " " + rs.getString(3));
            lastId = rs.getInt(1);
        }
        System.out.print("Enter bank id from the above options: ");
        int id = inp.nextInt();
        if (id > lastId || id < 1) {
            Misc.cls();
            System.out.println("Enter Correct ID");
            return getBranchID(inp);
        } else {
            return id;
        }

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

        System.out.print("Enter age: ");
        int age = inp.nextInt();
        while (age < 18) {
            System.out.println("You must be at least 18 to open a account!!");
            System.out.print("Enter age: ");
            age = inp.nextInt();
        }

        System.out.print("Enter mobile number: ");
        inp.nextLine();
        String mobile = inp.nextLine();
        while (mobile.length() != 10) {
            System.out.println("Mobile number has to be of 10 digits");
            System.out.print("Enter mobile number: ");
            mobile = inp.nextLine();
        }

        int id = getBranchID(inp);

        inp.nextLine();
        System.out.print("Create username: ");
        String username = inp.nextLine();

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
    };
}
