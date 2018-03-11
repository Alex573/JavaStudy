package patterns;

public class Momento {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("one");
        CareTaker careTaker = new CareTaker();
        careTaker.setMomentos(originator.createMomentos());
        originator.setState("two");
        originator.getDataFromMomento(careTaker.getMomentos());
        System.out.println(originator.getState());


    }
}

class CareTaker {
    Momentos momentos;

    public Momentos getMomentos() {
        return momentos;
    }

    public void setMomentos(Momentos momentos) {
        this.momentos = momentos;
    }
}

class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    Momentos createMomentos() {
        return new Momentos( state );
    }

    void getDataFromMomento(Momentos momentos) {
        this.state = momentos.getState();
    }

}

class Momentos {
    private String state;

    Momentos(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
