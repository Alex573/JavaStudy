package patterns;

public class Template {
    public static void main(String[] args) {
        Templates templates = new Job();
        templates.run();
    }
}

abstract class Templates {
    abstract void stepOne();

    abstract void stepTwo();

    abstract void stepThree();

    void run() {
        stepOne();
        stepTwo();
        stepThree();
    }
}

class Job extends Templates {

    @Override
    void stepOne() {
        System.out.println("first step");
    }

    @Override
    void stepTwo() {
        System.out.println("two step");

    }

    @Override
    void stepThree() {
        System.out.println("three step");

    }
}