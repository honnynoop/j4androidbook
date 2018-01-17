package kr.co.infopub.j4android.c31;

public class ClockCity extends Geo{
    private String timezoneId="Asia/Seoul";
    private String countryName="Korea";

    public ClockCity(double lat, double lng, String timezoneId, String countryName) {
    	super(lat,lng); //GeoCity(lat,lng) 부모 생성자 호출
        this.timezoneId = timezoneId;
        this.countryName = countryName;
    }
    public ClockCity(String timezoneId, String countryName) {
		//super();   //자동 -> GeoCity() 부모 생성자 호출
		this.timezoneId = timezoneId;
		this.countryName = countryName;
	}
    public ClockCity() {
    	//super();   //자동 -> GeoCity() 부모 생성자 호출
    }

	@Override
    public String toString() {
        return "ClockCity{" +
                "lat=" + super.getLatitude() +
                ", lng=" + super.getLongitude() +
                ", timezoneId='" + timezoneId + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
