package kr.co.infopub.j4android.c23;

public class GeoMain {
	 public static void main(String[] args) {  

		 Geo[ ] geo=new Geo[]{ 
		 new Geo(37.5670, 126.9807), new Geo(47.01, 10.2),
		 new Geo(40.714086, -74.228697),new Geo(19.42847,-99.12766),
		 new Geo(39.9075,116.39723), new Geo(55.75222,37.61556) };

		 //6개의 객체가 생성되지는 않는다.
		 Geo[ ] geo1=new Geo[6];         
		 geo1[0] = new Geo(37.5670, 126.9807);  // 드디어 생성, 인덱스는 0부터 시작
		 geo1[1] = new Geo(47.01, 10.2);
		 geo1[2] = new Geo(40.714086, -74.228697);
		 geo1[3] = new Geo(19.42847,-99.12766);
		 geo1[4] = new Geo(39.9075,116.39723);
		 geo1[5] = new Geo(55.75222,37.61556);

		 System.out.printf("위도:%f, 경도:%f\n",geo[0].getLatitude(), geo[0].getLongitude());
		 System.out.printf("위도:%f, 경도:%f\n",geo1[0].getLatitude(), geo1[0].getLongitude());

	}

}

