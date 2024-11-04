package HW_OOP_06_SOA.presenter;

import HW_OOP_06_SOA.model.Person;
import HW_OOP_06_SOA.model.FamilyTreeNew;
import HW_OOP_06_SOA.service.FileOperations;
import HW_OOP_06_SOA.view.MessageView;
import HW_OOP_06_SOA.view.PersonView;
import HW_OOP_06_SOA.view.InputView;
import java.io.IOException;

public class TreePresenter {

    // объявление приватных (почему ???) экземпляров (классов), которые передаются как параметры, в метод-конструктор
    // т.е. это поля (переменные) данного класса (которым будут присвоены значения, передаваемые ниже в качестве
    // параметров Конструктора
    private FamilyTreeNew<Person> familyTreeNew;
    private final MessageView messageView;
    private final PersonView personView;
    private final InputView inputView;
    private final FileOperations<Person> fileOperations;

    // Наш конструктор
    public TreePresenter(FamilyTreeNew<Person> familyTreeNew, MessageView messageView,
                         PersonView personView, InputView inputView, FileOperations<Person> fileOperations) {
        // здесь - присвоение полям(переменным) класса значений, которые справа (получены как параметры Конструктора)
        this.familyTreeNew = familyTreeNew;
        this.messageView = messageView;
        this.personView = personView;
        this.inputView = inputView;
        this.fileOperations = fileOperations;
    }

    // ПЕРВЫЙ МЕТОД ЭТОГО КЛАССА - addPerson(String name, int birthYear) - добавление человека (персоны)
    // public - чтобы можно было вызвать за пределами этого Класса (TreePresenter)
    public void addPerson(String name, int birthYear) {

        // при вызове метода создается новый экземпляр Класса Person в переменную person (т.е. человек)
        // с передачей экземпляру person значений полей name и birthYear для новой персоны,
        // которые указываются параметрами при вызове текущего метода addPerson.
        Person person = new Person(name, birthYear); // но персона еще не добавлена в Дерево familyTree

        // добавление созданной персоны методом addMember
        // экземпляра Класса FamilyTree<Person>, инициированного выше в поле (в переменной) familyTree
        // (куда - см. в методе)
        familyTreeNew.addMember(person); // такой формата вызова метода addMember(person) возможен,
                                      // т.к. в текущем Классе инициализирован экземпляр familyTree
                                      // Класса FamilyTree (в котором реализован метод addMember(person))

        // сообщение пользователю на устройство вывода (метод displayMessage() Интерфейса MessageView,
        // имплементированного, в составе расширения "обобщающего" Интерфейса TreeView,
        // в Классе ConsoleTreeView), что Персона name добавлена
        messageView.displayMessage("Person added: " + name);  // такой формата вызова метода displayMessage() возможен,
                                      // т.к. в текущем Классе инициализирован экземпляр messageView
                                      // Класса MessageView (в котором реализован метод displayMessage())
    }

    // ВТОРОЙ МЕТОД ЭТОГО КЛАССА - showAllPersons() - вывод на устройство вывода (метод displayPersons()
    // Интерфейса MessageView, имплементированного, в составе расширения "обобщающего" Интерфейса TreeView,
    // в Классе ConsoleTreeView) ДАННЫХ, получаемых в метод displayPersons() в качестве параметра,
    // public - чтобы можно было вызвать за пределами этого класса (TreePresenter)
    public void showAllPersons() {
        // по сути, однозначное и единственное предназначение этого метода showAllPersons(),
        // реализованного в текущем Классе TreePresenter в составе КОНТРОЛЛЕРА (package presenter),
        // - это вызов метода displayPersons(), реализованного в Интерфейсе PersonView в составе БЛОКА VIEW
        // (интерфейсный package view), в котором, в свою очередь, задача вывода при обращении ЗДЕСЬ, в КОНТРОЛЛЕРЕ,
        // решается методом getMembers() (Список), реализованного в классе FamilyTree, в составе МОДЕЛИ (package model)
        // и вызываемого ЗДЕСЬ в инициализированном экземпляре этого класса - familyTree
        personView.displayPersons(familyTreeNew.getMembers());  // такой формата вызова метода displayPersons() возможен,
                                      // т.к. в текущем Классе инициализирован экземпляр personView
                                      // Класса PersonView (в котором реализован метод displayPerson())
    }

