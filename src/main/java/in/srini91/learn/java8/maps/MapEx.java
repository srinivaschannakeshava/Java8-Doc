package in.srini91.learn.java8.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapEx {

	public static void main(String[] args) {

		List<Person> pList = new ArrayList<Person>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(MapEx.class.getResourceAsStream("people.txt")))) {
			Stream<String> lines = reader.lines();
			lines.map(line -> {
				String[] split = line.split(" ");
				Person p = new Person(split[0].trim(), Integer.parseInt(split[1].trim()), split[2].trim());
				pList.add(p);
				return p;
			}).forEach(System.out::println);

//			merging two list to form a map....

			List<Person> list1 = pList.subList(0, 10);
			List<Person> list2 = pList.subList(10, pList.size());
			Map<Integer, List<Person>> map1 = list1.stream().collect(Collectors.groupingBy(Person::getAge));
			Map<Integer, List<Person>> map2 = list2.stream().collect(Collectors.groupingBy(Person::getAge));

			map2.entrySet().stream().forEach(entry -> map1.merge(entry.getKey(), entry.getValue(), (l1, l2) -> {
				l1.addAll(l2);
				return l1;
			}));

			map1.forEach((k, v) -> System.out.println(k + " : " + v));

			System.out.println("-------------------------------------------");

			Map<Integer, List<Person>> collect = pList.stream().collect(Collectors.groupingBy(Person::getAge));
			collect.forEach((k, v) -> System.out.println(k + " : " + v));

			Map<Integer, Map<String, List<Person>>> bimap = new HashMap<>();

			pList.forEach(p -> bimap.computeIfAbsent(p.getAge(), HashMap::new).merge(p.getGender(),
					new ArrayList<>(Arrays.asList(p)), (l1, l2) -> {
						l1.addAll(l2);
						return l1;
					}));
			System.out.println("Bimap : ");
			bimap.forEach((age, m) -> System.out.println(age + " -> " + m));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
