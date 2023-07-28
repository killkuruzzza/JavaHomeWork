public class Main {

    public static void main(String[] args) {

        String[][] stringArray0 = new String[][]{
                {"3", "g", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringArray1 = new String[][]{
                {"3", "6", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringArray2 = new String[][]{
                {"3", "g", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringArray3 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "6"},
                {"1", "2", "4", "8"}
        };

        wrapperTryCatch(stringArray0);
        wrapperTryCatch(stringArray1);
        wrapperTryCatch(stringArray2);
        wrapperTryCatch(stringArray3);
    }

    private static void wrapperTryCatch(String[][] stringArr) {
        try {
            System.out.println("Сумма элементов массива = " + convertAndSum(stringArr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int convertAndSum(String[][] data) throws MyArraySizeException, MyArrayDataException {
        int arrDim = 4;
        int sum = 0;

        if (data.length != 4)
            throw new MyArraySizeException(String.format("Размерность массива должна быть %dх%d.", arrDim, arrDim));

        // Т.к. размерность вложенных массивов может быть не всегда одинакова, то проверяем, что в каждом из 4-х основных измерений находится массив ровно из 4 элементов
        for (String[] datum : data)
            if (datum.length != 4)
                throw new MyArraySizeException(String.format("Размерность массива должна быть %dх%d.", arrDim, arrDim));

        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[i].length; j++) {
                try {
                    sum += Integer.parseInt(data[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В позиции [%d][%d] исходного массива находится не целое число %s.", i, j, data[i][j]));
                }
            }
        return sum;
    }

}