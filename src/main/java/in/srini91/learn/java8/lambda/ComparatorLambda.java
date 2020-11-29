package in.srini91.learn.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

	public static void main(String[] args) {

		List<String> stringArrays = Arrays.asList("*", "****", "**", "*****", "***");

		Comparator<String> lengthComparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		};
		Collections.sort(stringArrays, lengthComparator);
		stringArrays.forEach(s -> System.out.println(s));

//		-----------------------Lambda way-------------------

		Comparator<String> lambdaComp = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		Collections.sort(stringArrays, lambdaComp);
		stringArrays.forEach(System.out::println);

	}
}
