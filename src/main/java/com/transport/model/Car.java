package com.transport.model;

import java.util.Objects;

/**
 * Класс автомобиля - наследуется от Transport
 */
public class Car extends Transport {
    private String licensePlate;
    private int doorCount;
    private String fuelType;

    /**
     * Конструктор по умолчанию.
     * Инициализирует поля значениями по умолчанию:
     * номерной знак "AA0000AA", 4 двери, тип топлива "Petrol"
     */
    public Car() {
        super();
        this.licensePlate = "AA0000AA";
        this.doorCount = 4;
        this.fuelType = "Petrol";
    }

    /**
     * Конструктор с параметрами.
     *
     * @param name         название автомобиля
     * @param maxSpeed     максимальная скорость в км/ч
     * @param manufacturer производитель автомобиля
     * @param licensePlate номерной знак автомобиля
     * @param doorCount    количество дверей
     * @param fuelType     тип топлива
     * @throws IllegalArgumentException если количество дверей не проходит валидацию
     */
    public Car(String name, int maxSpeed, String manufacturer,
               String licensePlate, int doorCount, String fuelType) {
        super(name, maxSpeed, manufacturer);
        validateDoorCount(doorCount);
        this.licensePlate = licensePlate;
        this.doorCount = doorCount;
        this.fuelType = fuelType;
    }

    /**
     * Валидирует количество дверей автомобиля.
     * Проверяет, что количество дверей находится в допустимом диапазоне (1-10).
     *
     * @param doors количество дверей для валидации
     * @throws IllegalArgumentException если количество дверей не положительное или превышает 10
     */
    private void validateDoorCount(int doors) {
        if (doors <= 0) {
            throw new IllegalArgumentException("Количество дверей должно быть положительным");
        }
        if (doors > 10) {
            throw new IllegalArgumentException("Количество дверей не может превышать 10");
        }
    }

    /**
     * Возвращает номерной знак автомобиля.
     *
     * @return номерной знак автомобиля
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Устанавливает номерной знак автомобиля.
     *
     * @param licensePlate новый номерной знак
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Возвращает количество дверей автомобиля.
     *
     * @return количество дверей
     */
    public int getDoorCount() {
        return doorCount;
    }

    /**
     * Устанавливает количество дверей автомобиля с валидацией.
     *
     * @param doorCount новое количество дверей
     * @throws IllegalArgumentException если количество дверей не проходит валидацию
     */
    public void setDoorCount(int doorCount) {
        validateDoorCount(doorCount);
        this.doorCount = doorCount;
    }

    /**
     * Возвращает тип топлива автомобиля.
     *
     * @return тип топлива (например, "Petrol", "Diesel", "Electric")
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Устанавливает тип топлива автомобиля.
     *
     * @param fuelType новый тип топлива
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Сравнивает этот автомобиль с другим объектом на равенство.
     * Два автомобиля считаются равными, если имеют одинаковые значения
     * всех полей (включая унаследованные от Transport), а также:
     * номерной знак, количество дверей и тип топлива.
     *
     * @param o объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return doorCount == car.doorCount &&
                Objects.equals(licensePlate, car.licensePlate) &&
                Objects.equals(fuelType, car.fuelType);
    }

    /**
     * Возвращает хеш-код объекта на основе всех его полей.
     *
     * @return хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), licensePlate, doorCount, fuelType);
    }

    /**
     * Возвращает строковое представление автомобиля.
     *
     * @return строковое представление автомобиля
     */
    @Override
    public String toString() {
        return String.format("Car{%s, licensePlate='%s', doorCount=%d, fuelType='%s'}",
                super.toString(), licensePlate, doorCount, fuelType);
    }
}