class  pratical{
    // public static void main(String[] args) {
    public  boolean  arrays(){
        // 
        int a[]={1,4,3,5,7,8,9};
        int b[]={1,4,3,5,7,8,9};
        int count=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j]){
                    System.out.println(a[i]);
                    b[j]=-1;   
                    count++;
                    break;
                    
                }

            }
           
        }
         if(count==b.length){
                return true;
            }
            else{
                return false;   
            }   
            
    }
    }
