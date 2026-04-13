import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class ResulSet {
    public class JDBC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/student_db"; // Replace with your database name
        String user = "root";
        String password = ""; // XAMPP often uses empty root password by default

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully");

         
              String sql= "select * from students";
               PreparedStatement stmt=con.prepareStatement(sql);
               ResultSet rs=stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
            
    //            String sql;
    //            sql=sc.nextLine();
    //          stmt.executeUpdate(sql);
    //          System.out.println("Record inserted successfully");
       con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}   
    
}
