package ClassLab;
import java.util.Scanner;

class FrequencyCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("length ");
        int num[]= new int[sc.nextInt()];

        
    
          
        for (int i = 0; i < num.length; i++) {
          num[i]=sc.nextInt();
         // Arrays.sort(num);
        }                                   // 10.20.20.40.50
        for (int i = 0; i < num.length; i++) {
            int count=1;
            int skips=0;

            for(int k=0;k<i;k++){
                if(num[i]==num[k]){
                    skips=1;
                    break;
                }
            }
            if(skips==1){
                continue;
            }

            for(int j=i+1;j<num.length;j++){
                if(num[i]==num[j]){
                    count++;

                }
            }
            System.out.println(num[i]+" : >"+count);

        }
    

    }
}