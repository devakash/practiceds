package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EServiceExample {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Runnable r = () -> {
			for (int i = 1; i <= 21; i=i+2) {
				try {
					TimeUnit.MILLISECONDS.sleep(25);
					System.out.println(i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		Runnable r2 = () -> {
			for (int i = 2; i <= 21; i=i+2) {
				try {
					TimeUnit.MILLISECONDS.sleep(25);
					System.out.println(i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		executor.submit(r);
		executor.submit(r2);

	}

}
