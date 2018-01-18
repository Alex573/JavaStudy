package Patterns;

public class Singelton {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstance();
        Singelton singelton2 = Singelton.getInstance();
        System.out.println(singelton);
        System.out.println(singelton2);
        System.out.println(singelton2==singelton);
    }

    private static Singelton ourInstance = new Singelton();

    public static Singelton getInstance() {
        return ourInstance;
    }

    private Singelton() {
    }
}
