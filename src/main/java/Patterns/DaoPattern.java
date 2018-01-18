package Patterns;

public class DaoPattern {
    static Data  data = new FileSys();
    public static void main(String[] args) {
        System.out.println(data.getData());
    }
}
interface Data{
    String getData();
}

class Db implements Data{
    String getFromTable(){
        return "data from table";

    }

    @Override
    public String getData() {
        return getFromTable();
    }
}
class FileSys implements Data{
    String getFromFS(){
        return "data from file system";

    }

    @Override
    public String getData() {
        return getFromFS();
    }
}
