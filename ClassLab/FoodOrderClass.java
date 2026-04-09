package ClassLab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class FoodItem{
    int iteamID;
    String name;
    int price;

    public FoodItem(int id ,String namee ,int pricee){
        iteamID=id;
        name=namee;
        price=pricee;
    }
    void display(){
        System.out.println(iteamID+"-"+name+"-"+price);
    }
   
}
  class Order{
    int orderID;
    List<FoodItem> foodItems;
    int totalAmount=0;

    public Order() {
        foodItems = new ArrayList<>();
    }


    void additem(FoodItem item){
        foodItems.add(item);

    }

    void CalculateTotal(){
        for(FoodItem item:foodItems){
            totalAmount+=item.price;
        }
    
    }

    void displayOrder(){
        System.out.println("Order ID: "+orderID);
        System.out.println("Food Items:");
        for(FoodItem item:foodItems){
            item.display();
        }
        System.out.println("Total Amount: "+totalAmount);
    }

  }
  class Customer{
    int customerID;
    String name;
   List<Order> orders;

   public Customer(int customerID, String name) {
       this.customerID = customerID;
       this.name = name;
       orders = new ArrayList<>();
   }

   void placeOrder(Order order){
    orders.add(order);
   }
   void viewOrders(){
    for(Order order:orders){
        order.displayOrder();
    }
   }
  }

 class Restaurant{
    List<FoodItem> menu;
    Map<Integer,Customer> customers;

    public Restaurant() {
        menu = new ArrayList<>();
        customers = new HashMap<>();
    }
    void addFoodItem(FoodItem item){
        menu.add(item);
    }
    void registerCustomer(Customer customer){
        customers.put(customer.customerID,customer);
    }
   void   displaymenu(){
        for(FoodItem item : menu){
            item.display();
          }
    }
    void FindIteammbyID(int id){
        for(FoodItem item : menu){
            if(item.iteamID==id){
                item.display();
            }
        }
    }
    void createOrder(int customerID){
        Customer customer=customers.get(customerID);
        if(customer!=null){
            Order order=new Order();
            order.CalculateTotal();
            customer.placeOrder(order);
            System.out.println("Order placed successfully!");
        }
        else{
            System.out.println("Customer not found!");
        }
    }
    void displayAllOrders(){
        for(Customer customer:customers.values()){
            customer.viewOrders();
        }
    }
}


public class FoodOrderClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        do { 
            System.out.println("Welcome to the Food Ordering System ");
             System.out.println(" 1. Add Food item");
             System.out.println("2. View menu");
             System.out.println("3. Register Customer");
             System.out.println("4. Place Order");
             System.out.println("5. View Customer Order ");
             System.out.println("6. Search Food item ");
             System.out.println("7. Exit");
             int Choice = sc.nextInt();
          


              switch (Choice) {
                  case  1:
                        System.out.println("Enter the number of food items to add:");
                        int quantity = sc.nextInt();
                        for (int i = 0; i < quantity; i++) {
                            System.out.println("Enter food item details: id, name, price  "+ (i+1)+"/" + quantity  );
                            int id = sc.nextInt();
                            String name = sc.next();
                            int price = sc.nextInt();
                            FoodItem foodItem = new FoodItem(id, name, price);
                        restaurant.addFoodItem(foodItem);
                        }
                       
                        System.out.println("Food item added successfully!");
                        break;
                  case 2:
                        System.out.println("Menu:");
                        restaurant.displaymenu();
                        break;
                  case 3:
                        System.out.println("Enter customer details: id, name");
                        int custId = sc.nextInt();
                        String custName = sc.next();
                        Customer customer = new Customer(custId, custName);
                        restaurant.registerCustomer(customer);
                        System.out.println("Customer registered successfully!");
                        break;
                  case 4:
                        System.out.println("Enter customer ID to place order:");
                        int orderCustId = sc.nextInt();
                        restaurant.createOrder(orderCustId);
                        break;
                  case 5:
                        restaurant.displayAllOrders();
                        break;
                  case 6:
                        System.out.println("Enter food item ID to search:");
                        int searchId = sc.nextInt();
                        restaurant.FindIteammbyID(searchId);
                        break;
                  case 7:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                        break;
                  default:
                      System.out.println("Invalid choice. Try again.");
              }


            
        } while (true);
}
}