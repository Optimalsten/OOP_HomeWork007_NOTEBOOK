package HW_OOP_06_SOA.service;

import HW_OOP_06_SOA.model.FamilyTreeNew;
import java.io.*;

public class FileOperationsImpl<T> implements FileOperations<T> {

    @Override
    public void saveToFile(FamilyTreeNew<T> familyTreeNew, String
            fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream(fileName))) {
            oos.writeObject(familyTreeNew);
        }
    }

    @Override
    public FamilyTreeNew<T> loadFromFile(String fileName) throws
            IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream(fileName))) {
            return (FamilyTreeNew<T>) ois.readObject();
        }
    }
}
