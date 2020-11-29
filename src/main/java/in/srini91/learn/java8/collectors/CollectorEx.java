package in.srini91.learn.java8.collectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorEx {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Person> pList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(

				new InputStreamReader(CollectorEx.class.getResourceAsStream("people.txt")))) {
			Stream<String> lines = br.lines();

			Function<String, Person> mapperFunc = (line) -> {
				String[] split = line.split(" ");
				Person p = new Person(split[0].trim(), Integer.parseInt(split[1].trim()));
				pList.add(p);
				return p;
			};
			lines.map(mapperFunc).forEach(System.out::println);
			System.out.println("--------------------------------------");

			Optional<Person> minPerson = pList.stream().filter(p -> p.getAge() >= 20).peek(System.out::println)
					.min(Comparator.comparing(Person::getAge));
			System.out.println("--------------------------------------");
			System.out.println(minPerson);
			System.out.println("--------------------------------------");
			Optional<Person> maxAgedPerson = pList.stream().max(Comparator.comparing(Person::getAge));
			Optional<Person> minAgedPerson = pList.stream().min(Comparator.comparing(Person::getAge));
			System.out.println(maxAgedPerson + " : " + minAgedPerson);
			System.out.println("--------------------------------------");
			Instant start = Instant.now();
			Map<Integer, String> groupByAge = pList.stream().collect(Collectors.groupingBy(Person::getAge,
					Collectors.mapping(Person::getName, Collectors.joining(", "))));

			System.out.println(groupByAge);
			Instant end = Instant.now();
			System.out.println("Processing Time : " + Duration.between(start, end).toMillis());
			LinkedHashMap<Integer, String> sortedByAge = groupByAge.entrySet().stream()
					.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
							(oldValue, newValue) -> oldValue, LinkedHashMap::new));
			System.out.println(sortedByAge);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
