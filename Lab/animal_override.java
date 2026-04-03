class Animal{
    void makeSound(){
        System.out.println("Some sound");
    }
}
class dog extends Animal{
    void makeSound(){
        System.out.println("Bark");
    }
}
class cat extends Animal{
    public void makeSound(){
        System.out.println("Meow");
    }
}
class animal_override{
    public static void main(String[] args) {
        dog d = new dog();
        cat c = new cat();
        for(int i=0;i<5;i++){
            d.makeSound();
            c.makeSound();  
        }
    }
}