package patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterLes {
    public static void main(String[] args) {
        CarF carF = new CarF(150,"green",4);
        CarF carF2 = new CarF(160,"black",2);
        CarF carF3 = new CarF(130,"yellow",1);
        CarF carF4 = new CarF(200,"white",2);
        List<CarF> cars = new ArrayList<>();
        cars.add(carF);
        cars.add(carF2);
        cars.add(carF4);
        cars.add(carF3);
      //  cars = new SpeedFilter().filter(cars);
       // cars = new SpeedFilter().filter(new DoorsFilter().filter(cars));
//        AndFilter andFilter = new AndFilter(new SpeedFilter(),new DoorsFilter());
//        cars = andFilter.filter(cars);
        OrFilter orFilter = new OrFilter(new SpeedFilter(),new DoorsFilter());
        cars = orFilter.filter(cars);

        System.out.println(cars);
    }
}
interface CarFilter{
    List<CarF> filter(List<CarF> cars);
}
class SpeedFilter implements CarFilter{
    @Override
    public List<CarF> filter(List<CarF> cars) {
        return  cars.stream().filter((e)-> e.getMaxSpeed() >= 150).collect(Collectors.toList());
    }
}
class DoorsFilter implements CarFilter{
    @Override
    public List<CarF> filter(List<CarF> cars) {
        return  cars.stream().filter((e)-> e.getDoors() > 2).collect(Collectors.toList());
    }
}
class AndFilter implements CarFilter{
    private CarFilter filterOne;
    private CarFilter filterTwo;

    public AndFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        return filterOne.filter(filterTwo.filter(cars));
    }
}
class OrFilter implements CarFilter{
    private CarFilter filterOne;
    private CarFilter filterTwo;

    public OrFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);
        List<CarF> list2 = filterTwo.filter(cars);
        for (CarF carF : list2) {
            if (!list.contains(carF)){
                list.add(carF);
            }
        }
        return list;



    }
}

class CarF{
    public CarF(int maxSpeed, String color, int doors) {
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.doors = doors;
    }

    private int maxSpeed;
    private String color;
    private int doors;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDors(int dors) {
        this.doors = dors;
    }

    @Override
    public String toString() {
        return "CarF{" +
                "maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                ", dors=" + doors +
                '}';
    }
}
