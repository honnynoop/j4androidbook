package kr.co.infopub.j4android.c29;

public class GeoDistance {
	public static void main(String[] args) {
		Geo seoul = new Geo(37.5670, 126.9807);  // 서울 위도·경도 설정
		Geo austria = new Geo(47.01, 10.2);  // 오스트리아 빈 위도·경도 설정
		double distance=HaversineDistance.distance (
				seoul.getLatitude(), seoul.getLongitude(),
				austria.getLatitude(), austria.getLongitude());
		System.out.println(distance);  // 서울과 빈 사이의 거리
	}
}
