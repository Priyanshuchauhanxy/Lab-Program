package ClassLab;

import java.util.Scanner;
class Employee
{
    int em_id;
    String name;
    int salary;
    
    public void setdetail(int id ,String namee ,int salaryy){
        em_id=id;
        name=namee;
        salary=salaryy;
    }
    
    public void display(){
        if(salary>20000){
            System.out.println(em_id+"-" +name+"- "+salary+"- ");
        }
        else{
            System.out.println("low salary");
        }
    }
}
public class EmployeeClassExample {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Employee emp = new Employee();
            System.out.println("enter the empdetails");
            emp.setdetail(sc.nextInt(), sc.next(), sc.nextInt());

            emp.display();
            
        }

        
    }

