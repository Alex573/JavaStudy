package patterns;

public class Bridge {
    public static void main(String[] args) {
    ICar kiaSedan = new SedanCar(new Kia());
    kiaSedan.showDetails();
    ICar hondaCoupe = new CoupeCar(new Honda());
    hondaCoupe.showDetails();



    }
}
abstract class ICar{
    Make make;

    public ICar(Make make) {
        this.make = make;
    }

    public abstract void showDetails();
}


interface Make{void setMake();}

class Kia implements Make{
    @Override
    public void setMake() {
        System.out.println("Kia");
    }
}
class Honda implements Make{
    @Override
    public void setMake() {
        System.out.println("Honda");
    }
}

class SedanCar extends ICar{

    public SedanCar(Make make) {
        super(make);
    }

    @Override
    public void showDetails() {
        System.out.println("Sedan");
        make.setMake();
    }
}
class CoupeCar extends ICar{


    public CoupeCar(Make make) {
        super(make);
    }

    @Override
    public void showDetails() {
        System.out.println("Coupe");
        make.setMake();
    }
}
