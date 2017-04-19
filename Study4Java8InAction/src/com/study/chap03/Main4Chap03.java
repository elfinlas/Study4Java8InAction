package com.study.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4Chap03 {
	public static void main(String[] args) {
		runTest4IntPredicate();		
	}
	
	
	/**
	 * IntPredicate 예제
	 */
	public static void runTest4IntPredicate() {
		//기본형 특화를 사용하여 박싱이 일어나지 않는다.
		IntPredicate_Exam ie = (int i) -> i % 2 == 0; 
		if (ie.test(1000)) {
			System.out.println("1000 is even number");
		}
		else {
			System.out.println("1000 is odd number");
		}
	}
	
	
	////////////////////////////////
	//		Predicate Method 
	////////////////////////////////
	
	
	public static void runTest4Predicate() {
		//문자열이 공백인지 아닌지를 체크하는 predicate 정의 (Lambda)
		Predicate_Exam<String> testPredicate = (String s) -> !s.isEmpty();
		
		//결과를 출력하는 로직
		for(String s : filter(makeStringList(), testPredicate)) {
			System.out.println("s = " + s);
		}
	}
	
	/**
	 * String 형태의 리스트를 만들어주는 메서드
	 * @return
	 */
	public static List<String> makeStringList() {
		return Arrays.asList("Test1", "Test2", "", "Test4");
	}
	
	/**
	 * 프레디케이트를 테스트하는 메서드
	 * @param list String을 담은 리스트
	 * @param p 함수형 인터페이스 (Predicate)
	 * @return 가공된 String
	 */
	public static <T> List<T> filter(List<T> list, Predicate_Exam<T> p) { 
		List<T> resultList = new ArrayList<>();
		for(T t : list) { if (p.test(t)) { resultList.add(t); } }
		return resultList;
	}
	
	
	
	////////////////////////////////
	//		Consumer Method 
	////////////////////////////////
	
	
	public static void runTest4Consumer() {
		Consumer_Exam<String> testConsumer = (String s) -> System.out.println("s = " + s);
		forLoop(makeStringList(), testConsumer);
	}
	
	/**
	 * Consumer를 테스트 하는 메서드
	 * @param list String을 담은 리스트
	 * @param c 함수형 인터페이스 (Consumer)
	 */
	public static <T> void forLoop(List<T> list, Consumer_Exam<T> c) {
		for (T t : list) { c.accept(t); }
	}
	
	
	////////////////////////////////
	//		Function Method 
	////////////////////////////////
	
	public static void runTest4Function() {
		//String을 전달받아서 해당 문자열의 길이를 반환
		 Function_Exam<String, Integer> testFunc = (String s) -> s.length();
		 
		 for(Integer i : checkData(makeStringList(), testFunc)) {
			 System.out.println("i = " + i);
		 }
	}
	
	/**
	 * Function을 테스트 하는 메서드
	 * @param list String을 담은 리스트 
	 * @param f 함수형 인터페이스 (Function)
	 * @return List<R> 을 반환
	 */
	public static <T, R> List<R> checkData(List<T> list, Function_Exam<T, R> f) {
		List<R> resultList = new ArrayList<>();
		for(T t : list) { resultList.add(f.apply(t)); }
		return resultList;
	}
	
}
