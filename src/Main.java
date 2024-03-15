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

//        Homework.printNamesOrdered(persons);

//        Map<Department, Person> mapTask2 = Homework.printDepartmentOldestPerson(persons);
//        for (Department department: mapTask2.keySet().stream()
//                .sorted(Comparator.comparing(Department::getName))
//                .collect(Collectors.toList())) {
//            System.out.println(mapTask2.get(department));
//        }




    }
}