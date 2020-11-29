package in.srini91.learn.java8.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StringsAndIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Path path = Paths.get("C:\\th135e\\Learning\\workspace\\Java8Learn");
		try (Stream<Path> list = Files.list(path)) {

			list.forEach(System.out::println);
			System.out.println("------------------------------------------");
			try (Stream<Path> walk = Files.walk(path)) {
//
				walk.forEach(System.out::println);
			}
			System.out.println("---------------Print only directorys---------------------------");
			try (Stream<Path> walk2 = Files.walk(path)) {

				walk2.filter(f -> Files.isDirectory(f)).forEach(System.out::println);
			}

			System.out.println("---------------Print only javaFiles---------------------------");
			try (Stream<Path> walk2 = Files.walk(path)) {

				walk2.filter(f -> !Files.isDirectory(f) && f.getFileName().toString().endsWith(".java"))
						.forEach(System.out::println);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		;

	}
}
