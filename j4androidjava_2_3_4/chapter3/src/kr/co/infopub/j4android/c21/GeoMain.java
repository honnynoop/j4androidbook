package kr.co.infopub.j4android.c21;

public class GeoMain {
	 public static void main(String[] args) {  
		 Geo seoul = new Geo(37.5670, 126.9807);  // 서울 위도·경도 설정
		 Geo austria = new Geo(47.01, 10.2);  // 오스트리아 빈 위도·경도 설정
		 Geo newyork = new Geo(40.714086, -74.228697); // 미국 뉴욕 위도·경도 설정
		 Geo mexico = new Geo(19.42847,-99.12766); // 멕시코 멕시코시티 위도·경도 설정
		 Geo china = new Geo(39.9075,116.39723); // 중국 상하이 위도·경도 설정
		 Geo rusia = new Geo(55.75222,37.61556); // 러시아 모스크바 위도·경도 설정

		System.out.printf("위도:%f, 경도:%f\n",seoul.getLatitude(), seoul.getLongitude());
		System.out.printf("위도:%f, 경도:%f\n",austria.getLatitude(), austria.getLongitude()); 

	}
}

