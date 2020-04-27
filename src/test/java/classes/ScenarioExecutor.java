package classes;

import classes.scenario.CustomerScenario;
import java.util.Scanner;

public class ScenarioExecutor {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long minCardNumber, maxCardNumber;
        System.out.println("Введите минимальное значение номера кредитной карточки ");
        minCardNumber = scanner.nextLong();
        System.out.println("Введите максимальное значение номера кредитной карточки ");
        maxCardNumber = scanner.nextLong();
        new CustomerScenario(minCardNumber,maxCardNumber).execute();
    }
}
