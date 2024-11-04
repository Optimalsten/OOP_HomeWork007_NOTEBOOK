package HW_OOP_06_SOA.service;

import HW_OOP_06_SOA.model.FamilyTreeNew;
import java.io.IOException;

public interface FileOperations<T> {

    void saveToFile(FamilyTreeNew<T> familyTreeNew, String fileName)
            throws IOException;
    FamilyTreeNew<T> loadFromFile(String fileName) throws IOException,
            ClassNotFoundException;
}
