package com.transport.exception;

/**
 * Пользовательское исключение для обработки неверного ввода данных.
 */
public class InvalidInputException extends RuntimeException {

    /**
     * Создает новое исключение с указанным сообщением об ошибке.
     * Сообщение должно содержать информацию о том, какое правило валидации было нарушено.
     *
     * @param message детальное сообщение об ошибке валидации.
     *                Не должно быть null.
     * @throws NullPointerException если message равен null
     */
    public InvalidInputException(String message) {
        super(message);
    }

    /**
     * Создает новое исключение с указанным сообщением об ошибке и причиной.
     * Используется, когда исключение валидации вызвано другим исключением.
     *
     * @param message детальное сообщение об ошибке валидации.
     *                Не должно быть null.
     * @param cause   исходное исключение, которое стало причиной этой ошибки валидации.
     *                Может быть null, если причина неизвестна или не существует.
     * @throws NullPointerException если message равен null
     */
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}