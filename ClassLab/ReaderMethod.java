package ClassLab;

import java.io.FileReader;

public class ReaderMethod {
    public static void main(String[] args) {
        try{
        FileReader files= new FileReader("C:\\Users\\DELL\\OneDrive\\文档\\Java_Prg\\Lab\\constructor_overloading.java");
            
        files.read();
        
        char[] c = new char[100];
        files.read(c);
        System.out.println(c);
        int off = 0;
        int len = c.length;  
        files.read(c, off, len);
        System.out.println(c);
        files.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
    
}
