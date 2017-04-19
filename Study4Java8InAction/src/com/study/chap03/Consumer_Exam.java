package com.study.chap03;

/**
 * 
 * @author elfinlas
 * Consumer 예제
 * @param <T>
 */

@FunctionalInterface
public interface Consumer_Exam<T> {
	void accept(T t);
}
