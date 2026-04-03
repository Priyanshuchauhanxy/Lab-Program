import java.io.FileInputStream;

public class fileread{
    public static void main(String[] args) {
        try {
            FileInputStream fils = new FileInputStream("C:\\Users\\DELL\\OneDrive\\文档\\Java_Prg\\Lab\\constructor_overloading.java");
            byte [] i = new byte[100];
            int off = 0;
            int len = i.length;
            int bytesRead =fils.read(i, off, len);
            int option1=fils.read();
            int option2=fils.read(i);
            
            System.out.println(option1);
            System.out.println(option2);
            System.out.println("Bytes read: " + bytesRead);
            System.out.println("Data read from file:");
            System.out.println(new String(i, 0, bytesRead));// yeh byte array ko string me convert krke print kr dega, 0 se start hoke bytesRead tk print kr dega, taki jitna data read hua hai utna hi print ho, baki null character print nahi honge.
            fils.close();             
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    
    }

}