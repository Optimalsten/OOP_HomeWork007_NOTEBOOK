package HW_OOP_06_SOA.view;

// Это публичный интерфейс MessageView, единственная ответственность которого
// - вывод с помощью метода displayMessage() (public по умолч.) сообщения из строковой
// переменной message на устройство вывода (скорее всего - Display), в том методе,
// где будет имплементирован этот интерфейс MessageView и будет определен метод displayMessage()

public interface MessageView {

    void displayMessage(String message);

}
