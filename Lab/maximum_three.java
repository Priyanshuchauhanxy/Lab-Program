
class maximum{
    public int max(int a,int b,int c){
        if(a>b && a>c){
            return a;
        }
        else if(b>a && b>c){
            return b;
        }
        else{
            return c;
        }   
    }

}
class maximum_three {
    public static void main(String[] args) {
        maximum m = new maximum();
        int result = m.max(10, 20, 30);
        System.out.println("The maximum number is: " + result);
    }


        
    }
