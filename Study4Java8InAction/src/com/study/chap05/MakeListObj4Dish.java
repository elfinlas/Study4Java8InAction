package com.study.chap05;

import java.util.Arrays;
import java.util.List;

import com.study.res.Dish;
import com.study.res.Dish.Type;

/**
 * 
 * @author elfinlas
 *	Stream 에서 사용할 Dish 리스트를 만들어주는 클래스
 */

public class MakeListObj4Dish {
	public static List<Dish> getDishList() {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Type.MEAT),
				new Dish("beef", false, 800, Type.MEAT),
				new Dish("chicken", false, 800, Type.MEAT),
				new Dish("french", false, 800, Type.MEAT),
				new Dish("rice", true, 800, Type.MEAT), //true
				new Dish("season", false, 800, Type.MEAT),
				new Dish("pizza", true, 550, Type.MEAT), //true
				new Dish("prawns", false, 300, Type.FISH),
				new Dish("salmon", false, 450, Type.FISH)
				);
		return menu;
	}
}