    // ТРЕТИЙ МЕТОД ЭТОГО КЛАССА - sortPersonsByName() - сортировка Списка Персон по именам
    // (с помощью метода sortByName() из Класса FamilyTree, в составе МОДЕЛИ (package model),
    // вызываемого здесь, в текущем методе, с помощью экземпляра familyTree класса FamilyTree,
    // а также вывод на устройство вывода:
    // 1) сообщения пользователю о выполненной сортировке по именам - вызов метода messageView.displayMessage();
    // 2) Списка Персон (после сортировки) - вызов ВТОРОГО МЕТОД ЭТОГО КЛАССА - showAllPersons()
    // public - чтобы можно было вызвать за пределами этого класса (TreePresenter)
    public void sortPersonsByName() {

        familyTreeNew.sortByName();      // такой формата вызова метода sortByName() возможен,
                                      // т.к. в текущем Классе инициализирован экземпляр familyTree
                                      // Класса FamilyTree (в котором реализован метод sortByName())

        // сообщение пользователю на устройство вывода (метод displayMessage() Интерфейса MessageView,
        // имплементированного, в составе расширения "обобщающего" Интерфейса TreeView,
        // в Классе ConsoleTreeView), что Список Персон отсортирован по имени
        messageView.displayMessage("Persons sorted by name:"); // такой формата вызова метода displayMessage()
                                      // возможен, т.к. в текущем Классе инициализирован экземпляр messageView
                                      // Класса MessageView (в котором реализован метод displayMessage())

        // вывод Списка Персон (после сортировки) - вызов ВТОРОГО МЕТОД ЭТОГО КЛАССА - showAllPersons(), см. выше
        showAllPersons();             // такой формата вызова метода showAllPersons()
                                      // возможен, т.к. он реализован в текущем Классе
    }

    // ЧЕТВЕРТЫЙ МЕТОД ЭТОГО КЛАССА - sortPersonsByBirthYear() - сортировка Списка Персон по году рождения
    // (с помощью метода sortByBirthYear() из Класса FamilyTree, в составе МОДЕЛИ (package model),
    // вызываемого здесь, в текущем методе, с помощью экземпляра familyTree Класса FamilyTree,
    // а также вывод на устройство вывода:
    // 1) сообщения пользователю о выполненной сортировке по году/р - вызов метода messageView.displayMessage();
    // 2) Списка Персон (после сортировки) - вызов ВТОРОГО МЕТОД ЭТОГО КЛАССА - showAllPersons()
    // public - чтобы можно было вызвать за пределами этого класса (TreePresenter)
    public void sortPersonsByBirthYear() {

        familyTreeNew.sortByBirthYear(); // такой формата вызова метода sortByBirthYear() возможен,
                                      // т.к. в текущем Классе инициализирован экземпляр familyTree
                                      // Класса FamilyTree (в котором реализован метод sortByBirthYear())

        // сообщение пользователю на устройство вывода (метод displayMessage() Интерфейса MessageView,
        // имплементированного, в составе расширения "обобщающего" Интерфейса TreeView,
        // в Классе ConsoleTreeView), что Список Персон отсортирован по году рождения
        messageView.displayMessage("Persons sorted by birth year:");

        // вывод Списка Персон (после сортировки) - вызов ВТОРОГО МЕТОД ЭТОГО КЛАССА - showAllPersons(), см. выше
        showAllPersons();             // такой формата вызова метода showAllPersons()
                                      // возможен, т.к. он реализован в текущем Классе
    }

