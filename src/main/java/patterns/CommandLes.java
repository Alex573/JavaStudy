package patterns;

import java.util.ArrayList;
import java.util.List;

public class CommandLes {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        receiver.addCommand(new MouseClick());
        receiver.addCommand(new MousePress());
        receiver.runCommand();
    }
}
interface Command{
    void execute();
    void revert();
}
class MouseClick implements Command{

    @Override
    public void execute() {
        System.out.println("Click mouse");
    }

    @Override
    public void revert() {
        System.out.println("click revert");
    }
}
class MousePress implements Command{
    @Override
    public void execute() {
        System.out.println("Press mouse");
    }

    @Override
    public void revert() {
        System.out.println("mouse revert");
    }
}
class Receiver{
    List<Command> commandList = new ArrayList<>();
    void addCommand(Command command){
        commandList.add(command);
    }
    void runCommand(){
        try {
            for (Command command : commandList) {
                command.execute();
            }
        }catch (Exception e){
            for (Command command : commandList) {
                command.revert();
            }
        }
    }
}
