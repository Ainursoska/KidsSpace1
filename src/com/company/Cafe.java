package com.company;

import java.util.Random;

/**
 *     Кафе
 *
 *     Губайдуллина Динара
 *     Мягкова Лена
 */

//Наследуем класс Department чтобы запускать статический блок вместе с запуском кода
public class Cafe extends  Department implements CafeInterface {

    private Random random = new Random();

    private static String[][] menu = new String[9][3];
    private static int[][] cash = new int[9][1];

    //Статический блок который срабатывает при запуске кода
    static {

        //Меню
        //Названия
        menu[0][0] = "Дедушкина окрошка";
        menu[1][0] = "Бульон с очпочмаком";
        menu[2][0] = "Том Ям";
        menu[3][0] = "Цезарь";
        menu[4][0] = "Салат с казылыком";
        menu[5][0] = "Греческий";
        menu[6][0] = "Шашлык";
        menu[7][0] = "Спагетти";
        menu[8][0] = "Грин Паста";
        //Цены
        menu[0][2] = "140";
        menu[1][2] = "110";
        menu[2][2] = "390";
        menu[3][2] = "270";
        menu[4][2] = "320";
        menu[5][2] = "230";
        menu[6][2] = "300";
        menu[7][2] = "350";
        menu[8][2] = "260";

    }

    //Метод который считает количество заказов определенных блюд
    public void countOrder() {
            for (int j = 0; j < 9; j++) {
                menu[j][1] = String.valueOf(random.nextInt(200));
            }
    }

    //Метод который считает сумму полученную при продаже блюд
    public void countCash() {
            for (int j = 0; j < 9; j++) {
                cash[j][0] = Integer.parseInt(menu[j][1])*Integer.parseInt(menu[j][2]);
            }
    }

    //Метод который выводит в консоль информацию о прибыли
    public void cashInfo() {
        System.out.println("\nПрибыль с Кафе за 1 день: \n");
            for (int j = 0; j < 9; j++) {
                System.out.println("С блюда '" + menu[j][0] + "' получено " + cash[j][0] + " рублей.");
            }
    }

    //Конструктор, который запускает цепочку методов для получении информации о блюдах
    Cafe() {
        countOrder();
        countCash();
        cashInfo();
    }

    Cafe(String a) {
        countOrder();
        countCash();
        sortPrice(menu);
    }

    Cafe(boolean a) {
        plan(menu);
    }


    //Метод, который сортирует блюда по себестоимости
    public void sortPrice(String[][] array) {
        int temp1,temp3, j;
        String temp2;
        for (int i = 0; i < array.length ; i++) {
            temp1 = Integer.parseInt(array[i][2]);
            temp2 = array[i][0];
            temp3 = Integer.parseInt(array[i][1]);
            for ( j = i-1; j >= 0 && Integer.parseInt(array[j][2]) > temp1 ; j--) {
                array[j+1][2] = array[j][2];
                array[j+1][0] = array[j][0];
                array[j+1][1] = array[j][1];
            }
            array[j+1][2]=String.valueOf(temp1);
            array[j+1][0]=temp2;
            array[j+1][1]=String.valueOf(temp3);
        }
        //Вызвод метода для вывода в консоль
        show(array);
    }



    //Метод который выводит в консоль цены блюд по возрастанию
    public void show(String[][] array) {
        System.out.println("\nРейтинг блюд по себестоимости\n");
        for (int i = 0; i < 9; i++) {
            System.out.println(array[i][0] + " - " + array[i][2] + " рублей.");
        }
        //Вызов метода, который планирует количество блюд на следующий день
    }

    //Метод планировщик количество блюд
    public void plan(String[][] array) {
        System.out.println("\nПланирование блюд на завтра:\n");
        for (int i = 0; i < 9; i++) {
            System.out.println(array[i][0] + " - " + random.nextInt(300) + " порций.");
        }
    }

}
