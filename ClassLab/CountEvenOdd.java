package ClassLab;
import java.util.Scanner;

class CountEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num=sc.nextInt();
        int rem;
        int count=0;
        int even_count=0;
        int odd_count=0;
       while(num>0){
        rem=num%10;
       // System.out.println("rem"+rem);
       if(rem%2==0){
        
        even_count++;
       
       }
       else{
        // System.out.println("The odd digit is : " + rem);
        odd_count++;
       }
        num=num/10;
        count++;
        
       // System.out.println("num"+num);
    

       }

         System.out.println("The count of digits is : "+ count+"\n" +"The count of even digits is : " + even_count+"\n"+"The count of odd digits is : " + odd_count);
        //  System.out.println("The count of odd digits is : " + odd_count);
        //  System.out.println("The count of digits is : " + count);



        
        
    }
}