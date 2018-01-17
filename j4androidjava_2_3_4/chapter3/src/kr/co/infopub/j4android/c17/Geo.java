package kr.co.infopub.j4android.c17;

public class Geo {                // (1) Geo 클래스를 선언한다.
	private double latitude;      // (2) 외부에 노출되지 않는다.
	private double longitude;     // (2) 외부에 노출되지 않는다.
	
	public double getLatitude() {   // (3) 멤버변수를 외부에 노출시킬 때 getter 
		return latitude;
	}
	public void setLatitude(double latitude) { // (4) 멤버변수에 값을 넣을 때 setter
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
