package com.company;

/**
 * Аналитический отдел
 * <p>
 * Бочаров Федор
 * Сабитов Абдулазиз
 */

public class AnalyticsDepartment implements AnalyticsDepartmentInterface {

    private int maxDay, maxEvening, sumDay = 0, sumEvening = 0;
    private String maxStationDay, maxStationEvening;

    private Stations stations = new Stations();

    private String[][] copyOfStationD = new String[10][3];
    private String[][] copyOfStationE = new String[10][3];
    private String[][] copyOfStationBasic = new String[10][3];

    //Метод который подает массив полученный из Станций
    String[][] getInfoOfStations() {
        return stations.infoStations();
    }

    /**
     * Основной метод данного отдела,
     * который анализирует информацию
     * о посещении станцйи, находит максимальное
     * количество посещений днем и вечером,
     * находит общее количество посещений
     * днем и вечером
     */

    public void Analysis(String[][] A) {

        //Аналитический отдел сохраняет информацию
        //полученную из отдела Станции
        //для перенаправления в отдел продаж,
        //чтобы вычислить ежемесячный объем продаж
        copyOfStationBasic = A;

        System.out.println("Информация о посещениях станций получена\nАнализ посещений:\n");

        int temp2, temp3, temp5, temp6, j;
        String temp1, temp4;


        //Происходит сортировка вставками по 2 столбцу массива (Посещения днем)
        //И определяется максимальное количество
        for (int i = 0; i < A.length; i++) {
            temp1 = A[i][0];
            temp2 = Integer.parseInt(A[i][1]);
            temp3 = Integer.parseInt(A[i][2]);
            for (j = i - 1; j >= 0 && Integer.parseInt(A[j][1]) < temp2; j--) {
                A[j + 1][0] = A[j][0];
                A[j + 1][1] = A[j][1];
                A[j + 1][2] = A[j][2];
            }
            A[j + 1][0] = temp1;
            A[j + 1][1] = String.valueOf(temp2);
            A[j + 1][2] = String.valueOf(temp3);
        }

        //Копируется отсортированный массив по посещениям днем
        copyOfStationD = A;

        //Значения присваиваются
        maxDay = Integer.parseInt(A[0][1]);
        maxStationDay = A[0][0];

        //Происходит сортировка вставками по 2 столбцу массива (Посещения вечером)
        //И определяется максимальное количество
        for (int i = 0; i < A.length; i++) {
            temp4 = A[i][0];
            temp5 = Integer.parseInt(A[i][1]);
            temp6 = Integer.parseInt(A[i][2]);
            for (j = i - 1; j >= 0 && Integer.parseInt(A[j][2]) < temp6; j--) {
                A[j + 1][0] = A[j][0];
                A[j + 1][1] = A[j][1];
                A[j + 1][2] = A[j][2];
            }
            A[j + 1][0] = temp4;
            A[j + 1][1] = String.valueOf(temp5);
            A[j + 1][2] = String.valueOf(temp6);

        }

        //Копируется отсортированный массив по посещениям вечером
        copyOfStationE = A;

        //Значения присваиваются
        maxEvening = Integer.parseInt(A[0][2]);
        maxStationEvening = A[0][0];

        //Определение общего количества посещений
        for (int i = 0; i < A.length; i++) {
            sumDay += Integer.parseInt(A[i][1]);
        }

        for (int i = 0; i < A.length; i++) {
            sumEvening += Integer.parseInt(A[i][2]);
        }

        //Вызов метода в этом классе для вывода информации на концоль
        result(maxDay, maxEvening, sumDay, sumEvening, maxStationDay, maxStationEvening);
    }

    //Метод который выводит всю информацию о посещениях после анализа
    public void result(int maxD, int maxE, int sumD, int sumE, String maxStDay, String maxStEvening) {

        if (maxD > maxE)
            System.out.println("Посещений днем больше чем посещений вечером");
        else
            System.out.println("Посещений вечером больше чем посещений днем");

        System.out.println("Максимальное посещений днем на станции '" + maxStDay + "' - " + maxD);
        System.out.println("Максимальное посещений вечером на станции '" + maxStEvening + "' - " + maxE);
        System.out.println("Общее количество посещений днем - " + " " + sumD);
        System.out.println("Общее количество посещений вечером - " + " " + sumE);

    }

    //Метод который подает максимальные значения посещений и их суммы
    //Полученных путем анализа
    public String[][] infoOfAnalysisOfMax() {

        String[][] info = new String[2][3];

        info[0][0] = maxStationDay;
        info[0][1] = String.valueOf(maxDay);
        info[0][2] = String.valueOf(sumDay);

        info[1][0] = maxStationEvening;
        info[1][1] = String.valueOf(maxEvening);
        info[1][2] = String.valueOf(sumEvening);

        return info;

    }

    /**        Данные 3 метода не используются в коде,
     *          но в нужном случае могут быть вызваны
     */

    //Метод подает массив с полной информацией о посещениях отсортированный по 2 столбцу (днем)
    String[][] infoOfAnalysisOfAllD() {
        return copyOfStationD;
    }

    //Метод подает массив с полной информацией о посещениях отсортированный по 3 столбцу (вечером)
    String[][] infoOfAnalysisOfAllE() {
        return copyOfStationE;
    }

    //Метод подает массив с полной информацией о посещениях полученных со Станций
    String[][] infoOfAnalysisOfStation() {
        return copyOfStationBasic;
    }

    //Конструктор который выводит в консоль сообщение при создании объекта в этом классе
    AnalyticsDepartment() {
        System.out.println("\nСвязь с Аналитическим отделом установлена\n");
    }

    public String[][] getDayInfo() {
       return stations.infoStations();
    }

}


