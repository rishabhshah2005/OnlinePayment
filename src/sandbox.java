import java.sql.Timestamp;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class sandbox {
    public static void main(String[] args) throws ClassNotFoundException {
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // String dburl = "jdbc:mysql://localhost:3306/payment";
        // String dbuser = "root";
        // String dbpass = "";

        // Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

        // if (con!=null) {
        // String sql = "Select * from users";
        // PreparedStatement pst = con.prepareStatement(sql);
        // ResultSet rs = pst.executeQuery();

        // while (rs.next()) {
        // System.out.println(rs.getString(2)+rs.getString(3));
        // }
        // } else {
        // System.out.println("Connection failed");
        // }
        String a = "hessssssllo";
        a = String.format("%-10s", a).replaceAll(" ", "*");
        System.out.println(a);

        try {
            Timestamp t = new Timestamp(System.currentTimeMillis());
            LocalDateTime ld = LocalDateTime.ofInstant(t.toInstant(), ZoneId.of("Asia/Kolkata"));
            System.out.println(ld);

            Timestamp t2 = Timestamp.valueOf("2024-07-26 00:00:00");
            LocalDateTime ld2 = LocalDateTime.ofInstant(t2.toInstant(), ZoneId.of("Asia/Kolkata"));
            System.out.println(ld2);

            System.out.println(ld2.getDayOfYear()==ld.getDayOfYear());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
