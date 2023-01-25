package homework_1;

import java.util.Arrays;

/**
 * Дан массив nums = [3,2,2,3] и число val = 3.
 * Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
 * Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
 */

public class ArraySearch {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                while (left < right && nums[right] == val)
                    right--;
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }

        System.out.println(Arrays.toString(nums));
        }
}