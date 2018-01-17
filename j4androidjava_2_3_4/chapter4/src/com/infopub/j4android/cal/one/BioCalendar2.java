package com.infopub.j4android.cal.one;
import java.util.Calendar;
public class BioCalendar2 {
	//상수  
	public static final int PHYSICAL = 23;
	public static final int EMOTIONAL = 28;
	public static final int INTELLECTUAL = 33;

	public static void main(String[] args) {
		
		  Calendar birth=Calendar.getInstance();
		  birth.set(1980,3-1,28);  // 0월 ~11월, 
		  Calendar theDay=Calendar.getInstance();   // 오늘
		  
		  long dateBirth=birth.getTimeInMillis();
		  long dateToDay=theDay.getTimeInMillis();
		  long days=(dateToDay-dateBirth)/1000/24/60/60;   // 태어난 지 몇일
		  System.out.println(days);
                    // (1) 개발자가 정의한 메서드를 호출한다. 
		  double phyval=getBioRhythmValue( days,  PHYSICAL,     100);
		  double emoval=getBioRhythmValue( days,  EMOTIONAL,     100);
		  double inteval=getBioRhythmValue( days,  INTELLECTUAL, 100);
		  
		  System.out.printf("나의 신체지수 %1$.2f입니다.\n",phyval);
		  System.out.printf("나의 감정지수 %1$.2f입니다.\n",emoval);
		  System.out.printf("나의 지성지수 %1$.2f입니다.\n",inteval); 
	}
        // (2) 개발자가 정의한 메서드
	private static double getBioRhythmValue(long days, int index ,int max) {
		return max*Math.sin( (days % index) * 2 * Math.PI / index );
	}
}

