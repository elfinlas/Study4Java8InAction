package com.study.chap03;

/**
 * 
 * @author elfinlas
 * Function 예제
 *
 * @param <T>
 * @param <R>
 */

@FunctionalInterface
public interface Function_Exam<T, R> {
	R apply(T R);
}
