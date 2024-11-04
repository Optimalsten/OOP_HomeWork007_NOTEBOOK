package HW_OOP_06_SOA.model;

import java.io.Serializable;

public class Person implements Serializable {

    private final String name;
    private final int birthYear;

    // Конструктор Класса Person
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    // Метод геттер - getName() - взять (получить) имя в экземпляре Класса Person
    public String getName() {
        return name;
    }

    // Метод геттер - getBirthYear() - взять (получить) год рождения в экземпляре Класса Person
    public int getBirthYear() {
        return birthYear;
    }
}
