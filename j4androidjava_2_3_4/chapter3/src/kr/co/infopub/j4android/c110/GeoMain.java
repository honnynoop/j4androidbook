package kr.co.infopub.j4android.c110;

public class GeoMain {
	 public static void main(String[] args) {  
		Geo geo1=new Geo() ;
		System.out.printf("위도:%f, 경도:%f\n",geo1.getLatitude(), geo1.getLongitude());
		Geo geo2=geo1;  // 주소 얕은복사, 주소 복사
		System.out.printf("?위도:%f, 경도:%f\n",geo2.getLatitude(), geo2.getLongitude()); 

	}
}

