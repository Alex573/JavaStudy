package patterns;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    public static void main(String[] args) {
        ConcretMediator concretMediator = new ConcretMediator();
        concretMediator.add(new ConcreteColegue(concretMediator));
        concretMediator.add(new ConcreteColegue(concretMediator));
        ConcreteColegue concreteColegue = new ConcreteColegue(concretMediator);
        concretMediator.add(concreteColegue);
        concreteColegue.changeStatus();
    }
}

interface Medator{
    void requestAll(Collegue collegue);
}

class ConcretMediator implements Medator{
    private List<Collegue> collegues = new ArrayList<>();
    void add(Collegue collegue){
        collegues.add(collegue);
    }

    @Override
    public void requestAll(Collegue collegue) {
        collegue.setTrue();
        for (Collegue coll : collegues){
            if (coll != collegue){
                coll.setFalse();
            }
        }
    }
}

interface Collegue{
    void setFalse();
    void setTrue();
    void changeStatus();
}

class ConcreteColegue implements Collegue{
    private boolean status;
    private Medator medator;

    ConcreteColegue(Medator medator) {
        this.medator = medator;
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println("My status is FALSE");
    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println("My status is TRUE");
    }

    @Override
    public void changeStatus() {
        medator.requestAll(this);
    }
}