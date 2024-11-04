package HW_OOP_06_SOA.view;

import HW_OOP_06_SOA.model.Person;
import HW_OOP_06_SOA.presenter.TreePresenter;
import java.util.List;
import java.util.Scanner;

// Класс ConsoleTreeView имплементирует интерфейс TreeView, расширенный в свою очередь
// интерфейсами MessageView, PersonView, InputView, которые должны быть определены в этом классе

public class ConsoleTreeView implements TreeView {

    // объявление приватного (почему ???) экземпляра класса TreePresenter в поле(переменной) presenter
    private TreePresenter presenter;

    // объявление приватного (почему ???) экземпляра класса Scanner
    // в поле(переменной) scanner для ввода-вывода
    private Scanner scanner;

    // и здесь сразу конструктор, инициализирующий текущее значение новой переменной scanner
    public ConsoleTreeView() {
        this.scanner = new Scanner(System.in);
    }


    // Д А Л Е Е  -  И Д У Т   М Е Т О Д Ы, которые должны быть определены для имплементированного Ингтерфейса TreeView
    // с учетом его расширения интерфейсами MessageView, PersonView, InputView.

    // Переопределение метода displayMessage, предназначенного для вывода сообщения из строковой
    // переменной message на устройство вывода (скорее всего - Display), который был ранее (изначально) "заявлен"
    // в абстрактном методе (интерфейсе) MessageView, который был имплементирован в настоящий класс ConsoleTreeView
    // (как расширение имплементированного для данного класса интерфейса TreeView),
    // и должен быть здесь конкретно ОПРЕДЕЛЕН... в варианте, необходимом для данного класса.
    // И это вывод на экран (монитор компа) сообщения для пользователя)
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Переопределение метода displayPersons, предназначенного для вывода списка персон (List) из текущего Списка
    // persons на устройство вывода (скорее всего - Display), который был ранее (изначально) "заявлен"
    // в абстрактном методе (интерфейсе) PersonView, который был имплементирован в настоящий класс ConsoleTreeView
    // (как расширение имплементированного для данного класса интерфейса TreeView),
    // и должен быть здесь конкретно ОПРЕДЕЛЕН... в варианте, необходимом для данного класса.
    // И это вывод на экран (монитор компа) Списка персон в цикле for each)
    @Override
    public void displayPersons(List<Person> persons) {
        for (Person person : persons) {
            // методы getName() и getBirthYear() класса person возвращают строковые значения
            // Имени и Года рождения соответственно для текущей позиции Списка persons (которая в поле person - в цикле)
            System.out.println(person.getName() + ", born in " + person.getBirthYear());
        }
    }

    // Переопределение метода getUserInput(), предназначенного для приема того (строкового формата), что пользователь
    // введет с устройства ввода (скорее всего Console), который был ранее (изначально) "заявлен"
    // в абстрактном методе (интерфейсе) InputView, который был имплементирован в настоящий класс ConsoleTreeView
    // (как расширение имплементированного для данного класса интерфейса TreeView),
    // и должен быть здесь конкретно ОПРЕДЕЛЕН... в варианте, необходимом для класса Scanner.
    // И это здесь получение с клавиатуры компа новой Персоны (ее 2-ух полей).
    @Override
    public String getUserInput() {
        // Метод nextLine() определен в классе Scanner (см. то, что объявлено выше перед Классом, забирает ввод с комп.
        return scanner.nextLine();
    }

    // Переопределение метода setPresenter (предназначенного для связи с Контроллером, который ранее (изнач.) "заявлен"
    // в абстрактном методе (интерфейсе) TreeView, который был имплементирован в настоящий класс ConsoleTreeView
    // (как расширение имплементированного для данного класса интерфейса TreeView),
    // и должен быть здесь конкретно ОПРЕДЕЛЕН... в варианте, необходимом для класса Scanner.
    // И это здесь задание в переменную presenter текущего класса presenter

    @Override
    public void setPresenter(TreePresenter presenter) {
        this.presenter = presenter;
    }
}
