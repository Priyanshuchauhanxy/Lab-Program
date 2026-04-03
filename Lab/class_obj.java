class student{
    String name;
    int id;
    int age;
    
    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class class_obj {
    public static void main(String[] args) {
        student s1 = new student();
        s1.id = 1;  
        s1.name = "Alice";
        s1.age = 20;
        s1.display();

        student s2 = new student();
        s2.id = 2;
        s2.name = "Bob";
        s2.age = 22;
        s2.display();
    }
}