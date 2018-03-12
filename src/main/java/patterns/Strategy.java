package patterns;

public class Strategy {
    public static void main(String[] args) {
        double startprice = 100;
        ContextStrategy contextStrategy = new ContextStrategy(new HalfPrice());
        double price = contextStrategy.getPrice(startprice);
        System.out.println(price);
        contextStrategy = new ContextStrategy(new FullPrice());
        price = contextStrategy.getPrice(startprice);
        System.out.println(price);


    }
}

interface Strategys {
    double getPrice(double price);
}

class FullPrice implements Strategys {
    @Override
    public double getPrice(double price) {
        return price;
    }
}

class HalfPrice implements Strategys {
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}

class ContextStrategy implements Strategys {
    private Strategys strategys;

    ContextStrategy(Strategys strategys) {
        this.strategys = strategys;
    }

    @Override
    public double getPrice(double price) {
        return strategys.getPrice(price);
    }

}

