package com.infopub.j4android.cal.one;

public class Geo {
	public double latitude;
	public double logitude;
	public Geo(double latitude, double logitude) {
		this.latitude = latitude;
		this.logitude = logitude;
	}
	public Geo() {
	}
	@Override
	public String toString() {
		return "Geo [latitude=" + latitude + ", logitude=" + logitude + "]";
	}
	
}
