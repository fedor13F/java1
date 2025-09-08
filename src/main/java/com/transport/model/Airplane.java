package com.transport.model;

import java.util.Objects;

/**
 * Класс самолета - наследуется от Transport
 */
public class Airplane extends Transport {
    private int maxAltitude;
    private int passengerCapacity;

    /**
     * Конструктор по умолчанию.
     * Инициализирует поля значениями по умолчанию:
     * максимальная высота 10000 метров, вместимость пассажиров 150 человек
     */
    public Airplane() {
        super();
        this.maxAltitude = 10000;
        this.passengerCapacity = 150;
    }

    /**
     * Конструктор с параметрами.
     * Инициализирует все поля самолета, включая унаследованные от Transport.
     *
     * @param name              название самолета
     * @param maxSpeed          максимальная скорость в км/ч
     * @param manufacturer      производитель самолета
     * @param maxAltitude       максимальная высота полета в метрах
     * @param passengerCapacity вместимость пассажиров
     * @throws IllegalArgumentException если высота или вместимость пассажиров не проходят валидацию
     */
    public Airplane(String name, int maxSpeed, String manufacturer,
                    int maxAltitude, int passengerCapacity) {
        super(name, maxSpeed, manufacturer);
        validateAltitude(maxAltitude);
        validatePassengerCapacity(passengerCapacity);
        this.maxAltitude = maxAltitude;
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Валидирует максимальную высоту полета самолета.
     * Проверяет, что высота находится в допустимом диапазоне (0-20000 метров).
     *
     * @param altitude высота для валидации в метрах
     * @throws IllegalArgumentException если высота отрицательная или превышает 20000 метров
     */
    private void validateAltitude(int altitude) {
        if (altitude < 0) {
            throw new IllegalArgumentException("Высота не может быть отрицательной");
        }
        if (altitude > 20000) {
            throw new IllegalArgumentException("Высота не может превышать 20000 м");
        }
    }

    /**
     * Валидирует вместимость пассажиров самолета.
     * Проверяет, что вместимость пассажиров находится в допустимом диапазоне (1-1000 человек).
     *
     * @param capacity вместимость пассажиров для валидации
     * @throws IllegalArgumentException если вместимость не положительная или превышает 1000 человек
     */
    private void validatePassengerCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость пассажиров должна быть положительной");
        }
        if (capacity > 1000) {
            throw new IllegalArgumentException("Вместимость пассажиров не может превышать 1000");
        }
    }

    /**
     * Возвращает максимальную высоту полета самолета.
     *
     * @return максимальная высота полета в метрах
     */
    public int getMaxAltitude() {
        return maxAltitude;
    }

    /**
     * Устанавливает максимальную высоту полета самолета с валидацией.
     *
     * @param maxAltitude новая максимальная высота в метрах
     * @throws IllegalArgumentException если высота не проходит валидацию
     */
    public void setMaxAltitude(int maxAltitude) {
        validateAltitude(maxAltitude);
        this.maxAltitude = maxAltitude;
    }

    /**
     * Возвращает вместимость пассажиров самолета.
     *
     * @return количество пассажиров, которое может перевозить самолет
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Устанавливает вместимость пассажиров самолета с валидацией.
     *
     * @param passengerCapacity новая вместимость пассажиров
     * @throws IllegalArgumentException если вместимость не проходит валидацию
     */
    public void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Сравнивает этот самолет с другим объектом на равенство.
     * Два самолета считаются равными, если имеют одинаковые значения
     * всех полей (включая унаследованные от Transport), а также:
     * максимальную высоту полета и вместимость пассажиров.
     *
     * @param o объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airplane airplane = (Airplane) o;
        return maxAltitude == airplane.maxAltitude &&
                passengerCapacity == airplane.passengerCapacity;
    }

    /**
     * Возвращает хеш-код объекта на основе всех его полей.
     *
     * @return хеш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxAltitude, passengerCapacity);
    }

    /**
     * Возвращает строковое представление самолета.
     *
     * @return строковое представление самолета
     */
    @Override
    public String toString() {
        return String.format("Airplane{%s, maxAltitude=%d, passengerCapacity=%d}",
                super.toString(), maxAltitude, passengerCapacity);
    }
}