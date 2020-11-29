package in.srini91.learn.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapAndFlatMapEx {

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> l2 = Arrays.asList(2, 4, 6, 8, 0);
		List<Integer> l3 = Arrays.asList(1, 3, 5, 7, 9);

		List<List<Integer>> list = Arrays.asList(l1, l2, l3);
		Function<List<?>, Integer> mapFunc = l -> l.size();
		Function<List<Integer>, Stream<Integer>> flatMapFunc = l -> l.stream();
		Consumer<Integer> c1 = System.out::println;

		list.stream().map(mapFunc).forEach(c1);
//flat map basically flattens the list of list to a single list
		list.stream().flatMap(flatMapFunc).forEach(c1);
	}
}
