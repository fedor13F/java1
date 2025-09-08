package com.transport.service;

import com.transport.model.Transport;
import com.transport.model.Airplane;
import com.transport.model.Car;
import com.transport.model.Ship;
import com.transport.exception.InvalidInputException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Сервис для работы с транспортными средствами
 */
@Component
public class TransportService {
    private List<Transport> transports = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Добавляет новое транспортное средство в коллекцию.
     * Предлагает пользователю выбрать тип транспорта и ввести соответствующие параметры.
     * Автоматически логируется через аспект LoggingAspect.
     */
    public void addTransport() {
        System.out.println("Выберите тип транспорта:");
        System.out.println("1. Транспортное средство");
        System.out.println("2. Самолет");
        System.out.println("3. Автомобиль");
        System.out.println("4. Корабль");

        int choice = readInt("Ваш выбор: ", 1, 4);

        Transport transport = null;

        switch (choice) {
            case 1:
                transport = createBaseTransport();
                break;
            case 2:
                transport = createAirplane();
                break;
            case 3:
                transport = createCar();
                break;
            case 4:
                transport = createShip();
                break;
            default:
                System.out.println("Неизвестный тип транспорта: " + choice);
        }

        if (transport != null) {
            transports.add(transport);
            System.out.println("Транспорт добавлен успешно!");
        }
    }

    /**
     * Создает базовое транспортное средство с основными параметрами.
     * Запрашивает у пользователя название, максимальную скорость и производителя.
     *
     * @return новый объект Transport с введенными параметрами
     */
    private Transport createBaseTransport() {
        System.out.print("Введите название: ");
        String name = scanner.nextLine();

        int maxSpeed = readInt("Введите максимальную скорость: ", 0, 2000);

        System.out.print("Введите производителя: ");
        String manufacturer = scanner.nextLine();

        return new Transport(name, maxSpeed, manufacturer);
    }

    /**
     * Создает самолет с дополнительными параметрами.
     * Использует базовые параметры транспорта и добавляет максимальную высоту и вместимость пассажиров.
     *
     * @return новый объект Airplane с введенными параметрами
     */
    private Airplane createAirplane() {
        Transport base = createBaseTransport();

        int maxAltitude = readInt("Введите максимальную высоту (м): ", 0, 20000);

        int passengerCapacity = readInt("Введите вместимость пассажиров: ", 1, 1000);

        return new Airplane(base.getName(), base.getMaxSpeed(), base.getManufacturer(),
                maxAltitude, passengerCapacity);
    }

    /**
     * Создает автомобиль с дополнительными параметрами.
     * Использует базовые параметры транспорта и добавляет номерной знак, количество дверей и тип топлива.
     *
     * @return новый объект Car с введенными параметрами
     */
    private Car createCar() {
        Transport base = createBaseTransport();

        System.out.print("Введите номерной знак: ");
        String licensePlate = scanner.nextLine();

        int doorCount = readInt("Введите количество дверей: ", 1, 10);

        System.out.print("Введите тип топлива: ");
        String fuelType = scanner.nextLine();

        return new Car(base.getName(), base.getMaxSpeed(), base.getManufacturer(),
                licensePlate, doorCount, fuelType);
    }

    /**
     * Создает корабль с дополнительными параметрами.
     * Использует базовые параметры транспорта и добавляет водоизмещение, размер экипажа и тип корабля.
     *
     * @return новый объект Ship с введенными параметрами
     */
    private Ship createShip() {
        Transport base = createBaseTransport();

        int displacement = readInt("Введите водоизмещение (тонн): ", 1, 1000000);

        int crewSize = readInt("Введите размер экипажа: ", 1, 5000);

        System.out.print("Введите тип корабля: ");
        String shipType = scanner.nextLine();

        return new Ship(base.getName(), base.getMaxSpeed(), base.getManufacturer(),
                displacement, crewSize, shipType);
    }

    /**
     * Удаляет транспортное средство из коллекции по индексу.
     * Перед удалением выводит список всех транспортных средств для выбора.
     * Автоматически логируется через аспект LoggingAspect.
     */
    public void removeTransport() {
        if (transports.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }

        printAllTransports();
        int index = readInt("Введите индекс для удаления: ", 0, transports.size() - 1);

        Transport removed = transports.remove(index);
        System.out.println("Удален: " + removed);
    }

    /**
     * Выводит в консоль список всех транспортных средств в коллекции.
     * Для каждого транспорта выводится индекс и строковое представление.
     * Если коллекция пуста, выводится соответствующее сообщение.
     */
    public void printAllTransports() {
        if (transports.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }

        System.out.println("Список транспорта:");
        for (int i = 0; i < transports.size(); i++) {
            System.out.printf("%d: %s%n", i, transports.get(i));
        }
    }

    /**
     * Сравнивает два транспортных средства по индексам на равенство.
     * Выводит подробную информацию о сравнении и результатах.
     * Требует наличия как минимум двух элементов в коллекции.
     * Автоматически логируется через аспект LoggingAspect.
     */
    public void compareTransports() {
        if (transports.size() < 2) {
            System.out.println("Недостаточно элементов для сравнения!");
            return;
        }

        printAllTransports();

        int index1 = readInt("Введите индекс первого элемента: ", 0, transports.size() - 1);
        int index2 = readInt("Введите индекс второго элемента: ", 0, transports.size() - 1);

        Transport t1 = transports.get(index1);
        Transport t2 = transports.get(index2);

        boolean areEqual = t1.equals(t2);

        System.out.printf("Элементы %sравны%n", areEqual ? "" : "не ");
        System.out.println("Первый элемент: " + t1);
        System.out.println("Второй элемент: " + t2);
    }

    /**
     * Читает целое число из консоли с валидацией диапазона.
     * Повторяет запрос до тех пор, пока не будет введено корректное значение.
     *
     * @param prompt приглашение для ввода
     * @param min    минимальное допустимое значение (включительно)
     * @param max    максимальное допустимое значение (включительно)
     * @return валидное целое число в указанном диапазоне
     */
    private int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);

                if (value < min || value > max) {
                    throw new InvalidInputException(
                            String.format("Значение должно быть между %d и %d", min, max)
                    );
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число!");
            } catch (InvalidInputException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    /**
     * Возвращает текущую коллекцию транспортных средств.
     * Может использоваться для тестирования или внешнего доступа к данным.
     *
     * @return список всех транспортных средств
     */
    public List<Transport> getTransports() {
        return transports;
    }
}