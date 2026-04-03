package ClassLab;

class Student {
    int id;
    String name;

   public  Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void display() {
        System.out.println(id + " " + name);
    }
    
    
}   
public class ContructorArray {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(1, "Alice");
        students[1] = new Student(2, "Bob");
        students[2] = new Student(3, "Charlie");

        for (Student student : students) {
            student.display();
        }   
        
    }
    
}
