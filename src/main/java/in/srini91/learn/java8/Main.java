package in.srini91.learn.java8;

import in.srini91.learn.java8.interfaces.TestFunctional;
import in.srini91.learn.java8.interfaces.TestFunctionalImpl;

public class Main {

	public static void main(String[] args) {

		System.out.println("Test");

		TestFunctionalImpl tfi = new TestFunctionalImpl();
		tfi.execute();
		tfi.executeDefault();
		TestFunctional.nonOveridableMethod();
	}

}