    // ПЯТЫЙ МЕТОД ЭТОГО КЛАССА - saveTree(String fileName) - запись в файл с заданным в параметре именем fileName
    // текущего экземпляра familyTree Класса FamilyTree, с помощью метода saveToFile(),
    // переопределенного в Классе FileOperationsImpl, имплементирующем Интерфейс FileOperations<Person>
    // (в составе СЕРВИСА (package service)), вызываемого здесь, в текущем методе,
    // с помощью экземпляра fileOperations Интерфейса FileOperations<Person>, а также вывод на устройство вывода
    // сообщения пользователю о выполненной записи Дерева в файл ... - вызов метода messageView.displayMessage();
    // кроме того, реализована обработка Исключений (ошибок) - IOException - с выводом сообщения об ошибке и ее типе
    // public - чтобы можно было вызвать за пределами этого класса (TreePresenter)
    public void saveTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTreeNew, fileName); // тип метода saveToFile() - void
                                      // такой формата вызова метода saveToFile() возможен,
                                      // т.к. в текущем Классе инициализирован экземпляр fileOperations
                                      // Интерфейса FileOperations, который имплементирован в Классе FileOperationsImpl
                                      // (в котором реализован метод saveToFile())
            messageView.displayMessage("Family tree saved to " + fileName);

        } catch (IOException e) {
            messageView.displayMessage("Error saving family tree: " + e.getMessage());
        }
    }

    // ШЕСТОЙ МЕТОД ЭТОГО КЛАССА - loadTree(String fileName) - чтение из файла с заданным в параметре именем fileName
    // и присвоение (возврат из метода) текущему экземпляру familyTree Класса FamilyTree, данных из файла,
    // с помощью метода loadFromFile(), переопределенного в Классе FileOperationsImpl,
    // имплементирующем Интерфейс FileOperations<Person> (в составе СЕРВИСА (package service)), вызываемого здесь,
    // в текущем методе, с помощью экземпляра fileOperations Интерфейса FileOperations<Person>,
    // а также вывод на устройство вывода сообщения пользователю о выполненной загрузке Дерева из файла ...
    // - вызов метода messageView.displayMessage();
    // кроме того, реализована обработка Исключений (ошибок) - IOException - с выводом сообщения об ошибке и ее типе
    // public - чтобы можно было вызвать за пределами этого класса (TreePresenter)
    public void loadTree(String fileName) {
        try {
            familyTreeNew = fileOperations.loadFromFile(fileName); // тип метода loadFromFile() - не void (возврат рез-та)
            // в связи с этим не решена проблема корректного возврата при обработанной ошибке;
            // такой формата вызова метода loadFromFile() возможен,
            // т.к. в текущем Классе инициализирован экземпляр fileOperations
            // Интерфейса FileOperations, который имплементирован в Классе FileOperationsImpl
            // (в котором реализован метод loadFromFile())
            messageView.displayMessage("Family tree loaded from " + fileName);

        } catch (IOException | ClassNotFoundException e) {
            messageView.displayMessage("Error loading family tree: " + e.getMessage());
        }
    }

    // СЕДЬМОЙ МЕТОД ЭТОГО КЛАССА - handleCommand(String command) - логика взаимодействия Контроллера
    // с методами БЛОКА VIEW, МОДЕЛИ, СЕРВИСА.
    // Вопрос по методу addPerson (и используемому в нем методу addMember) - его необходимо определить в МОДЕЛИ
    public void handleCommand(String command) {
        switch (command) {
            case "add":
                messageView.displayMessage("Enter name:");
                String name = inputView.getUserInput();
                messageView.displayMessage("Enter birth year:");
                int birthYear = Integer.parseInt(inputView.getUserInput());
                addPerson(name, birthYear);
                break;
            case "list":
                showAllPersons();
                break;
            case "sortByName":
                sortPersonsByName();
                break;
            case "sortByBirthYear":
                sortPersonsByBirthYear();
                break;
            case "save":
                messageView.displayMessage("Enter file name:");
                saveTree(inputView.getUserInput());
                break;
            case "load":
                messageView.displayMessage("Enter file name:");
                loadTree(inputView.getUserInput());
                break;
            case "exit":
                System.exit(0);
            default:
                messageView.displayMessage("Unknown command");
        }
    }

}
