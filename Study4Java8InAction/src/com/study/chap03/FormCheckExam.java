package com.study.chap03;

import java.util.ArrayList;
import java.util.List;

import com.study.res.Apple;


/**
 * 형식 추론을 위해 작성한 간단한 클래스
 * @author elfinlas
 *
 */

public class FormCheckExam {
	public static void main(String [] args) {
		
		//임시로 사용할 값들
		List<Apple> appleList = new ArrayList<>();
		appleList.add(new Apple(50, "red"));
		appleList.add(new Apple(100, "red"));
		appleList.add(new Apple(60, "green"));
		appleList.add(new Apple(120, "green"));
		
		//Predicate_Exam<Apple> testPredicate = (Apple a) -> a.getWeight()>70;
		List<Apple> tempList = filterApples(appleList, (Apple a) -> a.getWeight()>70);
		
		for (Apple a : tempList) {
			System.out.println(a.getWeight());
		}
	}
	
	/**
	 * Predicate를 받아서 애플의 값을 필터링하는 메서드
	 * @param inventory
	 * @param p
	 * @return
	 */
	public static <T> List<T> filterApples(List<T> inventory, Predicate_Exam<T> p) {
		List<T> result = new ArrayList<>();
		for(T t : inventory) {
			if(p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}	
}
