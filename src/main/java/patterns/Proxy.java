package patterns;

public class Proxy {
    public static void main(String[] args) {
        CarP car = new CarProxy();
        car.drive();
    }
}

interface CarP{
    void drive();
}

class CarProxy implements CarP{
    CarP car = new Renault();
    @Override
    public void drive() {
        System.out.println("Proxy code");
        car.drive();
    }
}
class Renault implements CarP{

    @Override
    public void drive() {
        System.out.println("drive reno");
    }
}