
import java.io.FileOutputStream;

public class filewrite {
    public static void main(String[] args) {
        try{
            String str= "hello hello";
        
        FileOutputStream files= new FileOutputStream("C:\\Users\\DELL\\OneDrive\\文档\\Java_Prg\\Lab\\constructor_overloading.java");
        byte[] b = str.getBytes();
        files.write(b);
       
        
       
 
        
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
