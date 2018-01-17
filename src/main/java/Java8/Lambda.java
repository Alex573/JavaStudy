package Java8;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Lambda {
    public static void main(String[] args) {
        //java7

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("hello");
            }
        };
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
            }
        };
        //Java 8
        Runnable runnable8 = ()-> System.out.println("hello");

        Runnable runnable88 = ()-> {System.out.println("hello");
            System.out.println("helo");};
        String s = "hello"; //java 8 not write final
        ActionListener actionListene8 = (e) -> System.out.println(s);
        ActionListener actionListene88 = (e) -> System.out.println(e.paramString());


        Thread t = new Thread(() -> {
            System.out.println("go");
        });



    }
}
