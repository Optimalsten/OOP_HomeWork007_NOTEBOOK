package HW_OOP_06_SOA.main;

/*
Рефакторинг проекта с семейным деревом с учетом принципов SOLID.

Подсказка № 1. Принципы SOLID и их применение:
1. Single Responsibility Principle (SRP):
   Каждый класс должен иметь одну ответственность.
2. Open/Closed Principle (OCP):
   Классы должны быть открыты для расширения, но закрыты для модификации.
3. Liskov Substitution Principle (LSP):
   Объекты должны быть заменяемы их подтипами без изменения правильности программы.
4. Interface Segregation Principle (ISP):
   Клиенты не должны зависеть от интерфейсов, которые они не используют.
5. Dependency Inversion Principle (DIP):
   Зависимости должны быть инвертированы,
   т.е. Модули высшего уровня не должны зависеть от модулей низшего уровня,
   а обе группы должны зависеть от абстракций.

Подсказка № 2. Разделение интерфейсов (ISP).
Разделите интерфейс TreeView на несколько специализированных интерфейсов
(MessageView, PersonView, InputView), каждый из которых будет отвечать
только за один аспект взаимодействия с пользователем.
Убедитесь, что класс ConsoleTreeView реализует все необходимые интерфейсы,
чтобы сохранить полную функциональность,
но без излишней зависимости от ненужных методов.

Подсказка № 3. Избавление от сложной логики в Presenter (SRP).
Перенесите логику обработки команд и ввода пользователя
из TreePresenter в отдельный класс, например, CommandHandler.
Это позволит TreePresenter сосредоточиться на управлении данными и бизнес-логике.
Убедитесь, что CommandHandler берет команды из TreeView и делегирует их TreePresenter,
сохраняя код чистым и разделенным по ответственности.

Подсказка № 4. Инверсия зависимостей (DIP).
Убедитесь, что TreePresenter и другие классы зависят от абстракций,
а не от конкретных реализаций. Например,
TreePresenter должен зависеть от интерфейсов MessageView, PersonView и InputView,
а не от конкретной реализации ConsoleTreeView.
Проверьте, что TreePresenter и другие классы используют интерфейсы
для взаимодействия с внешними сервисами (например, FileOperations),
чтобы можно было легко подменить реализации без изменения основной логики.

Подсказка № 5. В Main-Классе создайте и свяжите все компоненты,
следуя новым интерфейсам и классам.
Убедитесь, что все зависимости инжектируются правильно.
Используйте конструкторы для передачи зависимостей,
а не жестко кодируйте их в классе.
 */

import HW_OOP_06_SOA.model.FamilyTreeNew;
import HW_OOP_06_SOA.model.Person;
import HW_OOP_06_SOA.presenter.CommandHandler;
import HW_OOP_06_SOA.presenter.TreePresenter;
import HW_OOP_06_SOA.service.FileOperationsImpl;
import HW_OOP_06_SOA.view.ConsoleTreeView;

public class Main {
    public static void main(String[] args) {
// (static) - это означает... (main) всегда (static).
// В Java классы являются основой OOP. Классы определяют объекты, их свойства и методы.
// Но методы и свойства класса могут быть не только общими для всех объектов класса, но и относиться к самому классу.
// Такие методы и свойства называются статическими.
// Когда запускаете программу на Java, виртуальная машина Java (JVM) не создает экземпляр класса,
// в котором находится метод main. Она просто ищет этот метод и запускает его. Если бы метод main не был статическим,
// JVM было бы необходимо создать экземпляр класса, прежде чем вызвать метод (main). Это создало бы доп/сложности.
// Таким образом, метод main в Java является статическим, чтобы обеспечить простоту запуска программы.
// Это позволяет JVM вызвать метод main без необходимости создавать экземпляр класса.

        // создание экземпляра класса FamilyTree
        // Тип параметра для Класса FamilyTree - <Person>.
        FamilyTreeNew<Person> familyTreeNew = new FamilyTreeNew<>();

        // создание нового экземпляра класса ConsoleTreeView (во view)
        // Смотри на скобки в конце.
        ConsoleTreeView view = new ConsoleTreeView();

        // Аналогично - экземпляр Класса
        // смотри на скобки в конце
        FileOperationsImpl<Person> fileOperations = new FileOperationsImpl<>();

        // эк.кл.(параметры)
        TreePresenter presenter = new TreePresenter(familyTreeNew, view, view, view, fileOperations);

        // эк.кл.(параметры)
        CommandHandler commandHandler = new CommandHandler(presenter, view);

        // идеальный вариант для метода main - точка входа - инициализация основных классов и вызов головного метода
        // из Пакета 'presenter' (контроллер программы, принципы MVC, который используется как посредник).
        commandHandler.handleUserInput();
    }
}
