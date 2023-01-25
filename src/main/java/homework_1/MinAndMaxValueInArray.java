package homework_1;

/**
 * Задать одномерный массив и найти в нем минимальный и максимальный элементы
 */
public class MinAndMaxValueInArray {

    public static void main(String[] args) {

        int[] arr = {1, 8, 3, 8, 2, 6, 8, 8, 0, -1, -15, 15};

        CountMaxValueArr(arr);
    }

    public static void CountMaxValueArr(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int j : arr) {
            if (j > max)
                max = j;

            if (j < min)
                min = j;
        }

        System.out.println(max);
        System.out.println(min);
    }

}
