package patterns;

public class State {
    public static void main(String[] args) {
        Context context = new Context(new LowerCaseStat(),"AleX");
        context.action();
        context.setStates(new UpperCaseStat());
        context.action();
    }
}

interface States {
    void doAction(Context context);
}

class UpperCaseStat implements States {

    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}

class LowerCaseStat implements States {

    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}

class Context {
    private States states;
    String name;

    Context(States states, String name) {
        this.states = states;
        this.name = name;
    }

    public void setStates(States states) {
        this.states = states;
    }

    void action() {
        states.doAction(this);
    }
}
