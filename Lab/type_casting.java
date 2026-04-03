class type_casting{
    public static void main(String[] args) {

        // Implicit type casting 
        int a = 10;
        double b = a;
       System.out.println(" int a = " + a + " is automatically cast to double b = " + b);

        // Explicit type casting
        double c = 3.14;
        int d = (int) c;
        System.out.println(" double c = " + c + " is explicitly cast to int d = " + d);
    }
}