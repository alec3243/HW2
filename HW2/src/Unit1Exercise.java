import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60), new Person("Lewis",
						"Carroll", 42), new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45), new Person("Matthew",
						"Arnold", 39));

		// Sort list by last name
		Collections.sort(people,
				(p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Create a method that prints all elements
		print(people);

		System.out.println("~~~~~~~~~");

		// Create a method that prints all elements with last name starting with
		// C
		print(people.stream()
				.filter(person -> person.getLastName().charAt(0) == 'C')
				.collect(Collectors.toList()));

	}

	private static void print(List<Person> people) {
		people.forEach(person -> System.out.println(person.getFirstName()));
	}
}