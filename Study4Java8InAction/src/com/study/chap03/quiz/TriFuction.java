package com.study.chap03.quiz;

/**
 * Created by MHLab on 15/11/2018..
 */

public interface TriFuction<T, U, V, R> {
    R apply(T t, U u, V v);
}
