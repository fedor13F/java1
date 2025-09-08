package com.transport;

import com.transport.service.TransportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Scanner;

/**
 * Главный класс приложения
 */
@Configuration
@ComponentScan(basePackages = "com.transport")
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TransportService service = context.getBean(TransportService.class);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Выберите действие: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        service.addTransport();
                        break;
                    case 2:
                        service.removeTransport();
                        break;
                    case 3:
                        service.printAllTransports();
                        break;
                    case 4:
                        service.compareTransports();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Завершение работы...");
                        break;
                    default:
                        System.out.println("Неверный выбор! Введите число от 1 до 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 1 до 5!");
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== Выберите действие ===");
        System.out.println("1. Добавить транспортное средство");
        System.out.println("2. Удалить транспортное средство по индексу");
        System.out.println("3. Вывести все транспортные средства");
        System.out.println("4. Сравнить два транспортных средства");
        System.out.println("5. Завершить работу");
        System.out.println("=========================================");
    }
}