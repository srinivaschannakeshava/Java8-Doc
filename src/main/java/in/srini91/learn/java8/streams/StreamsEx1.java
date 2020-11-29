package in.srini91.learn.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsEx1 {

	public static void main(String[] args) {
		Stream<String> s = Stream.of("one", "two", "three", "four", "five");

		Predicate<String> p1 = s1 -> s1.length() > 3;
		Consumer<String> c = System.out::println;
		Consumer<String> c2 = s2 -> System.out.println(s2 + " : " + Thread.currentThread().getName());
		Predicate<String> p2 = Predicate.isEqual("two");
		// s.forEach(c);
//		s.filter(p1.or(p2)).forEach(c);

		List<String> list = new ArrayList<>();

		s.parallel().peek(c2).filter(p1.or(p2)).peek(list::add).forEach(c2);

		System.out.println("Done");
		System.out.println("Size of Filtered List: " + list.size());
	}
}
