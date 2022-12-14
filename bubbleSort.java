/* Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл. */

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.XMLFormatter;

public class bubbleSort {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(bubbleSort.class.getName());
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);
        XMLFormatter xmlFormatter = new XMLFormatter();
        fh.setFormatter(xmlFormatter);
        int[] sortArr = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < sortArr.length; i++) {
            sortArr[i] = rnd.nextInt(100);
        }
        System.out.println("Исходный массив: " + Arrays.toString(sortArr));
        logger.info("Исходный массив выглядит так: " + Arrays.toString(sortArr));
        int temp;
        for (int i = sortArr.length - 1; i > 0; i--) {
            logger.info("Проход внешнего цикла №" + String.valueOf(i));
            for (int j = 0; j < i; j++) {
                if (sortArr[j] > sortArr[j + 1]) {
                    logger.info("Значения " + String.valueOf(sortArr[j]) + " и "
                            + String.valueOf(sortArr[j + 1]) + " меняем местами");
                    temp = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = temp;
                    logger.info("Получаем: " + Arrays.toString(sortArr));
                }
            }
        }
        System.out.println("Массив после сортировки пузырьком: " + Arrays.toString(sortArr));
        logger.info("Массив после сортировки пузырьком выглядит так: " + Arrays.toString(sortArr));
    }
}