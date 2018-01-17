package kr.co.infopub.j4android.c16;

public class GeoMain {
	 public static void main(String[] args) {  
		Geo geo1=new Geo() ;
		geo1.setLatitude(37.52127220511242);
		geo1.setLongitude(127.0074462890625);
		System.out.printf("위도:%f, 경도:%f\n",geo1.getLatitude(), geo1.getLongitude());
		Geo geo2=geo1;  //주소 가져오기
		System.out.printf("위도:%f, 경도:%f\n",geo2.getLatitude(), geo2.getLongitude()); 
	}
}

