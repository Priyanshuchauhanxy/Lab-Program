package ClassLab;

import java.util.Scanner;


class ArrayAccessdingOrder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("length ");
        int num[]= new int[sc.nextInt()];

        
    
          System.out.println("enter the element");
        for (int i = 0; i < num.length; i++) {
        
          num[i]=sc.nextInt();
        }

        for (int i = 0; i < num.length; i++) {        //i take 2 5 3 1 after swapp 1,5,3,2
            for(int j =i+1;j<num.length;j++)
            {
                if(num[i]>num[j]){
                    int temp=num[i];
                    num[i]=num[j];
                    num[j]=temp;
                }
            }
            System.out.println("acceding : "+ num[i]);

            
        }
    }
}

