package ClassLab;

import java.util.Scanner;

public class TwoDArrayMultiTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][];
        System.out.println("enter the row and column");
        arr=new int[sc.nextInt()][sc.nextInt()];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println("enter the element :" +"["+i+"]"+"["+j+"]");
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]*2+" ");
            }
            System.out.println();
        }
    }
}
