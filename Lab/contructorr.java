class student {
    String name;
    int age;

    student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class contructorr {
    public static void main(String[] args) {
        student s1 = new student("Alice", 20);
        s1.display();
    }
}