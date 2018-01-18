package Java9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TrywithResourse {
    public static void main(String[] args) throws FileNotFoundException {
        //8
        try(OutputStream outputStream = new FileOutputStream("text.txt")) {
            outputStream.write('a');
        } catch (IOException e) {
            e.printStackTrace();
        }
        //9
        OutputStream outputStream = new FileOutputStream("text.txt");
        try(outputStream) {
            outputStream.write('a');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
