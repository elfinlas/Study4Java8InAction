package com.study.chap04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author elfinlas
 * 스트림의 기본적인 내용을 이용한 퀴즈
 * 아래의 조건을 충족하는 소스코드를 작성하시오. (스트림 사용) 
 * 1. 1 ~ 10의 정수를 선언한 리스트를 만든다.
 * 2. 4이상 8이하 인 정수를 출력한다.
 * 3. 2번의 결과물에 2를 곱한다.
 * 4. 3번의 결과물 중 10 이상인 정수를 출력하라.
 */

public class Quiz01 {
	public static void main(String [] args) {
List<Integer> intList = makeStringList();
		List<Integer> resultList = intList.stream()
				.filter(i -> i>=4 & i<=8)
				.map(i -> i*2)
				.filter(i -> i>=10)
				.collect(Collectors.toList());
		
		//병렬 연산 스트림
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
	
	public static List<Integer> makeStringList() {
		return Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}
}
