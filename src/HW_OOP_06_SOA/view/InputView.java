package HW_OOP_06_SOA.view;

// Это публичный интерфейс InputView, единственная ответственность которого
// - прием с помощью метода getUserInput() (public по умолч.) того (строкового формата),
// что пользователь введет с устройства ввода (скорее всего Console), в том методе,
// где будет имплементирован этот интерфейс InputView и будет определен метод getUserInput().

public interface InputView {

    String getUserInput();

}
