package ClassLab;
import java.util.Scanner;

//4.pattern 
//  ****
//  ***
//  **
//  *


// class pattern {
//     public static void main(String [] args){
//         Scanner sc= new Scanner(System.in);
//         System.out.println("enter the num");
//         int num=sc.nextInt();
    
//         for(int i=1;i<=num;i++){
//             for(int j=i;j<=num;j++){
            

//             System.out.print(" *");  
//             }
//             System.out.println(" ");
              

//         }

//     }
// }


// 3.pattern
// *
// **
// ***
// ****

// class pattern {
//     public static void main(String [] args){
//         Scanner sc= new Scanner(System.in);
//         System.out.println("enter the num");
//         int num=sc.nextInt();
    
//         for(int i=1;i<=num;i++){
//             for(int j=1;j<=i;j++){
            

//                 System.out.print(i);
//             }
//             System.out.println(" ");
              

//         }

//     }
// }


//2.pattern
// 1
// 22
// 333
// 4444


// class pattern {
//     public static void main(String [] args){
//         Scanner sc= new Scanner(System.in);
//         System.out.println("enter the num");
//         int num=sc.nextInt();
    
//         for(int i=1;i<=num;i++){
//             for(int j=1;j<=i;j++){
            

//                 System.out.print(j);
//             }
//             System.out.println(" ");
              

//         }

//     }
// }


//5.pattern 
// 1
// 3 5
// 7 9 11
// 13 15 17

// class pattern {
//     public static void main(String [] args){
//         Scanner sc= new Scanner(System.in);
//         System.out.println("enter the num");
//         int num=sc.nextInt();
//         int k=1;
//         for(int i=1;i<=num;i++){
//             for(int j=1;j<=i;j++){
            

//                 System.out.print(k+" ");
//                 k+=2;
//             }
//             System.out.println(" ");
              

//         }

//     }
// }

//6.pattern print the pattern of abcd
// A
// B C 
// D E F
// G H I J

// class pattern {
//     public static void main(String [] args){
//         Scanner sc= new Scanner(System.in);
//         System.out.println("enter the num");
//         int num=sc.nextInt();
//         char alpha='A';
//         for(int i=1;i<=num;i++){
//             for(int j=1;j<=i;j++){
            

//                 System.out.print(alpha+" ");
//                 alpha++;
//             }
//             System.out.println(" ");
              

//         }

//     }
// }


// 7.pattern
//      *
//     **
//    ***
//  *****

// class pattern{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("enter the num");
//         int num = sc.nextInt(); 

//         for(int i =1;i<=num;i++)
//         {
//             for(int j=1;j<=num-i;j++)
//             {
//                 System.out.print(" ");
//             }
//             for(int k=1;k<=i;k++)
//             {
//                 System.out.print("*");
//             }
//             System.out.println();
//         }

//     }
// }


// 8.pattern

// ****
// ***
// **
// *
// **
// ***
// ****

// class pattern{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("enter the number");
//         int no=sc.nextInt();
//         int j;
//         for(int i=1;i<=no*2-1;i++){
           
//                 if(i<=no){
//                      for( j=i;j<=no;j++){

//                        System.out.print("*");
//                      }
//                      System.err.println(" ");

//             }
//             else{
//                 for(j=1;j<=i-no+1;j++){
//                     System.out.print("*");
//                 }
//             System.out.println("");

//             }
//              }
//             System.out.println(" ");
//         }
//     }

//9.pattern
// ****
// *  *
// *  *
// ****

// class pattern{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int num=sc.nextInt();
//         for(int i =1;i<=num;i++){
//             for(int j =1;j<=num;j++){
//             if(i==1 || j==num || j==1 || i==num){
//                 System.out.print("*");
//             }
//             else{
//                 System.out.print(" ");
//             }
//             }
//             System.out.println(" ");
//         }
//     }
// }


// class pattern{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int range=sc.nextInt();
//         int a =0;
//         int b =1;
//         int c;
//         for(int i=0;i<=range;i++){
//               System.out.println("fibonacci : " + a);
//             c=a+b;
//             a=b;
//             b=c; 
           
//         }

        
//     }
// }



// class pattern{
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         int num=sc.nextInt();
//         int ans=1;

//         for(int i=1;i<=num;i++){
//              ans*=i;
//         }
//         System.out.println(ans);
//     }
// }