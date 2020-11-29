package in.srini91.learn.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class ReductionOpEx {

	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> l2 = Arrays.asList(2, 4, 6, 8, 0);
		List<Integer> l3 = Arrays.asList(1, 3, 5, 7, 9);

		List<List<Integer>> list = Arrays.asList(l1, l2, l3);

		Function<List<Integer>, Stream<Integer>> flatMapFunc = l -> l.stream();

		BinaryOperator<Integer> sumFuc = (x, y) -> x + y;

		BinaryOperator<Integer> maxFuc = (x, y) -> x > y ? x : y;

		Optional<Integer> reduce = list.stream().flatMap(flatMapFunc).reduce(sumFuc);
		Optional<Integer> max = list.stream().flatMap(flatMapFunc).reduce(maxFuc);
		long count = list.stream().flatMap(flatMapFunc).count();
		System.out.println(reduce.get());
		System.out.println(max.get());
		System.out.println(count);
	}

}
