package kr.co.infopub.game;
public class Temperature {
	public static void main(String[] args) {
		for (int i = 0; i < 101; i++) {
			double fahrenheit=9.0/5*i+32;
			System.out.printf("%d celsius degree= %.2f fahrenheit degree.\n",
					i,fahrenheit);
		}
		System.out.println("-------------------");
		for (int i = 32; i < 213; i++) {
			double celsius=5./9 *(i-32);
			System.out.printf("%d fahrenheit degree= %.2f celsius degree.\n",
					i,celsius);
		}
	}
}
