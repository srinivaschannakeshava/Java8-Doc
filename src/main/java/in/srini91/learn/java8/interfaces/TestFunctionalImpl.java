package in.srini91.learn.java8.interfaces;

public class TestFunctionalImpl implements TestFunctional {

	@Override
	public void execute() {
		System.out.println("Excute functional execute method");
	}

	@Override
	public void executeDefault() {
		TestFunctional.super.executeDefault();
	}

	public static void main() {
		TestFunctionalImpl tfi = new TestFunctionalImpl();

	}
}
