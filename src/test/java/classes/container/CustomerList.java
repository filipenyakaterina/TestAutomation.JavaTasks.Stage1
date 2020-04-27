package classes.container;

import classes.entity.Customer;
import classes.entity.Person;
import classes.supportingEntity.Address;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerList {
    private final List<Customer> customers =  new ArrayList<>();

    {
        customers.add(new Customer(0, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2),1000,"BA000"));
        customers.add(new Customer(1, "Petr","Petrovich","Petrov",new Address("Gikalo",13,2),1001,"BA001"));
        customers.add(new Customer(2, "Oleg","Olegovich","Olegov",new Address("Kolasa",24,24),1002,"BA002"));
        customers.add(new Customer(3, "Marina","Ivanovna","Nikolaeva",new Address("Gikalo",5,43),1003,"BA003"));
        customers.add(new Customer(4, "Fedor","Fedorovich","Fedorov",new Address("Gikalo",8,26),1004,"BA004"));
        customers.add(new Customer(5, "Pavel","Pavlovich","Pavlova",new Address("Kolasa",13,63),1005,"BA005"));
        customers.add(new Customer(6, "Galina","Pavlovna","Pavlovich",new Address("Gikalo",28,27),1006,"BA006"));
        customers.add(new Customer(7, "Alina","Fedorovna","Maksimova",new Address("Kolasa",1,13),1007,"BA007"));
        customers.add(new Customer(8, "Maksim","Maksimovich","Ivanov",new Address("Gikalo",2,27),1008,"BA008"));
        customers.add(new Customer(9, "Larisa","Ivanovna","Nikolaeva",new Address("Kolasa",23,83),1009,"BA009"));
        customers.add(new Customer(10, "Pavel","Pavlovich","Nikolaev",new Address("Gikalo",33,24),1010,"BA0010"));
        customers.add(new Customer(11, "Alexey","Olegovich","Pavlovich",new Address("Kolasa",63,93),1011,"BA0011"));
        customers.add(new Customer(12, "Ivan","Ivanovich","Ivanov",new Address("Gikalo",26,23),1012,"BA0012"));
        customers.add(new Customer(13, "Petr","Petrovich","Aivazovskii",new Address("Gikalo",11,32),1013,"BA0013"));
        customers.add(new Customer(14, "Petr","Petrovich","Yakybovich",new Address("Gikalo",11,22),1014,"BA0014"));
        customers.add(new Customer(15, "Oleg","Olegovich","Borisov",new Address("Kolasa",14,22),1015,"BA0015"));

    }

    public List<Customer> sortedBySurname()
    {
        customers.sort(Comparator.comparing(Person::getSurname));
        return customers;
    }

    public ArrayList<Customer> groupByCardNum (long minCardNum, long maxCardNum)
    {
        return customers.stream().filter(customer ->
                (minCardNum <= customer.getCreditCardNum())&&(customer.getCreditCardNum()<= maxCardNum)).
                collect(Collectors.toCollection(ArrayList::new));
    }
}
