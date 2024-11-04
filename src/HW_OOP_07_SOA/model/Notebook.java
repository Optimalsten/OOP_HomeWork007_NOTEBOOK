package HW_OOP_07_SOA.model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Notebook {

    // Конструктор Класса Notebook - Список notes - записи блокнота
    private List<Note> notes = new ArrayList<>();

    // Метод add() - добавить запись в блокнот, сформировав ее из экз.кл.Note
    public void add(Note note) {
        notes.add(note);
    }

    // Метод getNotes - взять весь блокнот
    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    // Метод getNotesForDay - взять записи блокнота для заданного дня,
    // фильтрация - после сортировки Списка элементов по dateTime
    public List<Note> getNotesForDay(LocalDateTime dateTime) {
        return notes.stream()
                .filter(note ->
                        note.getDateTime().toLocalDate().isEqual(dateTime.toLocalDate()))
                .sorted(Comparator.comparing(Note::getDateTime))
                .collect(Collectors.toList());
    }

    // Метод getNotesForWeek - взять записи блокнота для заданной недели,
    // фильтрация - после сортировки Списка элементов по dateTime,
    // задается значение startOfWeek - начало недели
    public List<Note> getNotesForWeek(LocalDateTime startOfWeek) {
        LocalDateTime endOfWeek = startOfWeek.plusWeeks(1);
        return notes.stream()
                .filter(note ->
                        !note.getDateTime().isBefore(startOfWeek) &&
                                !note.getDateTime().isAfter(endOfWeek))
                .sorted(Comparator.comparing(Note::getDateTime))
                .collect(Collectors.toList());
    }

    // Метод saveToFile - запись в файл поэлементно Списка notes (элементов блокнота)
    // Каждая запись файла - элемент блокнота ф формате String
    // с обработкой исключений при записи
    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(fileName))) {
            for (Note note : notes) {
                writer.write(note.toString());
                writer.newLine();
            }
        }
    }

    // Метод loadFromFile - загрузка из файла поэлементно Списка notes (элементов блокнота)
    // с присвоением значений Списку notes (предварительно очищенному),
    // с конвертацией каждой записи файла в формат элемента Класса Note (dateTime, description),
    // с обработкой исключений при чтении файла.
    public void loadFromFile(String fileName) throws IOException {
        notes.clear();
        try (BufferedReader reader = new BufferedReader(new
                FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ", 2);
                LocalDateTime dateTime =
                        LocalDateTime.parse(parts[0]);
                String description = parts[1];
                notes.add(new Note(dateTime, description));
            }
        }
    }
}
