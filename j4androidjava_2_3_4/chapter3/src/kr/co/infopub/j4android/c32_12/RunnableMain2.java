package kr.co.infopub.j4android.c32_12;

public class RunnableMain2 {
	
	public static void main(String[] args) {
		RunnableMain2 r1=new RunnableMain2();
		r1.hello("A");
		r1.hello("B");
		r1.hello("C");
	}
	
	public void hello(String name){
		new Thread(new MyRunnable(),name).start();
	}
	
	class MyRunnable implements Runnable{
		@Override
		public void run() {
			for(int i=0; i<100; i++){
				System.out.print(Thread.currentThread().getName());
			}
		}
	}
}
