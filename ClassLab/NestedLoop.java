package ClassLab;

import java.util.Scanner;

public class NestedLoop {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the age");
         int age=sc.nextInt();
         System.out.println("Enter the weight");
         int weight=sc.nextInt();
         if(age>=18){
            if(weight>=55){
                System.out.println("is eligable for donate");
            }
            else{
                System.out.println("low weight can't be donate blood");
            }
         }
          else{
            System.out.println("is not eligable for donate");
         }
    }
    
    
}
