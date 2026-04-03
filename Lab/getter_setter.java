class  simple{
    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
class getter_setter {
    public static void main(String[] args) {
        simple s = new simple();
        s.setNumber(10);
        s.setName("John");
        System.out.println("Number: " + s.getNumber());
        System.out.println("Name: " + s.getName()); 
    }
   
}