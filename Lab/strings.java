
import java.util.Scanner;

class strings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string");
        String str=sc.next();
        //String str="tops technologies";
        //String s= "a";
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u'){
                count++;

            }
        }
        System.out.println("the number of total vowels is "+count);
        
    }
}