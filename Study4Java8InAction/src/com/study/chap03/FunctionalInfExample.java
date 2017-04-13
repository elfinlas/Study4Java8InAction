package com.study.chap03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Java8에서 제공하는 기본 함수형 인터페이스의 간단 사용 예제 
 * @author elfinlas
 *
 */
public class FunctionalInfExample {
	public static void main(String [] args) {
		//Runnable
		Runnable r = () -> System.out.println("hello functional");
		r.run();
		
		//Supplier
		Supplier<String> s = () -> "hello supplier";
		String result4Supplier = s.get();
		System.out.println("Supplier result = " + result4Supplier);
		
		//Consumer
		Consumer<String> c = str -> System.out.println(str);
		c.accept("hello consumer");
		
		//Function
		Function<String, Integer> f = str -> Integer.parseInt(str);
		Integer result4Function = f.apply("1");
		System.out.println("Function result = " + result4Function);
		
		//Predicate
		Predicate<String> p = str -> str.isEmpty();
		boolean result4Predicate = p.test("hello");
		System.out.println("Predicate result = " + result4Predicate);

		//UnaryOperator
		UnaryOperator<String> u = str -> str + " operator";
		String result4UnaryOperator = u.apply("hello unary");
		System.out.println("UnaryOperator result = " + result4UnaryOperator);
		
		//BinaryOperator
		BinaryOperator<String> b = (str1, str2) -> str1 + " " + str2;
		String result4BinaryOperator = b.apply("hello", "binary");
		System.out.println("BinaryOperator result = " + result4BinaryOperator);
		
		//BiPredicate
		BiPredicate<String, Integer> bp = (str, num) -> str.equals(Integer.toString(num));
		boolean result4BiPredicate = bp.test("1", 1);
		System.out.println("BiPredicate result = " + result4BiPredicate);
		
		//BiConsumer
		BiConsumer<String, Integer> bc = (str, num) -> System.out.println(str + " :: " + num);
		bc.accept("숫자", 5);

		//BiFunction
		BiFunction<Integer, String, String> bf = (num, str) -> String.valueOf(num) + str;
		String result4BiFunction = bf.apply(5, "678");
		System.out.println("BiFunction result = " + result4BiFunction);
		
		//Comparator
		Comparator<String> cp = (str1, str2) -> str1.compareTo(str2);
		int result4Comparator = cp.compare("aaa", "bbb");
		System.out.println("Comparator result = " + result4Comparator);
		
	}
	
}
