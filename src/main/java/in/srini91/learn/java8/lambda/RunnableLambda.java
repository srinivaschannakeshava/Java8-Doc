package in.srini91.learn.java8.lambda;

public class RunnableLambda {

	public static void main(String[] args) {
//		-------------------------Normal way -------------------
		Runnable nRun = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Hello from Runnable Thread : " + Thread.currentThread().getName());
				}
			}
		};
		Thread t = new Thread(nRun, "Normal Runnable");
		t.start();

//		----------------------Lambda way--------------------------------------
		Runnable lRun = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("Hello from Runnable Thread : " + Thread.currentThread().getName());
			}
		};
		Thread lt = new Thread(lRun, "Lambda Runnable");
		lt.start();
//		-----------------------------------------------------------
	}
}
