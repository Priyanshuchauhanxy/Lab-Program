
import java.util.Scanner;

class MenuDriven{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
       do{ System.out.println("Enter the choice \n 1. check prime \n 2. count digits \n 3.sum of digits \n 4.ccount even and odd digits \n 5.exit");
              choice=sc.nextInt();
       
            switch(choice){


                case 1:
                     System.out.println("Enter the number");
                      int num=sc.nextInt();
                      int i =2;
                      int count=0;
                      for ( i=2; i <num; i++) {
                        if(num%i==0){
                        count=0;
                        System.out.println("not a prime");
                        break;   
                        }
                        else{
                         count=1;
                        }
                     }
                     if (count==1){
                         System.out.println("prime");
                       }

                break;


                case 2:
                    System.out.println("Enter the number");
                     num=sc.nextInt();
                     count=0;
                     while(num>0){
                        num=num/10;
                        count++;
                     }
                     System.out.println("The count of digits is : " + count);
                
                    break;
                case 3:
                    System.out.println("Enter the number");
                     num=sc.nextInt();
                     int ans=num*(num+1)/2;
                     System.out.println(ans);
                    break;
                case 4:
                      System.out.println("Enter the number");
                      num=sc.nextInt();
                      int rem;
                        count=0;
                     int even_count=0;
                     int odd_count=0;
                     while(num>0){
                     rem=num%10;
       
                     if(rem%2==0){
        
                      even_count++;
       
                       }
                      else{
      
                     odd_count++;
                       }
                       num=num/10;
                        count++;

                       }

                           System.out.println("The count of digits is : "+ count+"\n" +"The count of even digits is : " + even_count+"\n"+"The count of odd digits is : " + odd_count);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
       }while(choice!=5);
        }
    }

