
import java.io.FileWriter;
import java.util.Scanner;

class filewriter
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            String str= "heloo heeloo";
        FileWriter writer = new FileWriter("C:\\Users\\DELL\\OneDrive\\文档\\Java_Prg\\Lab\\constructor_overloading.java");
        //byte [] ar= str.getBytes();
        writer.write(str);
        writer.flush();
         }
          catch (Exception e) {
    }
}
}