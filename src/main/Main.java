package main;
/*
Продолжаем работать с проектом с семейным деревом.
Реализовать интерфейс Iterable для дерева.
Создать методы сортировки списка людей перед выводом,
например по имени или по дате рождения (не менее 2).
Создать пакетную структуру для проекта.

Подсказка № 1. Для того чтобы класс FamilyTree поддерживал итерацию,
реализуйте интерфейс Iterable<Person> и переопределите метод iterator().
В этом методе вы можете вернуть итератор списка people,
что позволит использовать объекты FamilyTree в циклах for-each.

Подсказка № 2. Реализуйте методы sortByName() и sortByBirthYear()
в классе FamilyTree для сортировки списка people.
Используйте класс Collections и методы sort,
передавая компараторы для сортировки по имени или году рождения.
Это позволит вам легко сортировать данные перед их выводом.

Подсказка № 3. Разделите классы по функциональным пакетам, например,
model для моделей данных,
service для классов, реализующих функциональность,
и main для точки входа.
Это улучшит читаемость и поддерживаемость кода.

Подсказка № 4. После вызова методов сортировки (например,
sortByName() или sortByBirthYear()), проверьте,
что список людей действительно отсортирован.
Используйте for-each цикл для вывода данных, чтобы убедиться,
что сортировка прошла успешно.
 */

import model.FamilyTree;
import service.FileOperations;
import service.FileOperationsImpl;
import model.Person;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

// Создаем людей

// Правильный по времени порядок закомментируем

        Person bill = new Person("Bill", 1920);
        Person katrin = new Person("Katrin", 1925);

        Person martin = new Person("Martin", 1925);
        Person luisa = new Person("Luisa", 1930);

        Person jack = new Person("Jack", 1945);

        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);

        Person betti = new Person("Betti", 1985);

// Устанавливаем родительские связи
        jack.setMother(katrin);
        jack.setFather(bill);
        bill.addChild(jack);
        katrin.addChild(jack);

        john.setMother(katrin);
        john.setFather(bill);
        bill.addChild(john);
        katrin.addChild(john);

        mary.setMother(luisa);
        mary.setFather(martin);
        martin.addChild(mary);
        luisa.addChild(mary);

        susan.setMother(mary);
        susan.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);

// Добавляем людей в древо (первый вариант (в хронологическом порядке) закомментирован)

//        familyTree.addPerson(bill);
//        familyTree.addPerson(katrin);
//        familyTree.addPerson(martin);
//        familyTree.addPerson(luisa);
//
//        familyTree.addPerson(jack);
//
//        familyTree.addPerson(john);
//        familyTree.addPerson(mary);
//        familyTree.addPerson(susan);
//
//        familyTree.addPerson(betti);

// Зададим (добавим) людей в более произвольном порядке, а не в хронологическом порядке
// - для проверки сортировки

        familyTree.addPerson(jack);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);

        familyTree.addPerson(martin);
        familyTree.addPerson(luisa);

        familyTree.addPerson(bill);
        familyTree.addPerson(katrin);

        familyTree.addPerson(betti);

// Создаем объект для работы с файлами
        FileOperations fileOps = new FileOperationsImpl();

// Сохраняем генеалогическое древо в файл
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("\nFamily tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

// Загружаем генеалогическое древо из файла
        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree = fileOps.loadFromFile("familyTree.dat");
            System.out.println("\nFamily tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

// Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            System.out.println("\nLoaded persons:");
            for (Person person : loadedFamilyTree) {
                System.out.println(person.getName() + ", born in " + person.getBirthYear());
            }
        }

// Сортируем по имени
        System.out.println("\nСортировка по имени:");
        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " + person.getBirthYear());
        }

// Сортируем по дате рождения
        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthYear();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " + person.getBirthYear());
        }
    }
}