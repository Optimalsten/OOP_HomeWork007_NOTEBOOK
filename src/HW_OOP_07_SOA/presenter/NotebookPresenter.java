package HW_OOP_07_SOA.presenter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import HW_OOP_07_SOA.model.Note;
import HW_OOP_07_SOA.model.Notebook;
import HW_OOP_07_SOA.view.NotebookView;
import HW_OOP_07_SOA.main.ConsoleNotebookView;


public class NotebookPresenter {

    // Конструктор Presenter - экз.кл. модели (Notebook) и представления (NotebookView)
    private Notebook model;
    private NotebookView view;

    public NotebookPresenter(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    // метод addNote() - добавление элемента в блокнот, вызов метода в Main,
    // внутри метода явно вызываются методы:
    // 1. getDateTimeInput() - диалог с Пользователем и ввод даты и времени события/элемента блокнота,
    //    задан в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    // 2. getDescriptionInput() - диалог с Пользователем и описания события/элемента блокнота,
    //    задан в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    // 3. add() - добавить запись в блокнот, сформировав ее из экз.кл.Note (параметры - в скобках),
    //    задан  и определен прямо в Классе Notebook (model - экз. класса).
    // 4. showMessage() - вывод сообщения Пользователю (диалогового) на у/вывода, задан
    //    в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    public void addNote() {
        LocalDateTime dateTime = view.getDateTimeInput();
        String description = view.getDescriptionInput();
        model.add(new Note(dateTime, description));
        view.showMessage("Note added.");
    }

    // метод showNotesForDay() - предъявить Пользователю записи блокнота для заданного им дня,
    // вызов метода в Main, внутри метода явно вызываются методы:
    // 1. getDateTimeInput() - диалог с Пользователем и ввод даты и времени для выборки событий/элементов блокнота,
    //    задан в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    // 2. getNotesForDay() - взять записи блокнота для заданного дня (параметр dateTime - в скобках),
    //    задан  и определен прямо в Классе Notebook (model - экз. класса).
    // 3. showMessage() - вывод сообщения Пользователю (диалогового) на у/вывода, задан
    //    в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    public void showNotesForDay() {
        LocalDateTime dateTime = view.getDateTimeInput();
        List<Note> notes = model.getNotesForDay(dateTime);
        view.showNotes(notes);
    }

    // метод showNotesForWeek() - предъявить Пользователю записи блокнота для заданной им недели,
    // вызов метода в Main, внутри метода явно вызываются методы:
    // 1. getDateTimeInput() - диалог и ввод начала недели (даты и времени) для выборки событий/элементов блокнота,
    //    задан в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    // 2. getNotesForWeek() - взять записи блокнота для заданной недели (параметр startOfWeek - в скобках),
    //    задан  и определен прямо в Классе Notebook (model - экз. класса).
    // 3. showMessage() - вывод сообщения Пользователю (диалогового) на у/вывода, задан
    //    в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    public void showNotesForWeek() {
        LocalDateTime startOfWeek = view.getDateTimeInput();
        List<Note> notes = model.getNotesForWeek(startOfWeek);
        view.showNotes(notes);
    }

    // метод saveNotes() - запись блокнота в текущем состоянии в файл с именем, заданным Пользователем
    // вызов метода в Main, внутри метода явно вызываются методы:
    // 1. getFileNameInput() - диалог и ввод имени файла от Пользователя, с у/ввода (здесь - клавиатуры),
    //    задан в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    // 2. saveToFile() - запись блокнота в файл с заданным именем (параметр fileName - в скобках),
    //    задан и определен прямо в Классе Notebook (model - экз. класса).
    // 3. showMessage() - вывод сообщения Пользователю (диалогового) на у/вывода по результату, задан
    //    в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    public void saveNotes() {
        String fileName = view.getFileNameInput();
        try {
            model.saveToFile(fileName);
            view.showMessage("Notes saved to " + fileName);
        } catch (IOException e) {
            view.showMessage("Failed to save notes: " + e.getMessage());
        }
    }

    // метод loadNotes() - загрузка блокнота (для работы приложения) из файл с именем, заданным Пользователем
    // вызов метода в Main, внутри метода явно вызываются методы:
    // 1. getFileNameInput() - диалог и ввод имени файла от Пользователя, с у/ввода (здесь - клавиатуры),
    //    задан в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    // 2. loadFromFile() - загрузка блокнота из файла с заданным именем (параметр fileName - в скобках)
    //    задан и определен прямо в Классе Notebook (model - экз. класса).
    // 3. showMessage() - вывод сообщения Пользователю (диалогового) на у/вывода по результату, задан
    //    в Интерфейсе NotebookView (view - экз. интерфейса), переопределен в ConsoleNotebookView
    public void loadNotes() {
        String fileName = view.getFileNameInput();
        try {
            model.loadFromFile(fileName);
            view.showMessage("Notes loaded from " + fileName);
        } catch (IOException e) {
            view.showMessage("Failed to load notes: " + e.getMessage());
        }
    }
}
