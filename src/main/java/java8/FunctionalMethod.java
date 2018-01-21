package java8;

import java.util.function.*;

public class FunctionalMethod {

    public static void main(String[] args) {
        //Predicate  return boolean
        Predicate<Integer> predicate = x ->  x > 5;
        System.out.println(predicate.test(10));
        //Consumer   void
        Consumer<Integer> consume = x -> System.out.println(x);
        //or
        Consumer<Integer> consumer = System.out::println;
        //Function  1 enter 2 exit
        Function<Integer,String> function = x -> x.toString();
        //or
        Function<Integer,String> function2 = Object::toString;
        //Supplier
        Supplier<Integer> supplier = () -> new Integer(5);
        //UnaryOperator
        UnaryOperator<Integer> integerUnary = x -> x*x;
        //BinaryOperator
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;

        MyPredidcate<String> myHell = System.out::println;
        myHell.apply("hello");
    }

}

interface MyPredidcate<T> {
    void apply(T t);
}