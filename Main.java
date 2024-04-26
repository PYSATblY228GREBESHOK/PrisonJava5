package org.example;
import java.util.Scanner;

public class Main {
    private int numberOfPrisoners = 0;
    private SecurityLevel securityLevel = SecurityLevel.MEDIUM;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main manager = new Main();
        manager.start();
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                handleChoice(choice);
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 9.");
                scanner.next();
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1. Добавить заключенного");
        System.out.println("2. Добавить несколько заключенных");
        System.out.println("3. Освободить заключенного");
        System.out.println("4. Освободить всех заключенных");
        System.out.println("5. Изменить уровень безопасности");
        System.out.println("6. Показать текущее количество заключенных");
        System.out.println("7. Показать текущий уровень безопасности");
        System.out.println("8. Показать общее состояние тюрьмы");
        System.out.println("9. Выйти");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addPrisoner();
                break;
            case 2:
                addMultiplePrisoners();
                break;
            case 3:
                releasePrisoner();
                break;
            case 4:
                releaseAllPrisoners();
                break;
            case 5:
                changeSecurityLevel();
                break;
            case 6:
                displayNumberOfPrisoners();
                break;
            case 7:
                displaySecurityLevel();
                break;
            case 8:
                displayPrisonState();
                break;
            case 9:
                System.out.println("Выход из программы...");
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, введите число от 1 до 9.");
                break;
        }
    }

    private void addPrisoner() {
        numberOfPrisoners++;
        System.out.println("Заключенный добавлен. Текущее количество заключенных: " + numberOfPrisoners);
    }

    private void addMultiplePrisoners() {
        System.out.println("Сколько заключенных вы хотите добавить?");
        if (scanner.hasNextInt()) {
            int count = scanner.nextInt();
            numberOfPrisoners += count;
            System.out.println(count + " заключенных добавлено. Текущее количество заключенных: " + numberOfPrisoners);
        } else {
            System.out.println("Неверный ввод. Пожалуйста, введите число.");
            scanner.next();
        }
    }

    private void releasePrisoner() {
        if (numberOfPrisoners > 0) {
            numberOfPrisoners--;
            System.out.println("Заключенный освобожден. Текущее количество заключенных: " + numberOfPrisoners);
        } else {
            System.out.println("Нет заключенных для освобождения.");
        }
    }

    private void releaseAllPrisoners() {
        numberOfPrisoners = 0;
        System.out.println("Все заключенные освобождены.");
    }

    private void changeSecurityLevel() {
        System.out.println("Выберите уровень безопасности:\n L - низкий, M - средний, H - высокий:");
        String securityInput = scanner.next().toUpperCase();
        SecurityLevel newLevel;
        switch (securityInput) {
            case "L":
                newLevel = SecurityLevel.LOW;
                break;
            case "M":
                newLevel = SecurityLevel.MEDIUM;
                break;
            case "H":
                newLevel = SecurityLevel.HIGH;
                break;
            default:
                System.out.println("Неверный ввод. Пожалуйста, выберите из этого (L, M, H).");
                return;
        }
        securityLevel = newLevel;
        System.out.println("Уровень безопасности изменен на: " + securityLevel);
    }

    private void displayNumberOfPrisoners() {
        System.out.println("Текущее количество заключенных: " + numberOfPrisoners);
    }

    private void displaySecurityLevel() {
        System.out.println("Текущий уровень безопасности: " + securityLevel);
    }

    private void displayPrisonState() {
        displayNumberOfPrisoners();
        displaySecurityLevel();
    }

    public enum SecurityLevel {
        LOW,
        MEDIUM,
        HIGH
    }
}
