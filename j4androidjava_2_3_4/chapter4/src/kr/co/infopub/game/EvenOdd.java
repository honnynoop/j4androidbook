package kr.co.infopub.game;

public class EvenOdd {
	public static void showOddnEven(int n){
		int temp=n;
		do{
			if(temp%2==1){
				temp=temp*3+1;
			}else{
				temp/=2;
			}
			System.out.print("["+temp+"] ");
		}while(temp!=1);
		System.out.println("\n---------------------");
	}
	public static void showOddnEvenw(int n){
		int temp=n;
		while(temp!=1){
			if(temp%2==1){
				temp=temp*3+1;
			}else{
				temp/=2;
			}
			System.out.print("["+temp+"] ");
		}
		System.out.println("\n---------------------");
	}
	public static void showOddnEvenf(int n){
		int temp=n;
		for( ; temp!=1 ; ){
			if(temp%2==1){
				temp=temp*3+1;
			}else{
				temp/=2;
			}
			System.out.print("["+temp+"] ");
		}
		System.out.println("\n---------------------");
	}
	public static void main(String[] args) {
		showOddnEven(122);
		showOddnEvenw(122);
		showOddnEvenf(122);
	}
}
