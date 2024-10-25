package HW_OOP_02_SOA;

import java.io.*;

// Интерфейс для операций с файлами

public interface FileOperations {

    void saveToFile(FamilyTree familyTree, String fileName) throws
            IOException;
    FamilyTree loadFromFile(String fileName) throws IOException,
            ClassNotFoundException;
}
