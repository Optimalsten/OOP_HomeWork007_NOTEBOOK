package HW_OOP_06_SOA.view;

// Это публичный интерфейс TreeView, расширенного интерфейсами MessageView, PersonView, InputView,
// единственная ответственность которого состоит в запуске метода setPresenter (public по умолч.)
// с параметром presenter экземпляра класса TreePresenter (вероятно, как передача контроллеру) в том методе,
// где будет имплементирован этот интерфейс TreeView и будет определен метод setPresenter().

import HW_OOP_06_SOA.model.Person;
import HW_OOP_06_SOA.presenter.TreePresenter;

import java.util.List;

public interface TreeView extends MessageView, PersonView, InputView {

    // метод setPresenter из этого интерфейса TreeView, расширенного интерфейсами MessageView, PersonView, InputView,
    // запускается с параметром presenter экземпляра класса TreePresenter.

    void setPresenter(TreePresenter presenter);
}
