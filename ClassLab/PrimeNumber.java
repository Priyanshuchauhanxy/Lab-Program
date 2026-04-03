package ClassLab;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        int count = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                count = 0;
                System.out.println("not a prime");
                break;
            } else {
                count = 1;
            }
        }
        if (count == 1) {
            System.out.println("prime");
        }
        
    }
    
}
