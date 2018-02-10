package patterns;

public class Decorator {
    public static void main(String[] args) {
        FileStream fileStream = new FileBufferefReader(new FileStreamReader());
        fileStream.read();
    }
}
interface FileStream{
    void read();
}
class FileStreamReader implements FileStream{

    @Override
    public void read() {
        System.out.println("read file");
    }
}
abstract class FileDecorater implements FileStream{
    FileStream fileStream;

    FileDecorater(FileStream fileStream) {
        this.fileStream = fileStream;
    }
    public abstract void read();
}
class FileBufferefReader extends FileDecorater{
    FileBufferefReader(FileStream fileStream) {
        super(fileStream);
    }

    @Override
    public void read() {
        fileStream.read();
        System.out.println("buffered read");
    }
}