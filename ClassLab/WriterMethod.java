package ClassLab;

import java.io.FileWriter;

public class WriterMethod {
    public static void main(String[] args) {
        try{    
            FileWriter files= new FileWriter("C:\\Users\\DELL\\OneDrive\\文档\\Java_Prg\\Lab\\constructor_overloading.java");
            files.write("hello hello");
            files.flush();
            files.close();
            System.out.println("success");
        }catch(Exception e){
            e.printStackTrace();            
        }
    }
    
}
