package patterns;

public class ChainOfResposebility {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();
        messagePrinter.setNexMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNexMessagePrinter(new DBMessagePrinter());
        messagePrinter.print("Hello");
    }
}
abstract class MessagePrinter{
    MessagePrinter nexMessagePrinter;

    public void setNexMessagePrinter(MessagePrinter messagePrinter) {
        nexMessagePrinter = messagePrinter;
    }

    public void print(String message){
        printMessage(message);
        if (nexMessagePrinter != null){
            nexMessagePrinter.print(message);
        }

    }
    abstract void printMessage(String message);
}
class ConsoleMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("print to console: " + message);
    }
}
class FileMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("print to file: " + message);
    }
}
class DBMessagePrinter extends MessagePrinter{

    @Override
    void printMessage(String message) {
        System.out.println("print to database: " + message);
    }
}
