package com.infopub.j4android.two.c14;

public class JavaTypeConversion {

	public static void main(String[] args) {
		double latitude=37.52127220511242;
	    double logitude=127.0074462890625;
	    
		double yourLatitude=37.5;
		int myLatitude=(int) latitude; //double->int

		double earthR = 6371; // km int-> double
		
		int makeOne=(int)(Math.random()*10);//double->int
		
		int num= '9'-'0'; // 57-48 = 9, ‘0’은 48, ‘9’는 57이다.
		int a=Character.getNumericValue('9');     // 9
		int b=Character.digit('9', 10);             // 9

		int alpha = 'A' ;        // 65
		char cAlpha = (char)97; //  'a' -> (int)’a’ =97

	}

}
