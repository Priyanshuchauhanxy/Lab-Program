package ClassLab;
class vehicle {
   int price;
   String color;
   String modelname;

    public vehicle(int price, String color, String modelname) {
        this.price = price;
        this.color = color;
        this.modelname = modelname;
    }
}
public class ClassExample {
    public static void main(String[] args) {
        vehicle v1 = new vehicle(100000, "red", "BMW");
        vehicle v2 = new vehicle(50000, "blue", "Audi");

        System.out.println("Vehicle 1: Price: " + v1.price + ", Color: " + v1.color + ", Model: " + v1.modelname);
        System.out.println("Vehicle 2: Price: " + v2.price + ", Color: " + v2.color + ", Model: " + v2.modelname);
        
    }
    
    
}
