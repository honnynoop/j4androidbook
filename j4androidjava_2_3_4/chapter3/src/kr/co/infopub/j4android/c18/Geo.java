package kr.co.infopub.j4android.c18;

public class Geo {
	private double latitude;      
	private double longitude;   
	public Geo(double latitude, double longitude) {  // 생성자 선언 -> 기본생성자가 만들어지지 않는다.
		this.latitude = latitude;     // 생성되면서 위도와 경도가 멤버변수값으로 대입된다.
		this.longitude = longitude;
	}
	public double getLatitude() {   //getter 
		return latitude;
	}
	public void setLatitude(double latitude) { //setter
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
