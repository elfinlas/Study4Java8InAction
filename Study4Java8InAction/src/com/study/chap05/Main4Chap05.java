package com.study.chap05;

import java.util.List;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;

import com.study.res.Dish;
import static com.study.chap05.MakeListObj4Dish.*;



public class Main4Chap05 {
	public static void main(String [] args) {
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		numbers.stream()
			.filter(i -> i % 2 == 0)
			.distinct()
			.forEach(System.out::println);
	}
	
	public static void exam01() {
		List<Dish> vegetarianMenu = getDishList().stream()
				.filter(Dish::isVegetarian)
				.collect(toList());
		
		for(Dish d : vegetarianMenu) {
			System.out.println("vegetarianMenu = " + d.getName() );
		}
	}
}
