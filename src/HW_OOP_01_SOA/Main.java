package HW_OOP_01_SOA;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

// Создаем людей
        Person bill = new Person("Bill", 1920);
        Person katrin = new Person("Katrin", 1925);

        Person martin = new Person("Martin", 1925);
        Person luisa = new Person("Luisa", 1930);

        Person jeck = new Person("Jeck", 1945);

        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);

        Person betti = new Person("Betti", 1985);


// Устанавливаем родительские связи

        jeck.setMother(katrin);
        jeck.setFather(bill);
        bill.addChild(jeck);
        katrin.addChild(jeck);

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

        familyTree.addPerson(jeck);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);

        familyTree.addPerson(betti);

// Пример получения всех детей Джона

        List<Person> billsChildren = familyTree.getChildren(bill);
        for (Person child : billsChildren) {
            System.out.println("Bill's child: " + child.getName());
        }
        List<Person> katrinsChildren = familyTree.getChildren(katrin);
        for (Person child : katrinsChildren) {
            System.out.println("Katrin's child: " + child.getName());
        }

        List<Person> martinsChildren = familyTree.getChildren(martin);
        for (Person child : martinsChildren) {
            System.out.println("Martin's child: " + child.getName());
        }
        List<Person> luisasChildren = familyTree.getChildren(luisa);
        for (Person child : luisasChildren) {
            System.out.println("Luisa's child: " + child.getName());
        }

        List<Person> jecksChildren = familyTree.getChildren(jeck);
        for (Person child : jecksChildren) {
            System.out.println("Jeck's child: " + child.getName());
        }

        List<Person> johnsChildren = familyTree.getChildren(john);
        for (Person child : johnsChildren) {
            System.out.println("John's child: " + child.getName());
        }
        List<Person> marysChildren = familyTree.getChildren(mary);
        for (Person child : marysChildren) {
            System.out.println("Mary's child: " + child.getName());
        }
    }
}