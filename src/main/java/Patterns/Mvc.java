package Patterns;

public class Mvc {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.execute();
    }
}
class StudentT{
    private String name = "Max";
    private int age = 30;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentT{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

interface ModelLayer{
    StudentT getStudentT();
}
class DBLayer implements ModelLayer{
    @Override
    public StudentT getStudentT() {
        return new StudentT();
    }
}
class FileLayer implements ModelLayer{
    @Override
    public StudentT getStudentT() {
        return new StudentT();
    }
}

class Controller{
    ModelLayer modelLayer = new DBLayer();
    View view = new ConsoleView();
    void execute(){
        StudentT studentT = modelLayer.getStudentT();
        view.showStudentT(studentT);
    }
}
interface  View{
     void showStudentT(StudentT studentT);

}
class ConsoleView implements View{

    @Override
    public void showStudentT(StudentT studentT) {
        System.out.println(studentT);
    }
}
class HtmlView implements View{

    @Override
    public void showStudentT(StudentT studentT) {
        System.out.println("<html><body>"+studentT+"</html><body>");
    }
}

