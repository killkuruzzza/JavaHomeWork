package homework_1;

/**
 * Написать метод, который определяет, является ли год високосным,
 * и возвращает boolean (високосный - true, не високосный - false).
 * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный
 */

public class LeapYear {

    public static void main(String[] args) {

        System.out.println(isLeapYear(2023));
        System.out.println(isLeapYear(100));
        System.out.println(isLeapYear(400));
        System.out.println(isLeapYear(2012));
        System.out.println(isLeapYear(2016));
        System.out.println(isLeapYear(2019));
        System.out.println(isLeapYear(1100));
        System.out.println(isLeapYear(1200));

    }

    public static boolean isLeapYear(int year) {

        if (year % 100 == 0 && year % 400 != 0)
            return false;

        else return year % 4 == 0;
    }
}
