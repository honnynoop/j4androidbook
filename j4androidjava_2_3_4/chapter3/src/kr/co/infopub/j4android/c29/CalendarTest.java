package kr.co.infopub.j4android.c29;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		
		//1970.1.1부터 
		long millis=System.currentTimeMillis();
		System.out.println(millis/1000/24/60/60);//몇일
		
		Date d=new Date();
		System.out.println(d);
		Date dd=new Date(d.getTime()+24*60*60*1000);
		System.out.println(dd);
		
		
		Calendar cal1970=Calendar.getInstance();
		cal1970.set(1970, 1-1 ,1);  //0월 ~11월
		
		Calendar today=Calendar.getInstance();
		long minus=today.getTimeInMillis()-cal1970.getTimeInMillis();
		System.out.println(minus);
	    System.out.println(minus/1000/24/60/60/365); //1970년 부터 몇년 지났는가?
	   	    
	    
	    
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    String st=sdf.format(dd);
	    System.out.println(st);
	    
	    
	    Calendar c = Calendar.getInstance();    //오늘
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH) + 1;//0월~11월
        int mDay = c.get(Calendar.DAY_OF_MONTH);
	    
	    
        String newToday = String.format("오늘은 %2d년 %2d월 %2d일이다.",
        		mYear,mMonth,mDay);
       	System.out.println(newToday);
	    
	    
	    
	    //---------------------------------------------------
	    
	    
	    //예외처리
	    Date d2=new Date();
	    try {
			d2=sdf.parse(st);
		} catch (ParseException e) {
			System.out.println(d2);
		}catch(Exception e){
			System.out.println(e);
		}
	    
	    
	    
	    
	    
	    System.out.println("---------------------------");
	    TimeZone tz=TimeZone.getDefault();
	    Calendar cal=Calendar.getInstance(tz);
		System.out.println(tz);
		System.out.println(cal);
		//1970.1.1.0.0.0~오늘까지 경과시간 
		long sc=System.currentTimeMillis();
		System.out.println(sc);
				
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

	    
	}
	public static  Date todateLong(String ss){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh24:mm:ss");
		Date dd=new Date();  //오늘 
		try {
			dd=sdf.parse(ss);
		} catch (ParseException e) {
		}
		return dd;
	}
	public static Date todate(String ss){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dd=new Date();
		try {
			dd=sdf.parse(ss);
		} catch (ParseException e) {
		}
		return dd;
	}
	public static String todate(Date dd){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dd);
	}
	public String todate(String ss,int totals, int round){
		Calendar cal=todate3(ss);
		//Calendar calTemp = (Calendar) cal.clone();
		cal.add(Calendar.DAY_OF_YEAR, -(totals-round)*7);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}
	public Calendar todate3(String ss){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dd=new Date();
		try {
			dd=sdf.parse(ss);
		} catch (Exception e) {
		}
		Calendar cal=Calendar.getInstance();
		cal.setTime(dd);
		return cal;
	}
	
}

