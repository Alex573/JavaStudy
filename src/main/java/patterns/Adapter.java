package patterns;

public class Adapter {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new Bmv());
        carWash.washCar(new TrackWrapper(new MyTrack()));
    }
}
class TrackWrapper implements CarW{
    Track track;
    public TrackWrapper(Track track){
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}



interface Track{
    void clean();
}

class MyTrack implements Track{

    @Override
    public void clean() {
        System.out.println("Clean track");
    }
}

interface CarW{
    void wash();
}

class Bmv implements CarW{

    @Override
    public void wash() {
        System.out.println("Wash Bmv");
    }
}
class CarWash {
    public void washCar(CarW carW) {
       carW.wash();
    }
}
