package org.example;

import java.util.Scanner;

public class UserDataParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество ДатаРождения НомерТелефона Пол");

        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Ошибка: Недостаточное количество данных.");
            return;
        }

        try {
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (!isValidDateFormat(birthDate)) {
                System.out.println("Ошибка: Неверный формат даты рождения.");
                return;
            }

            if (!isValidPhoneNumber(phoneNumber)) {
                System.out.println("Ошибка: Неверный формат номера телефона.");
                return;
            }

            if (gender != 'm' && gender != 'f') {
                System.out.println("Ошибка: Неверный формат пола.");
                return;
            }

            System.out.println("Данные успешно обработаны.");
            System.out.println("Фамилия: " + lastName);
            System.out.println("Имя: " + firstName);
            System.out.println("Отчество: " + middleName);
            System.out.println("Дата рождения: " + birthDate);
            System.out.println("Номер телефона: " + phoneNumber);
            System.out.println("Пол: " + gender);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат числа.");
        }
    }

    private static boolean isValidDateFormat(String date) {
        // Проверка формата даты "dd.mm.yyyy"
        if (date.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            String[] parts = date.split("\\.");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <= 2100) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidPhoneNumber(long phoneNumber) {
        // Проверка формата номера телефона (любое положительное целое число)
        return phoneNumber >= 0;
    }
}
