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
            System.out.println("0. Завершение работы");
            System.out.println("Выберите пункт меню");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                try {

                    switch (choice) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            flag = false;
                            break;
                        case 1:
                            System.out.println("Укажите наименование файла проекта: ");
                            String name = scanner.next();
                            editor.openProject(name);
                            System.out.println("Проект успешно открыт");
                            break;
                        case 2:
                            break;
                        case 3:
                            editor.showProjectSettings();
                            break;
                        case 4:
                            editor.printAllModels();
                            break;
                        case 5:
                            editor.printAllTextures();
                            break;
                        case 6:
                            editor.renderAll();
                            break;
                        case 7:
                            System.out.println("Укажите номер модели: ");
                            if (scanner.hasNext()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor.renderModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан неверно");
                            }
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
