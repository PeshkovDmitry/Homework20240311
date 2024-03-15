import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            departments.add(new Department("Department #" + i));
        }

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            persons.add(new Person(
                    "Person #" + i,
                    ThreadLocalRandom.current().nextInt(20, 61),
                    ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0,
                    departments.get(ThreadLocalRandom.current().nextInt(departments.size()))
            ));
        }

        System.out.println("Реализация метода printNamesOrdered");
        Homework.printNamesOrdered(persons);

        System.out.println("Реализация метода printDepartmentOldestPerson");
        Map<Department, Person> map = Homework.printDepartmentOldestPerson(persons);
        for (Department department:
                map.keySet()) {
            System.out.println(map.get(department));
        }

        System.out.println("Реализация метода findFirstPersons");
        for (Person person :
                Homework.findFirstPersons(persons)) {
            System.out.println(person);
        }

        System.out.println("Реализация метода findTopDepartment");
        System.out.println(Homework.findTopDepartment(persons));

        System.out.println("Проверка метода findTopDepartment");
        // Для проверки последней задачи
        Map<Department, Double> result = new HashMap<>();
        for (Person person:
                persons) {
            Double previous = 0.0;
            if (result.containsKey(person.getDepartment())) {
                previous = result.get(person.getDepartment());
            }
            previous += person.getSalary();
            result.put(person.getDepartment(), previous);
        }
        for (Department department :
                result.keySet()) {
            System.out.println(department.getName() + " " + result.get(department));
        }

    }
}