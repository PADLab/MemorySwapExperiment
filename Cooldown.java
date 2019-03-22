import java.lang.*;

public class Cooldown implements Runnable {

   Thread t;

   public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			// thread to sleep for 60 seconds
			Thread.sleep(60000);
		} catch (Exception e) {
			System.out.println(e);
		}
   }

   public static void main(String[] args) throws Exception {
      Thread t = new Thread(new Cooldown());
      // this will call run() function
      t.start();
   }
} 