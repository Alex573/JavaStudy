package patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Facadedles {
    public static void main(String[] args) throws IOException {
        FileReadFacade readFacade = new FileReadFacade();
        System.out.println(readFacade.readerFile("temp.txt"));
    }
}
class FileReadFacade{
    String readerFile (String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while ((j = br.read()) != -1){
            sb.append((char)j);
        }
        return sb.toString();
    }
}
