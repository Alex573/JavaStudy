package Patterns;

public class Factory {
    public static void main(String[] args) {
        NewFactory newFactory = new NewFactory();

        Car toyota = newFactory.create("Toyota");
        toyota.drive();

        Car audi = newFactory.create("Audi");
        audi.drive();
    }
}
interface Car{
    void drive();
}
class Toyota implements Car{
    @Override
    public void drive() {
        System.out.println("Toyota");
    }
}

class Audi implements Car{
    @Override
    public void drive() {
        System.out.println("Audi");
    }
}

class NewFactory{
    public Car create(String typeCar){
        switch (typeCar){
            case "Toyota":return new Toyota();
            case "Audi":return new Audi();
            default:return null;
        }

    }
}
