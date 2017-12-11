package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 *          Станции
 *
 *          Сошникова Вероника
 *          Наумов Данил
 *
 */

//Класс наследует класс Departments, чтобы статический блок срабатывал при запуске кода
class Stations extends Department implements StationsInterface {

    Random rd = new Random();
    Scanner sc = new Scanner(System.in);

    /**
     *  Массив станций, 1 столбец названия,
     *  2 столбец посещений станции днем,
     *  3 столбец посещение станций вечером
     *  1 ячейка отвечает за количество станции в городке
     *  В данном случае их 10
     */

    //Массив имеет модификатор private, чтобы получить информацию из массива
    //Нужно вызвать метод infoStations
   private static String[][] stations = new String[10][3];

    /**
     *  Статический блок,
     *  который будет присваивать названия станций
     *  при запуске кода
     */

    static {
        stations[0][0] = "Банк";
        stations[1][0] = "Больница";
        stations[2][0] = "Дом Мастеров";
        stations[3][0] = "Кондитерская";
        stations[4][0] = "Оптика";
        stations[5][0] = "Пещера";
        stations[6][0] = "Полиция";
        stations[7][0] = "Стройка";
        stations[8][0] = "Ферма";
        stations[9][0] = "Супермаркет";
    }

    /**
     *  Метод который автоматически считывает c "датчиков"
     *  количество посещений каждой станции.
     */

    public void visitAuto() {
        for (int i = 0; i < stations.length; i++) {
            //Посещений днем
            stations[i][1] = String.valueOf(rd.nextInt(500));
            //Посещений вечером
            stations[i][2] = String.valueOf(rd.nextInt(500));
        }
    }

    /**
     *  Если по каким - то причинам
     *  система не может считать данные с "датчиков",
     *  метод позволяет ввести их вручную.
     */
    //ОСТОРОЖНО ВЫЗЫВАЕТ ЗАСОРЕНИЕ КОНСОЛИ :)
    public void  visitManual() {
        for (int i = 0; i < stations.length; i++) {
            System.out.println("Введите количество посещений на станции '" + stations[i][0] + "' днём." );
            stations[i][1] = String.valueOf(sc.nextInt());
            System.out.println("Введите количество посещений на станции '" + stations[i][0] + "' вечером." );
            stations[i][2] = String.valueOf(sc.nextInt());
        }
    }

    //Метод который подает массив с информацией о посещениях
    //Данным методом можно получать информацию о посещениях из других классов
    //Хоть и массив station имеет модификатор private
    public String[][] infoStations() {
        visitAuto();
        return stations;
    }

}
