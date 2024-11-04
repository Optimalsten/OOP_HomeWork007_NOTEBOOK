package HW_OOP_06_SOA.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
//import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;

public class FamilyTreeNew<T> implements Serializable, Iterable<T> {

    @Serial
    private static final long serialVersionUID = 1L;
    // Конструктор Класса FamilyTree - инициализируем Массив в поле (переменную) members для Списка Дерева
//    private List<T> members = new ArrayList<>();
    private final List<T> members;
    public FamilyTreeNew() {
        this.members = new ArrayList<>();
    }

    // Метод addMember - добавляет person в текущий экземпляр массива members c помощью метода add(),
    // public void addMember(T person) { members.add(person); }
    public void addMember(T member) {
        this.members.add(member);
    }

    // public List<Person> getMembers() { return new ArrayList<>(members); }
    public List<T> getMembers() {
    return members;
}

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    // public void sortByName() { members.sort(Comparator.comparing(Person::getName)); }
    public void sortByName() {
        members.sort(Comparator.comparing(p -> ((Person) p).getName()));
    }

    // public void sortByBirthYear() { members.sort(Comparator.comparingInt(Person::getBirthYear)); }
    public void sortByBirthYear() {
        if (members.getFirst() instanceof Person) {
            members.sort(Comparator.comparingInt(p -> ((Person) p).getBirthYear()));
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}