package patterns;

import java.util.HashMap;
import java.util.Map;

public class FlyWeight {
    public static void main(String[] args) {

        FlyWeightGarage flyWeightGarage = new FlyWeightGarage();
        Jeep jeep = flyWeightGarage.getJeep("Green");
        Jeep jeep2 = flyWeightGarage.getJeep("Green");
        System.out.println(jeep);
        System.out.println(jeep2);
    }
}
class Jeep{
    String color;
}

class FlyWeightGarage{
    Map<String,Jeep> map = new HashMap<>();
    Jeep getJeep(String color){
        Jeep jeep = map.get(color);
        if (jeep == null){
            jeep = new Jeep();
            jeep.color = color;
            map.put(color,jeep);
        }
        return jeep;
    }
}

