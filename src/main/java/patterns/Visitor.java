package patterns;

public class Visitor {
    public static void main(String[] args) {
        Animala animala = new Dog();
        animala.doJob(new ConcrettVisitor());
        Animala cat = new Cat();
        cat.doJob(new ConcrettVisitor());
    }
}

interface Animala {
    void doJob(Visitors visitors);
}

class Dog implements Animala {

    @Override
    public void doJob(Visitors visitors) {
        visitors.doDog();
    }
}

class Cat implements Animala {

    @Override
    public void doJob(Visitors visitors) {
        visitors.doCat();
    }
}

interface Visitors {
    void doDog();

    void doCat();
}

class ConcrettVisitor implements Visitors {

    @Override
    public void doDog() {
        System.out.println("Hav");
    }

    @Override
    public void doCat() {
        System.out.println("Miy");
    }
}