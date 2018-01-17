package kr.co.infopub.j4android.c18;

public class GeoMain {
	 public static void main(String[] args) {  
		// Geo geo1=new Geo( ) ;   // 예외 – 기본생성자가 없다.
			Geo geo1=new Geo(37.52127220511242, 127.0074462890625) ;  // 인자가 2개인 생성자

			System.out.printf("위도:%f, 경도:%f\n",geo1.getLatitude(), geo1.getLongitude());
			Geo geo2=geo1;  //주소 가져오기
			System.out.printf("위도:%f, 경도:%f\n",geo2.getLatitude(), geo2.getLongitude()); 

	}
}

