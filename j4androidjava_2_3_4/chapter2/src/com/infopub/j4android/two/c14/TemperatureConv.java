package com.infopub.j4android.two.c14;

public class TemperatureConv {

	public static double toCelsius(double fahrenheit){
		return 5./9 *(fahrenheit-32);
	}
	public static double toFahrenheit(double celsius){
		return 9.0/5*celsius+32;
	}
 
	public static void main(String[] args) {
		double celsius=29;
		double fahrenheit=0.0;
		fahrenheit=toFahrenheit(celsius);
		System.out.printf("%.2f celsius degree.= %.2f fahrenheit degree.\n",
				celsius,fahrenheit);
		celsius=toCelsius(fahrenheit);
		System.out.printf("%.2f fahrenheit degree.= %.2f celsius degree.\n",
				fahrenheit,celsius);
		
	}
}
