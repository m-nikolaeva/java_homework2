import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

// К калькулятору из предыдущего дз добавить логирование.

public class calcLog {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(calcLog.class.getName());
        FileHandler fh = new FileHandler("calcLog.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("Калькулятор запущен");
        Scanner myScan = new Scanner(System.in);
        System.out.println("Добро пожаловать в калькулятор.");
        System.out.print("Введите первое число: \n");
        float num_a = myScan.nextFloat();
        logger.info("Пользователь ввел первое число: " + num_a);
        System.out.print("Введите второе число: \n");
        float num_b = myScan.nextFloat();
        logger.info("Пользователь ввел второе число: " + num_b);
        System.out.print("Выберите операцию из предложенных: + - / * : \n");
        char operation = myScan.next().charAt(0);
        logger.info("Пользователь выбрал операцию: " + operation);
        float res = 0;
        switch (operation) {
            case '+':
                res = num_a + num_b;
                System.out.printf("%.2f + %.2f = %.2f \n", num_a, num_b, res);
                break;
            case '-':
                res = num_a - num_b;
                System.out.printf("%.2f - %.2f = %.2f \n", num_a, num_b, res);
                break;
            case '/':
                res = num_a / num_b;
                System.out.printf("%.2f / %.2f = %.2f \n", num_a, num_b, res);
                break;
            case '*':
                res = num_a * num_b;
                System.out.printf("%.2f * %.2f = %.2f \n", num_a, num_b, res);
                break;
        }
        logger.info("Получен результат: " + num_a + operation + num_b + "=" + res);
        logger.info("Подсчет успешно завершен.");
        myScan.close();
    }
}
