package ClassLab;

import java.util.Scanner;

public class AddTwoMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][];
        int arr2[][];
        int sum[][];
        System.out.println("enter the row and column");
        arr=new int[sc.nextInt()][sc.nextInt()];
        System.out.println("enter the row and column for 2nd matrix");
// 
        arr2=new int[sc.nextInt()][sc.nextInt()];
        sum=new int[arr.length][arr[0].length];// third matrix ko initialize krna hai
        System.out.println("enter the element of first matrix");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println("enter the element :" +"["+i+"]"+"["+j+"]");
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter the element of second matrix");
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2[i].length;j++){
                System.out.println("enter the element :" +"["+i+"]"+"["+j+"]");
                arr2[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                sum[i][j]=arr[i][j]+arr2[i][j];// third matrix ke element ko first matrix ke element + second matrix ke element se initialize krna hai
            }
        }
        System.out.println("sum of the two matrices:");
        for(int i=0;i<sum.length;i++){
            for(int j=0;j<sum[i].length;j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }   
// 
    }
}
// 
