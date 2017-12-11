package com.company;

/**
 * Отдел продаж
 * <p>
 * Деревенская Анна
 * Сидалеева Камила
 */

//Класс наследует класс Departments, чтобы статический блок срабатывал при запуске кода
public class SalesDepartment extends Department implements SalesDepartmentInterface {

    //Некий "пульт" для вызова методов (получение данных)
    // из класса Аналитического отдела
    private AnalyticsDepartment ofSD = new AnalyticsDepartment();

    private static String[][][] monthSells = new String[30][10][2];
    private static String[][] helper = new String[10][3];
    private static int[][] ticket = new int[10][1];
    private static int[][] countAll = new int[10][1];
    private static int[][] cash = new int[10][1];

    //Стоимость билетов на станциях

    static {
        ticket[0][0] = 100;
        ticket[1][0] = 150;
        ticket[2][0] = 100;
        ticket[3][0] = 140;
        ticket[4][0] = 50;
        ticket[5][0] = 200;
        ticket[6][0] = 160;
        ticket[7][0] = 300;
        ticket[8][0] = 200;
        ticket[9][0] = 100;
    }

    //Статический блок, который присваивает названия станций к массиву monthSell
    static {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++) {
                monthSells[i][0][0] = "Банк";
                monthSells[i][1][0] = "Больница";
                monthSells[i][2][0] = "Дом Мастеров";
                monthSells[i][3][0] = "Кондитесркая";
                monthSells[i][4][0] = "Оптика";
                monthSells[i][5][0] = "Пещера";
                monthSells[i][6][0] = "Полиция";
                monthSells[i][7][0] = "Стройка";
                monthSells[i][8][0] = "Ферма";
                monthSells[i][9][0] = "Супермаркет";
            }
        }
    }

    //Основной метод который начинает цикл подсчета месячной прибыли
    //Переменная i в данном методе - день месяца
    public void countMonthSells() {
        for (int i = 0; i < 30; i++) {
            helper = ofSD.getDayInfo();
            count(i);
        }
        allMonth();
    }

    //Метод считает количество посещений каждый день в течении месяца
    public void count(int a) {
        for (int i = 0; i < helper.length; i++) {
            monthSells[a][i][1] = String.valueOf(Integer.parseInt(helper[i][1]) + Integer.parseInt(helper[i][2]));
        }
    }

    //Метод, который считает общее количество посещений за месяц
    public void allMonth() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 30; j++) {
                countAll[i][0] += Integer.parseInt(monthSells[j][i][1]);
            }
        }
        //Вызов метода для подсчета суммы
        cash();
    }

    //Метод считает сумму денег полученную с продажи билетов за месяц
    public void cash() {
        for (int i = 0; i < 10; i++) {
            cash[i][0] = countAll[i][0] * ticket[i][0];
        }
        //Вызывается метод для вывода информации в консоль
        aboutCash();
    }

    //Конструктор, который начинает работу по вычеслению
    // ежемесячной прибыли вызывая метод month
    SalesDepartment() {
        System.out.println("\nНачат подсчет ежемесячной прибыли со станций\n");
        countMonthSells();
        System.out.println("\nПодсчет ежемесячной прибыли прошел успешно\n");
    }

    //Метод для вывода в консоль суммы прибыли
    public void aboutCash() {
        for (int i = 0; i < 10; i++) {
            System.out.println("На станции '" + monthSells[1][i][0] + "' полученно " + cash[i][0] + " рублей.");
        }
    }

}
