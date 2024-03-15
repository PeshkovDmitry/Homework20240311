

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
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
    throw new UnsupportedOperationException();
  }

  /**
   * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
   */

  public static Optional<Department> findTopDepartment(List<Person> persons) {
    throw new UnsupportedOperationException();
  }

}
