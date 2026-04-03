class A{
    void display(){
        System.out.println("This is class A");
    }
}
class B extends A{
    
}
class single_inheritance{
    public static void main(String[] args) {
        B b = new B();
        b.display();
        
        

    }
}