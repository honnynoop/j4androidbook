package com.infopub.j4android.cal.two;
import java.util.Calendar;
public class BioCalendar1 {
	// (1) 상수, 상수값은 변경할 수 없다.
	public static final int PHYSICAL = 23;     // 신체지수
	public static final int EMOTIONAL = 28;    // 감정지수
	public static final int INTELLECTUAL = 33; // 지성지수

	public static void main(String[] args) {
		  // (2) java.util.Calendar의 객체를 생성한다.
		  Calendar birth=Calendar.getInstance();    // 기본은 오늘로 설정되어 있다. 
          // (3) set(년, 월-1, 일)을 넣으면 입력한 날짜로 설정
		  birth.set(1980,3-1,28);  //0월 ~11월, 1980.3.28
		  Calendar theDay=Calendar.getInstance();  // 오늘
	      // theDay.set(년,월-1,일);  / /변경하지 않으면 오늘이다.
		  // (4) 1970.1.1.0.0.0부터 정해진 날짜까지의 경과시간을
		  long dateBirth=birth.getTimeInMillis();  // 1970.1.1~생일까지
		  long dateToDay=theDay.getTimeInMillis(); // 1970.1.1~오늘까지
		  // (5) 밀리세컨즈/1000 -> 초, 초/60 ->분, 분/60 ->시, 시/24->일
		  long days=(dateToDay-dateBirth)/1000/60/60/24; // 오늘-생일=생일부터 오늘까지 경과일
		  
		  System.out.println(days);   
		  int index=PHYSICAL;  // (6) 한 번만 타입선언, 신체리듬 23
          // (7) 바이오리듬 공식에 넣기 100 최대값
		  double phyval=100*Math.sin( (days % index) * 2 * Math.PI / index );
		  index=EMOTIONAL;     // 28
		  double emoval=100*Math.sin( (days % index) * 2 * Math.PI / index );
		  index=INTELLECTUAL;     // 33
		  double inteval=100*Math.sin( (days % index) * 2 * Math.PI / index );
		  
		  System.out.printf("나의 신체지수 %1$.2f입니다.\n",phyval);
		  System.out.printf("나의 감정지수 %1$.2f입니다.\n",emoval);
		  System.out.printf("나의 지성지수 %1$.2f입니다.",inteval);
	}
}
