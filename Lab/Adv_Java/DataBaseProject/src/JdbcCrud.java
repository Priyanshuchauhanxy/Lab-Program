import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;




//crud opration through jdbc
class JdbcCrud {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = ""; 
         try{
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connected successfully");


        do { 
            System.out.println("Crud Optrations");
            System.out.println("1.Insert Record");
            System.out.println("2.Update Record");
            System.out.println("3.Delete Record");
            System.out.println("4.Search Record");
            System.out.println("5.View all Record");
               

                System.out.println("Enter your choice: ");  
                int choice= sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter ID: ");
                        int id= sc.nextInt();
                        System.out.println("Enter name: ");
                        String name= sc.next();
                        System.out.println("Enter age: ");
                        int age= sc.nextInt();
                        String sql = "insert into students values(" + id + ", '" + name + "', " + age + ")";

                        Statement stmt= con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Record inserted successfully");
                        break;

                    case 2:
                        System.out.println("Enter ID to update: ");
                        int updateId= sc.nextInt();
                        System.out.println("Enter new name: ");
                        String newName= sc.next();
                        System.out.println("Enter new age: ");
                        int newAge= sc.nextInt();

                        String Updatesql= "update students set name='" + newName + "', age=" + newAge + " where id=" + updateId;
                        ;
                       Statement stmt1= con.createStatement();
                        stmt1.executeUpdate(Updatesql);
                        System.out.println("Record updated successfully");

                    break;
                
                   case 5:
                    try{
                    String sql1= "select * from students";
                     PreparedStatement stmt7=con.prepareStatement(sql1);

                     ResultSet rs = stmt7.executeQuery();
                     while(rs.next()){
                        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age") );

                     }
                    } catch(Exception e){
                        e.printStackTrace();

                    }

                    break;
                    case 3:
                        System.out.println("Enter id to delete");
                        int ids =sc.nextInt(); 
                        

                        String sql3= "delete from students where id=" + ids;
                        Statement stmt2= con.createStatement();
                        stmt2.executeUpdate(sql3);
                        System.out.println("Record deleted successfully");
                        break;
                    case 4:
                        System.out.println("Enter id to search");
                        int sId = sc.nextInt();
                        String sql4= "select * from students where id=" + sId;
                        PreparedStatement stmt3=con.prepareStatement(sql4);
                        ResultSet rs=stmt3.executeQuery(sql4);
                        while(rs.next()){
                        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
                         }
                         break;

                         default:
                         System.out.println("Invalid choice");
                         break;
                        }
        
        } while (true);




         } catch (Exception e ){
              e.printStackTrace();
         }
        
    }

}