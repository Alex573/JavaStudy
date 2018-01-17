package Java8;


public class DefaultStaticInter  implements A{
    public static void main(String[] args) {
        System.out.println(A.add(5, 6));
//        A a = new B();
//        a.sayHello();


    }

}
interface A {

    static int add(int x, int y){
     return  x *y;
    }

    default void sayHello(){
        System.out.println("Hello");
    }

}
class B implements A{
    @Override
    public void sayHello() {
        System.out.println("hello of b");
    }
}
