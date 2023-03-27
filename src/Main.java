
import employee.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        //creem lista de angajati
        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Basil", 26, true, "Management"));
        staff.add(new Employee("Anna", 23, false, "Software"));
        staff.add(new Employee("Luke", 30, true, "Management"));
        staff.add(new Employee("Jack", 46, false, "Software"));
        staff.add(new Employee("Emma", 40, true, "Management"));
        staff.add(new Employee("Liza", 28, true, "Management"));
        staff.add(new Employee("Bob", 25, true, "Software"));
        staff.add(new Employee("John", 33, true, "Management"));
        staff.add(new Employee("Skyler", 23, false, "Software"));
        staff.add(new Employee("Andrew", 25, false, "Management"));
        staff.add(new Employee("Emma", 40, true, "Software"));
        staff.add(new Employee("Meg", 36, false, "Management"));
        staff.add(new Employee("Lex", 32, false, "Management"));

        //creem stream de angajati inici pe cere il salvam in lista noua
        List<Employee>angajatiUnici = staff.stream()
                .filter(e -> e.getDepartment().equals("Management"))
                .filter(e -> e.isPayedPerHour())
                .filter(e -> e.getAge() > 25)
                .distinct()
                .limit(5)
                .collect(Collectors.toList());

        //prin metoda de afisare de mai jos fiecare element al listei va fi afisat pe rindul nou
        angajatiUnici.forEach(System.out::println);

        List<String>punct2 = staff.stream()
                .filter(e -> !e.isPayedPerHour())
                .filter(e -> e.getAge() > 30)
                .map (Employee::getName)
                .sorted()
                /* operatie de mai joscolecteaza rezultatele,
                dar nu-i neaparat de scris numai pe dinsa,
                mai sunt variante */
                .collect(Collectors.toList());

        System.out.println("Rezolvarea pentru l18 punctul2: " + punct2);

        Optional<Employee>punct3 = staff.stream()
                .filter(e -> e.getDepartment().equals("Software"))
                .filter(Employee::canAttendTraining)
                .filter(Employee::canLeadInterview)
                .findAny();
        System.out.println("Angajatul care satisface toaate conditiile: " + punct3);

    }
}