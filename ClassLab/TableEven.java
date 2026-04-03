package ClassLab;
import java.util.Scanner;
public class TableEven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter a number: ");   
        int num=sc.nextInt();

        if(num % 2 == 0){
            for(int i=0;i<=10;i++){
                System.out.println(num + " x "+i+" = "+(num*i));
            }
            
        }
        else{
            System.out.println("number is not even so table is not possible");
    
    }
    }
}
