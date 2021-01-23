package in.srini91.learn.java8.interfaces;

@FunctionalInterface
public interface TestFunctional {

	void execute();

	default void executeDefault() {
		System.out.println("Default execute method");
	}

	public static void nonOveridableMethod() {
		System.out.println("Static nonOveridable Method");

	}
}
