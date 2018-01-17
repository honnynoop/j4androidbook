package kr.co.infopub.j4android.c15;

public class GeoMain {
	 public static void main(String[] args) {  // (3) 프로그래밍 시작

		Geo geo1=new Geo() ;                  // (4) 객체 생성,
		geo1.latitude=37.52127220511242;       // (5) 위도값을 객체의 멤버에 대입 setter
		geo1.longitude=127.0074462890625;      // (5) 경도값을 객체의 멤버에 대입
		System.out.printf("위도:%f, 경도:%f\n",geo1.latitude, geo1.longitude);   // (6) 객체의 멤버값 가져오기 getter
		Geo geo2=geo1;                                                 // (7) 객체 주소 넘기기
		System.out.printf("위도:%f, 경도:%f\n",geo2.latitude, geo2.longitude);  // (8) 멤버값 가져오기
	 }
	}
