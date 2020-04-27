package classes.scenario;

import classes.container.CustomerList;

public class CustomerScenario extends Scenario {
    private long minCardNumber;
    private long maxCardNumber;
    private CustomerList customerList;

    public CustomerScenario(long minCardNumber, long maxCardNumber) {
        this.minCardNumber = minCardNumber;
        this.maxCardNumber = maxCardNumber;
        this.customerList = new CustomerList();
    }

    @Override
    public void execute() {
        System.out.println("Cписок покупателей в алфавитном порядке (по фамилии):");
        System.out.println(customerList.sortedBySurname());
        System.out.println("Cписок покупателей, у которых номер кредитной карточки находится в интервале "
                + minCardNumber +"-" + maxCardNumber + ":");
        System.out.println(customerList.groupByCardNum(minCardNumber, maxCardNumber));
    }
}
