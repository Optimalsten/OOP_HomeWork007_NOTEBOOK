package HW_OOP_02_SOA;
/*
Задание 1. Дополнить проект методами записи в файл и чтения из файла.
Для этого создать отдельный класс и реализовать в нем нужные методы.
Для данного класса сделайте интерфейс, который и используйте в своей программе.
Пример работы с интерфейсом Serialazable можно найти в материалах к уроку.

Подсказка № 1. Начните с создания интерфейса, который будет содержать методы для сохранения
и загрузки данных. Это поможет вам отделить логику работы с файлами от основной логики приложения
и сделает код более гибким для дальнейшего расширения или изменения.

Подсказка № 2. Используйте сериализацию для сохранения объектов.
Класс Person и FamilyTree должны реализовывать интерфейс Serializable.
Это позволит сохранять объекты в файл и загружать их обратно, сохраняя их структуру.
Не забудьте добавить поле serialVersionUID, чтобы избежать проблем при десериализации.

Подсказка № 3. Реализуйте методы интерфейса в отдельном классе.
Создайте класс, который будет реализовывать методы интерфейса для записи и чтения из файла.
В методе saveToFile используйте ObjectOutputStream, чтобы сериализовать и сохранить объект в файл,
а в методе loadFromFile используйте ObjectInputStream для десериализации.

Подсказка № 4. Проверьте обработку исключений. Операции записи и чтения из файла
могут вызвать исключения, такие как IOException и ClassNotFoundException.
Убедитесь, что эти исключения правильно обрабатываются в вашем коде.
 */


import java.io.*;

// Главный класс с точкой входа

public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

// Создаем людей
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

// Добавляем людей в древо
        familyTree.addPerson(bill);
        familyTree.addPerson(katrin);
        familyTree.addPerson(martin);
        familyTree.addPerson(luisa);

        familyTree.addPerson(jack);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);

        familyTree.addPerson(betti);

// Создаем объект для работы с файлами
        FileOperations fileOps = new FileOperationsImpl();

// Сохраняем генеалогическое древо в файл
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("Family tree saved to file.");


        } catch (IOException e) {
            e.printStackTrace();
        }

// Загружаем генеалогическое древо из файла
        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("familyTree.dat");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

// Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            for (Person person : loadedFamilyTree.getPeople()) {
                System.out.println("Loaded person: " +
                        person.getName() + ", born in " + person.getBirthYear());
            }
        }
    }
}
