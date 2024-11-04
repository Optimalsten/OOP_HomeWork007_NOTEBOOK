package HW_OOP_07_SOA.view;

import java.time.LocalDateTime;
import java.util.List;
import HW_OOP_07_SOA.model.Note;

public interface NotebookView {

    // Определяем методы интефейса NotebookView
    // (для последующей имплементации в ConsoleNotebookView)

    void showNotes(List<Note> notes);

    void showMessage(String message);

    LocalDateTime getDateTimeInput();

    String getDescriptionInput();

    String getFileNameInput();
}
