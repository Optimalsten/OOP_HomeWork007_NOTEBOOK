package HW_OOP_06_SOA.view;

// Это публичный интерфейс PersonView, единственная ответственность которого
// - вывод с помощью метода displayPersons(List<Person> persons) (public по умолч.) списка персон (List)
// из текущего Списка persons на устройство вывода (скорее всего - Display), в том методе,
// где будет имплементирован этот интерфейс PersonView и будет определен метод displayPersons().

import HW_OOP_06_SOA.model.Person;
import java.util.List;

public interface PersonView {

    void displayPersons(List<Person> persons);

}
