package com.infopub.j4android.two.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		
		Locale local=new Locale("ko", "kr");
	   
	    TimeZone tz=TimeZone.getDefault();
	    Calendar cal=Calendar.getInstance(tz);
		System.out.println(tz);
		System.out.println(cal);
		//1970.1.1.0.0.0~오늘까지 경과시간 
		long sc=System.currentTimeMillis();
		System.out.println(sc);
		
		
		Date d=new Date();
		System.out.println(d);
		System.out.println();
		Date dd=new Date(sc+24*60*60*1000);
		
		System.out.println(dd);
		

		
		TimeZone tz1 = TimeZone.getTimeZone("Asia/Seoul");
		Calendar cal1=Calendar.getInstance();
		cal1.setTimeZone(tz1);
		System.out.println(cal1.get(Calendar.AM_PM));//1 PM
		System.out.println(cal1.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal1.get(Calendar.MINUTE));
		
		TimeZone tz2 = TimeZone.getTimeZone("America/New_York");
		Calendar cal2=Calendar.getInstance();
		cal2.setTimeZone(tz2);
		System.out.println(cal2.get(Calendar.AM_PM)); //0 AM
		System.out.println(cal2.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal2.get(Calendar.MINUTE));
		
		System.out.println("---------------------------");
		
		  long millis=System.currentTimeMillis();
		  System.out.println(millis/1000/60%60);
		  System.out.println(millis/1000/24/60/60/365);
		  Calendar cal1970=Calendar.getInstance();
		  cal1970.set(1970, 1-1 ,1);  //0월 ~11월
		  
		  Calendar today=Calendar.getInstance();
		  
		  long minus=today.getTimeInMillis()-cal1970.getTimeInMillis();
		  System.out.println(minus);
		  System.out.println(minus/1000/24/60/60/365); //46= 1970.1.1 + 46 ->2016
		
	}
	public Date todate2(String ss){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh24:mm:ss");
		Date dd=new Date();
		try {
			dd=sdf.parse(ss);
		} catch (ParseException e) {
		}
		return dd;
	}
	public static Date todate1(String ss){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dd=new Date();
		try {
			dd=sdf.parse(ss);
		} catch (ParseException e) {
		}
		return dd;
	}
	public static String todate2(Date dd){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dd);
	}
}
