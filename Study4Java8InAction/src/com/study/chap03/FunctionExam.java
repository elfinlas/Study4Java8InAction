package com.study.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by MHLab on 14/11/2018..
 */

public class FunctionExam {

    public void runCode() {
        //map(Arrays.asList("lambdas", "2342", "Java", "Python"), (String s) -> s.length());
        List<Integer> list = map(Arrays.asList("lambdas", "2342", "Java", "Python"), String::length);
        list.forEach(integer -> System.out.println("Integer = " + integer));
    }

    public <T,R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s: list) {
            result.add(f.apply(s));
        }
        return result;
    }

}
