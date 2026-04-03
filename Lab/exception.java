// class invalidAgeException extends Exception{
    //  invalidAgeException(){
        // System.out.println("age is not valid");
    // }   
// }
// 
// class exception{
    // public static void main(String[] args) throws invalidAgeException {
        // int age=19;
        // if(age<18){
            // throw new invalidAgeException();
        // }
        // else
        // {
            // System.out.println("welcome to vote");
        // }
    // }
// 
// }


class invalidAgeException extends Exception{
     invalidAgeException(){
        System.out.println("age is not valid");
    }   
}
class exception{
    public static void main(String[] args) {
        int age=19;
        try{
            if(age<18){
                throw new invalidAgeException();
            }
            else
            {
                System.out.println("welcome to vote");
            }
        }
        catch(invalidAgeException e){
            System.out.println(e);
        }
    }
}