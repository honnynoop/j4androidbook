package com.infopub.j4android.two.c27;

public class StringArray {

	public static void main(String[] args) {
		int[ ]nums2={1,2,3};   // 크기가 결정된 배열
		//nums2={1,2};      // 다시 초기화 불가능 [중요]

		int [] lotto=new int[6];    // {0,0,0,0,0,0} 0으로 초기화
		lotto [0]=-1;            // set 넣기 -1
		int a=lotto[0];          // get 가져오기 a=-1
		lotto =new int[ ]{2,3,4,5}; // 다시 초기화 가능

		String[ ] myNum = new String[ ]{"2016-08-17", "2016-09-17", "2016-03-17"};
		String[ ] myNum2 = {"2016-08-17", "2016-09-17", "2016-03-17"};

	}

}
