package HW_OOP_07_SOA.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import HW_OOP_07_SOA.model.Note;
import HW_OOP_07_SOA.view.NotebookView;

public class ConsoleNotebookView implements NotebookView {

    private final Scanner scanner = new Scanner(System.in);

    // Определяем метод showNotes() вывода списка (который в поле notes) на у/вывода
    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            for (Note note : notes) {
                System.out.println(note);
            }
        }
    }

    // Определяем метод showMessage() вывода сообщения Пользователю (диалогового) на у/вывода
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Определяем метод getDateTimeInput() диалога с Пользователем
    // для ввода даты и времени события/элемента блокнота (поле каждого элемента/записи блокнота)
    // в заданном формате - возвращает значение в формате LocalDateTime
    // (например - '2007-12-03T10:15:30'), что облегчает сортировку.
    @Override
    public LocalDateTime getDateTimeInput() {
        System.out.println("Enter date and time (yyyy-MM-dd'T'HH:mm):");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(input, formatter);
    }

    // Определяем метод getDescriptionInput() диалога с Пользователем
    // для ввода описания события/элемента блокнота (поле каждого элемента/записи блокнота).
    // Возвращает значение в формате String
    @Override
    public String getDescriptionInput() {
        System.out.println("Enter note description:");
        return scanner.nextLine();
    }

    // Определяем метод getFileNameInput() диалога с Пользователем
    // для ввода имени файла, которое (пока) будет использоваться при определении
    // файла записи или загрузки блокнота на/из внешнее устройство/память.
    // Возвращает значение в формате String
    @Override
    public String getFileNameInput() {
        System.out.println("Enter file name:");
        return scanner.nextLine();
    }
}
