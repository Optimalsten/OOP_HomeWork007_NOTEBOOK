package HW_OOP_07_SOA.model;

import java.time.LocalDateTime;

import HW_OOP_07_SOA.model.Notebook;
import HW_OOP_07_SOA.view.NotebookView;
import HW_OOP_07_SOA.main.ConsoleNotebookView;
import HW_OOP_07_SOA.presenter.NotebookPresenter;

public class Note {

    // Конструктор Класса Note
    private LocalDateTime dateTime;
    private String description;

    public Note(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    // Метод определения значения поля dateTime для текущего экз.кл. Note
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Метод определения значения поля description для текущего экз.кл. Note
    public String getDescription() {
        return description;
    }

    // Переопределение toString() - формирование для текущего экз.кл. Note
    // соответствующего элемента/записи блокнота (значение в формате String)
    // для последующих операций ввода/вывода
    @Override
    public String toString() {
        return dateTime.toString() + ": " + description;
    }
}
