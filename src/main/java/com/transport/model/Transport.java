package com.transport.model;

import java.util.Objects;

/**
 * Базовый класс для всех транспортных средств
 */
public class Transport {
    protected String name;
    protected int maxSpeed;
    protected String manufacturer;

    /**
     * Конструктор по умолчанию
     */
    public Transport() {
        this.name = "Unknown";
        this.maxSpeed = 0;
        this.manufacturer = "Unknown";
    }

    /**
     * Конструктор с параметрами.
     *
     * @param name         название транспортного средства
     * @param maxSpeed     максимальная скорость в км/ч
     * @param manufacturer производитель транспортного средства
     * @throws IllegalArgumentException если скорость не проходит валидацию
     */
    public Transport(String name, int maxSpeed, String manufacturer) {
        validateSpeed(maxSpeed);
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.manufacturer = manufacturer;
    }

    /**
     * Валидирует значение скорости.
     * Проверяет, что скорость находится в допустимом диапазоне.
     *
     * @param speed скорость для валидации
     * @throws IllegalArgumentException если скорость отрицательная или превышает 2000 км/ч
     */
    protected void validateSpeed(int speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Скорость не может быть отрицательной");
        }
        if (speed > 2000) {
            throw new IllegalArgumentException("Скорость не может превышать 2000 км/ч");
        }
    }

    /**
     * Возвращает название транспортного средства.
     *
     * @return название транспортного средства
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название транспортного средства.
     *
     * @param name новое название транспортного средства
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает максимальную скорость транспортного средства.
     *
     * @return максимальная скорость в км/ч
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Устанавливает максимальную скорость с валидацией.
     *
     * @param maxSpeed новая максимальная скорость
     * @throws IllegalArgumentException если скорость не проходит валидацию
     */
    public void setMaxSpeed(int maxSpeed) {
        validateSpeed(maxSpeed);
        this.maxSpeed = maxSpeed;
    }

    /**
     * Возвращает производителя транспортного средства.
     *
     * @return название производителя
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Устанавливает производителя транспортного средства.
     *
     * @param manufacturer новый производитель
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Сравнивает этот транспорт с другим объектом на равенство.
     * Два транспорта считаются равными, если имеют одинаковые название,
     * максимальную скорость и производителя.
     *
     * @param o объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return maxSpeed == transport.maxSpeed &&
                Objects.equals(name, transport.name) &&
                Objects.equals(manufacturer, transport.manufacturer);
    }

    /**
     * Возвращает хеш-код объекта на основе его полей.
     *
     * @return хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, maxSpeed, manufacturer);
    }

    /**
     * Возвращает строковое представление транспортного средства.
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format("Transport{name='%s', maxSpeed=%d, manufacturer='%s'}",
                name, maxSpeed, manufacturer);
    }
}