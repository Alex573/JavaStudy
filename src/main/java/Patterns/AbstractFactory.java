package Patterns;

public class AbstractFactory {
    public static void main(String[] args) {
        AbsFactory carFactory = new AstractFactory().createFactory("Car");
        AbsFactory  tankFactory = new AstractFactory().createFactory("Tank");
        CarA toyota = carFactory.createCarA("Toyota");
        CarA audi = carFactory.createCarA("Audi");
        toyota.drive();
        audi.drive();
        Tank hellcat = tankFactory.createTank("Hellcat");
        Tank pantera = tankFactory.createTank("Pantera");
        hellcat.drive();
        pantera.drive();


    }

}
interface CarA{
    void drive();
}
class ToyotaA implements CarA{
    @Override
    public void drive() {
        System.out.println("Toyota");
    }
}

class AudiA implements CarA{
    @Override
    public void drive() {
        System.out.println("Audi");
    }
}

class CarFactoryA implements AbsFactory {
    public CarA createCarA(String typeCar) {
        switch (typeCar) {
            case "Toyota": return new ToyotaA();
            case "Audi": return new AudiA();
            default: return null;
        }

    }

    @Override
    public Tank createTank(String type) {
        return null;
    }
}
interface Tank{
    void drive();
}
class Hellcat implements Tank{
    @Override
    public void drive() {
        System.out.println("Hellcat");
    }
}

class Pantera implements Tank{
    @Override
    public void drive() {
        System.out.println("Pantera");
    }
}

class TankFactory implements AbsFactory{
    @Override
    public CarA createCarA(String type) {
        return null;
    }

    public Tank createTank(String typeTank) {
        switch (typeTank) {
            case "Hellcat": return new Hellcat();
            case "Pantera": return new Pantera();
            default:
                return null;
        }

    }
}
interface AbsFactory{
    CarA createCarA(String type);
    Tank createTank(String type);
}
class AstractFactory{
    AbsFactory createFactory(String typeFactory){
        switch (typeFactory){
            case "Car":return new CarFactoryA();
            case "Tank":return new TankFactory();
            default:return null;
        }
    }
}