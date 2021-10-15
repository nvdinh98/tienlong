package storage;

import model.LibraryCard;

import java.io.*;
import java.util.ArrayList;

public class LibraryCardFile {
    public static ArrayList<LibraryCard> readFile() throws IOException, ClassNotFoundException {
        File file = new File("libraryCardList.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            ArrayList<LibraryCard> list = (ArrayList<LibraryCard>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public static void writeFile(ArrayList<LibraryCard> students) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("libraryCardList.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
