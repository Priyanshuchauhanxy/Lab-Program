package ClassLab;


 abstract class Bank
  {
    int amount;
     abstract double getInterestRate();   
  }

  class SBI extends Bank
  {

    public SBI(int amountt){
        amount=amountt; 
    }
    public double getInterestRate()
    {
        return amount*0.8;
  } 
}
class Axis extends Bank
  { 
    public Axis(int amounttt){
        amount=amounttt; 
    }
    public double getInterestRate()
    {
        return  amount* 0.9;
  } 
}   


public class AbtractBankIntrest {
    public static void main(String[] args) {
        SBI sbi = new SBI(10000);
        Axis axis = new Axis(50000);
        System.out.println("SBI Interest Rate: " + sbi.getInterestRate());
        System.out.println("Axis Interest Rate: " + axis.getInterestRate());    


    }
}
