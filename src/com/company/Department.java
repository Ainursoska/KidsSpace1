package com.company;

import java.util.Scanner;

/**
 * Класс директората
 * <p>
 * Гимадеев Айнур
 * Ибрагимов Ильшат
 * Демьянова Ульяна
 */

public class Department {
static A guest0 = new A();
    static {
        System.out.println("Добро пожаловать в Kids Space\n");
        System.out.println("1. Аналитика посещений станций");
        System.out.println("2. Подсчет ежемесячной прибыли.");
        System.out.println("3. Прибыль кафе за сегодняшний день.");
        System.out.println("4. Рейтинг блюд по себестоимости.");
        System.out.println("5. Планирование блюд на завтрашний день.");
        System.out.println("6. Вывести список уникальных посетителей.");
        System.out.println("0. Выход из программы.");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /**
         * Кусок кода, который запускает
         * работу всех отделов.
         */
        Stations st = new Stations();

        /**
         *  Список уникальных поситителей,
         *  из которого можно будет удалять и
         *  добавлять новых гостей.
         */


        guest0.name = "\nСписок уникальных посетителей\n";

        A guest1 = new A();
        guest1.name = "Айнур";
        A guest2 = new A();
        guest2.name = "Ильшат";
        A guest3 = new A();
        guest3.name = "Ульяна";
        A guest4 = new A();
        guest4.name = "Федор";
        A guest5 = new A();
        guest5.name = "Абдулазиз";
        A guest6 = new A();
        guest6.name = "Динара";
        A guest7 = new A();
        guest7.name = "Лена";
        A guest8 = new A();
        guest8.name = "Ильдар";
        A guest9 = new A();
        guest9.name = "Анна";
        A guest10 = new A();
        guest10.name = "Камила";
        A guest11 = new A();
        guest11.name = "Вероника";
        A guest12 = new A();
        guest12.name = "Данил";

        guest0.next = guest1;
        guest1.next = guest2;
        guest2.next = guest3;
        guest3.next = guest4;
        guest4.next = guest5;
        guest5.next = guest6;
        guest6.next = guest7;
        guest7.next = guest8;
        guest8.next = guest9;
        guest9.next = guest10;
        guest10.next = guest11;
        guest11.next = guest12;
        guest12.next = null;


        addNewGuest(guest0, "Антон");
        delGuest(guest0, "Ильдар");





        boolean isTrue = false;

        while (!isTrue) {
            System.out.println("\nВведите номер нужной операции:");
            int n = scanner.nextInt();

            switch (n) {

                case 1 :
                    AnalyticsDepartment obj = new AnalyticsDepartment();
                    obj.Analysis(st.infoStations());
                    break;
                case 2:
                    SalesDepartment obj1 = new SalesDepartment();
                    break;
                case 3:
                    Cafe asda = new Cafe();
                    break;
                case 4:
                    Cafe rating = new Cafe("Рейтинг");
                    break;
                case 5:
                    Cafe plan = new Cafe(true);
                    break;
                case 6:
                    list();
                    break;
                case 0:
                    System.out.println("До свидания.");
                    isTrue = true;
                    break;

            }

        }

    }

    static void list() {
        A top = guest0;
        while (top.next != null) {
            System.out.println(top.name);
            top = top.next;
        }
        System.out.println(top.name);
    }


    static void addNewGuest(A root, String newName) {
        A newElement = new A();
        newElement.name = newName;

        A top = root;
        while (top.next != null) {
            top = top.next;
        }
        top.next = newElement;
    }

    static void delGuest(A root, String name) {

        A top = root;
        while (top.next.name != name) {
            top = top.next;
        }
        top.next = top.next.next;

    }

}

class A {

    A next;
    String name;

}
