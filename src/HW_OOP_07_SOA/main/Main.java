package HW_OOP_07_SOA.main;
/*
Задание. Необходимо реализовать проект, удовлетворяющий изученному материалу.
Проект содержит интерфейсы, реализован с использованием MVP паттерна,
удовлетворяет всем принципам SOLID. Создать проект с записной книжкой.
Идея в том, что пользователь может делать записи на различные дни (например,
в 19:00 стоматолог), читать записи, сохранять и загружать в файл, сортировать,
искать записи на конкретный день или неделю. Приложение должно быть консольным.

Подсказка № 1. Соблюдайте принцип единственной ответственности.
Каждый класс в вашем проекте должен иметь единую ответственность.
Например, класс Note должен только хранить данные о записи,
а класс Notebook должен управлять списком записей и обеспечивать логику работы с ними,
не занимаясь выводом данных или взаимодействием с пользователем.

Подсказка № 2. Используйте интерфейсы для обеспечения гибкости.
Интерфейс NotebookView позволяет отделить представление (вывод данных) от логики приложения.
Это означает, что вы можете легко изменить реализацию представления
(например, перейти от консольного ввода/вывода к графическому интерфейсу),
не изменяя логику в классе NotebookPresenter.

Подсказка № 3. Реализуйте методы сортировки и фильтрации в модели.
Методы для получения записей по дате и неделе (getNotesForDay() и getNotesForWeek())
должны быть реализованы в классе Notebook, так как это относится к бизнес-логике.
Не забудьте, что сортировка должна учитывать временные метки,
чтобы отображать записи в правильном порядке.

Подсказка № 4. Следуйте принципу инверсии зависимостей.
В классе NotebookPresenter не должно быть прямых зависимостей
от конкретных реализаций представления. Вместо этого используйте интерфейс NotebookView,
что позволит вам легко заменить реализацию представления, если это потребуется.

Подсказка № 5. Правильно форматируйте даты и время при вводе и выводе данных.
Используйте DateTimeFormatter для корректного преобразования LocalDateTime
в строку и обратно. Убедитесь, что формат даты и времени соответствует
ожидаемому формату при вводе и выводе данных.

Подсказка № 6. Проверьте правильность "сериализации" и "десериализации" данных.
При загрузке записей из файла убедитесь, что строки правильно разбираются
и преобразуются в объекты Note. Обратите внимание на возможные ошибки
при разборе строки и форматировании даты и времени.
*/


import java.util.Scanner;
import HW_OOP_07_SOA.model.Notebook;
import HW_OOP_07_SOA.view.NotebookView;
import HW_OOP_07_SOA.presenter.NotebookPresenter;


public class Main {
    public static void main(String[] args) {
        Notebook model = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(model, view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Note");
            System.out.println("2. Show Notes for Day");
            System.out.println("3. Show Notes for Week");
            System.out.println("4. Save Notes");
            System.out.println("5. Load Notes");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    presenter.addNote();
                    break;
                case 2:
                    presenter.showNotesForDay();
                    break;
                case 3:
                    presenter.showNotesForWeek();
                    break;
                case 4:
                    presenter.saveNotes();
                    break;
                case 5:
                    presenter.loadNotes();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
