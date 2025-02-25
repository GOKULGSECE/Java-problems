package oops;

public class Child extends Base {
    public void hi(){
        System.out.println("Child");
    }
    public static void main(String args[]){
        Base b = new Child();
        b.hi();
    }
}
