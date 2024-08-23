package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Editor3D editor = new Editor3D();
        boolean flag = true;
        while (flag) {
            System.out.println("Введите команду:");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить настройки проекта");
            System.out.println("4. Отобразить модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
            System.out.println("0. Выберите пункт меню");

        }
    }
}
