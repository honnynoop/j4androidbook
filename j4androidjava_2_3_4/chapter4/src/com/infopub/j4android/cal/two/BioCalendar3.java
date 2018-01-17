package com.infopub.j4android.cal.two;
import java.util.Calendar;
public class BioCalendar3 {
	//상수  ,값을 변경할 수 없다.
	public static final int PHYSICAL = 23;     //신체지수
	public static final int EMOTIONAL = 28;    //감정지수
	public static final int INTELLECTUAL = 33; //지성지수

	public static void main(String[] args) {
		
		  Calendar birth=Calendar.getInstance();
		  birth.set(1971,9-1,28);  //0월 ~11월, 1980.3.28
		  Calendar theDay=Calendar.getInstance();  //오늘
	      //theDay.set(년,월-1,일);  
		  
		  long dateBirth=birth.getTimeInMillis();  //1970.1.1~생일까지
		  long dateToDay=theDay.getTimeInMillis(); //1970.1.1~오늘까지
		  //밀리세컨즈/1000 -> 초, 초/60 ->분, 분/60 ->시, 시/24->일
		  long days=(dateToDay-dateBirth)/1000/60/60/24; //오늘-생일=생일부터 오늘까지 경과일
		  
		  System.out.println(days);   
          //바이오 리듬 공식에 넣기 100최대값
		  int index=PHYSICAL;  //23
		  double phyval=100*Math.sin( (days % index) * 2 * Math.PI / index );
		  index=EMOTIONAL;     //28
		  double emoval=100*Math.sin( (days % index) * 2 * Math.PI / index );
		  index=INTELLECTUAL;     //33
		  double inteval=100*Math.sin( (days % index) * 2 * Math.PI / index );
		  
		  System.out.printf("나의 신체지수 %1$.2f입니다.\n",phyval);
		  System.out.printf("나의 감정지수 %1$.2f입니다.\n",emoval);
		  System.out.printf("나의 지성지수 %1$.2f입니다.\n",inteval);
		  
		  System.out.println(Byte.MAX_VALUE);
		  System.out.println(Byte.MIN_VALUE);
		  System.out.println(Short.MAX_VALUE);
		  System.out.println(Short.MIN_VALUE);
		  System.out.println(Integer.MIN_VALUE);
		  System.out.println(Integer.MAX_VALUE);
		  System.out.println(Integer.MIN_VALUE);
		  System.out.println(Long.MAX_VALUE);
		  System.out.println(Long.MIN_VALUE);
		  System.out.println(Float.MAX_VALUE);
		  System.out.println(Float.MIN_VALUE);
		  System.out.println(Double.MAX_VALUE);
		  System.out.println(Double.MIN_VALUE);
	}
}
