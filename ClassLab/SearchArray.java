package ClassLab;

import java.util.Scanner;

public class SearchArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");            
        int arr[] = new int[sc.nextInt()];
        System.out.println("Enter the elements of the array");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            
        }

        System.out.println("Enter the number to be searched");
        int target = sc.nextInt();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count = 1;
                System.out.println("number is found at index: " + i);
                break;
            } else {
                count = 0;
            }
        }
        if (count == 0) {
            System.out.println("number is not found");
        }
    }
}
