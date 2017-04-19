package com.study.chap04;

import java.util.Arrays;
import java.util.List;

import com.study.res.Dish;
import com.study.res.Dish.Type;

import static java.util.stream.Collectors.toList;

public class Exam04 {
	public static void main(String [] args) {
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 800, Type.MEAT),
				new Dish("chicken", false, 800, Type.MEAT),
				new Dish("french", false, 800, Type.MEAT),
				new Dish("rice", true, 800, Type.MEAT),
				new Dish("season", false, 800, Type.MEAT),
				new Dish("pizza", true, 550, Type.MEAT),
				new Dish("prawns", false, 300, Type.FISH),
				new Dish("salmon", false, 450, Type.FISH)
				);
		
		
		List<String> threeHighCaloricDishNames = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.map(Dish::getName)
				.limit(3)
				.collect(toList());
	
		System.out.println("threeHighCaloricDishNames = " + threeHighCaloricDishNames);
	}
	
	
	public static void case4Collection() {
		List<String> strList = Arrays.asList("11111", "222222", "333333", "4444444");
		
		for(String str : strList) {
			System.out.println("str = " + str);
		}
	}
}
