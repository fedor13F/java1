package com.transport.model;

import java.util.Objects;

/**
 * Класс корабля - наследуется от Transport
 */
public class Ship extends Transport {
    private int displacement;
    private int crewSize;
    private String shipType;

    /**
     * Конструктор по умолчанию.
     * Инициализирует поля значениями по умолчанию:
     * водоизмещение 5000 тонн, экипаж 20 человек, тип корабля "Cargo"
     */
    public Ship() {
        super();
        this.displacement = 5000;
        this.crewSize = 20;
        this.shipType = "Cargo";
    }

    /**
     * Конструктор с параметрами.
     * Инициализирует все поля корабля, включая унаследованные от Transport.
     *
     * @param name         название корабля
     * @param maxSpeed     максимальная скорость в узлах
     * @param manufacturer производитель корабля
     * @param displacement водоизмещение корабля в тоннах
     * @param crewSize     размер экипажа корабля
     * @param shipType     тип корабля (например, "Cargo", "Passenger", "Military")
     * @throws IllegalArgumentException если водоизмещение или размер экипажа не проходят валидацию
     */
    public Ship(String name, int maxSpeed, String manufacturer,
                int displacement, int crewSize, String shipType) {
        super(name, maxSpeed, manufacturer);
        validateDisplacement(displacement);
        validateCrewSize(crewSize);
        this.displacement = displacement;
        this.crewSize = crewSize;
        this.shipType = shipType;
    }

    /**
     * Валидирует водоизмещение корабля.
     * Проверяет, что водоизмещение находится в допустимом диапазоне (1-1,000,000 тонн).
     *
     * @param displacement водоизмещение для валидации в тоннах
     * @throws IllegalArgumentException если водоизмещение не положительное или превышает 1,000,000 тонн
     */
    private void validateDisplacement(int displacement) {
        if (displacement <= 0) {
            throw new IllegalArgumentException("Водоизмещение должно быть положительным");
        }
        if (displacement > 1000000) {
            throw new IllegalArgumentException("Водоизмещение не может превышать 1,000,000 тонн");
        }
    }

    /**
     * Валидирует размер экипажа корабля.
     * Проверяет, что размер экипажа находится в допустимом диапазоне (1-5000 человек).
     *
     * @param crewSize размер экипажа для валидации
     * @throws IllegalArgumentException если размер экипажа не положительный или превышает 5000 человек
     */
    private void validateCrewSize(int crewSize) {
        if (crewSize <= 0) {
            throw new IllegalArgumentException("Размер экипажа должен быть положительным");
        }
        if (crewSize > 5000) {
            throw new IllegalArgumentException("Размер экипажа не может превышать 5000 человек");
        }
    }

    /**
     * Возвращает водоизмещение корабля.
     *
     * @return водоизмещение корабля в тоннах
     */
    public int getDisplacement() {
        return displacement;
    }

    /**
     * Устанавливает водоизмещение корабля с валидацией.
     *
     * @param displacement новое водоизмещение в тоннах
     * @throws IllegalArgumentException если водоизмещение не проходит валидацию
     */
    public void setDisplacement(int displacement) {
        validateDisplacement(displacement);
        this.displacement = displacement;
    }

    /**
     * Возвращает размер экипажа корабля.
     *
     * @return количество членов экипажа
     */
    public int getCrewSize() {
        return crewSize;
    }

    /**
     * Устанавливает размер экипажа корабля с валидацией.
     *
     * @param crewSize новый размер экипажа
     * @throws IllegalArgumentException если размер экипажа не проходит валидацию
     */
    public void setCrewSize(int crewSize) {
        validateCrewSize(crewSize);
        this.crewSize = crewSize;
    }

    /**
     * Возвращает тип корабля.
     *
     * @return тип корабля (например, "Cargo", "Passenger", "Military", "Cruise")
     */
    public String getShipType() {
        return shipType;
    }

    /**
     * Устанавливает тип корабля.
     *
     * @param shipType новый тип корабля
     */
    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    /**
     * Сравнивает этот корабль с другим объектом на равенство.
     * Два корабля считаются равными, если имеют одинаковые значения
     * всех полей (включая унаследованные от Transport), а также:
     * водоизмещение, размер экипажа и тип корабля.
     *
     * @param o объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ship ship = (Ship) o;
        return displacement == ship.displacement &&
                crewSize == ship.crewSize &&
                Objects.equals(shipType, ship.shipType);
    }

    /**
     * Возвращает хеш-код объекта на основе всех его полей.
     * Включает поля унаследованные от Transport и собственные поля корабля.
     *
     * @return хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), displacement, crewSize, shipType);
    }

    /**
     * Возвращает строковое представление корабля.
     *
     * @return строковое представление корабля
     */
    @Override
    public String toString() {
        return String.format("Ship{%s, displacement=%d, crewSize=%d, shipType='%s'}",
                super.toString(), displacement, crewSize, shipType);
    }
}