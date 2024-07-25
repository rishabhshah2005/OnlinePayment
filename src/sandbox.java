import java.sql.*;

public class sandbox {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        // Class.forName("com.mysql.cj.jdbc.Driver");
        
        // String dburl = "jdbc:mysql://localhost:3306/payment";
        // String dbuser = "root";
        // String dbpass = "";

        // Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

        // if (con!=null) {
        //     String sql = "Select * from users";
        //     PreparedStatement pst = con.prepareStatement(sql);
        //     ResultSet rs = pst.executeQuery();

        //     while (rs.next()) {
        //         System.out.println(rs.getString(2)+rs.getString(3));
        //     }
        // } else {
        //     System.out.println("Connection failed");
        // }
        String a = "hessssssllo";
        a = String.format("%-10s", a).replaceAll(" ", "*");
        System.out.println(a);
    }
}
