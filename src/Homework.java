import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework {

  /**
   * Реалзиовать методы, описанные ниже:
   */

  /**
   * Вывести на консоль отсортированные (по алфавиту) имена персонов
   */
  public static void printNamesOrdered(List<Person> persons) {
    persons.stream()
            .sorted(Comparator.comparing(Person::getName))
            .forEach(System.out::println);
  }

  /**
   * В каждом департаменте найти самого взрослого сотрудника.
   * Вывести на консоль мапипнг department -> personName
   * Map<Department, Person>
   */

  public static Map<Department, Person> printDepartmentOldestPerson(List<Person> persons) {

    return persons.stream()
            .collect(Collectors.toMap(Person::getDepartment, Function.identity(), (first, second) -> {
              if (first.getAge() < second.getAge()) {
                return second;
              }
              return first;
            }));
  }

  /**
   * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
   */

  public static List<Person> findFirstPersons(List<Person> persons) {
    return persons.stream()
            .filter(p -> p.getAge() < 30)
            .filter(p -> p.getSalary() > 50_000)
            .limit(10)
            .collect(Collectors.toList());
  }

  /**
   * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
   */

  public static Optional<Department> findTopDepartment(List<Person> persons) {
      return persons.stream()
               .map(Person::getDepartment)
               .distinct()
               .map(d -> new AbstractMap.SimpleEntry<>(
                       d,
                       persons.stream()
                            .filter(p -> p.getDepartment().equals(d))
                            .mapToDouble(Person::getSalary)
                            .sum()))
              .max((e1, e2) -> (int) (e1.getValue() - e2.getValue()))
              .map(AbstractMap.SimpleEntry::getKey);
  }

}
