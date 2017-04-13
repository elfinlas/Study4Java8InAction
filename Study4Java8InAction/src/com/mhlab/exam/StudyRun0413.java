package com.mhlab.exam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudyRun0413 {
	public static void main(String[] args) {
		List<Integer> intList = makeStringList();
		
		List<Integer> resultList = intList.stream()
				.filter(i -> i>=4 & i<=8)
				.map(i -> i*2)
				.filter(i -> i>=10)
				.collect(Collectors.toList());
		
		List<Integer> result4ParList = intList.parallelStream()
				.filter(i -> i>=4 & i<=8)
				.map(i -> i*2)
				.filter(i -> i>=10)
				.collect(Collectors.toList());
		
		
		System.out.println("===========");
		
		for(Integer i : resultList) {
			System.out.println("resultList = " + i);
		}
		
		System.out.println("===========");
		
		for(Integer i : result4ParList) {
			System.out.println("result4ParList = " + i);
		}
		
	}
	
	public static void testOne() {
		List<Integer> intList = makeStringList();
		
		List<Integer> resultList = intList.stream()
				.filter(i -> i>=4 & i<=8)
				.collect(Collectors.toList());
		
		List<Integer> secondeResultList = resultList.stream()
				.map(i -> i*2)
				.collect(Collectors.toList());
		
		List<Integer> thridResultList = secondeResultList.stream()
				.filter(i -> i>=10)
				.collect(Collectors.toList());
		
		System.out.println("===========");
		
		for(Integer i : resultList) {
			System.out.println("resultList = " + i);
		}
		
		System.out.println("===========");
		
		for(Integer i : secondeResultList) {
			System.out.println("secondeResultList = " + i);
		}
		
		System.out.println("===========");
		
		for(Integer i : thridResultList) {
			System.out.println("thridResultList = " + i);
		}
	}
	
	
	public static List<Integer> makeStringList() {
		return Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}
	
	
	
	
	/*
	 1) 1 ~ 10의 정수를 선언한 리스트를 만듭니다.

2) 4이상 8이하 인 정수를 출력하세요. 

3) 4이상 8이하 인 정수에 * 2를 합니다.

4) 위 연산 중에 10 이상인 정수를 출력하세요.
	 */
}
