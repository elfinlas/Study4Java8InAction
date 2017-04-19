package com.study.chap03;

/**
 * 
 * @author elfinlas
 * Predicate 예제
 * @param <T>
 */

@FunctionalInterface
public interface Predicate_Exam<T> {
	boolean test(T t);
}
