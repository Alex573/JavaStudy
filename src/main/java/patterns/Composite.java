package patterns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Composite {
    public static void main(String[] args) {

    }
}
class Folder{
    String name;
    Date creationDate;
    //strom
    List<Folder> folders = new ArrayList<>();
    //leaf
    List<Filess> files = new ArrayList<>();
    public Folder(String name) {
        this.name = name;
    }
    void addFolder(Folder folder){
        folders.add(folder);
    }
    void removeFolder(Folder folder){
        folders.remove(folder);
    }
    List<Folder> getFolders(){
        return folders;
    }
    void addFiless(Filess file){
        files.add(file);
    }
    void removeFiless(Filess file){
        files.remove(file);
    }
    List<Filess> getFiles(){
        return files;
    }
}
class Filess{
    String filename;

}
