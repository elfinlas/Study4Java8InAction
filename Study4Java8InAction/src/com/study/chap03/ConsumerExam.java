package com.study.chap03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by MHLab on 14/11/2018..
 */

public class ConsumerExam {

    public void runCode() {
        List<String> list = Arrays.asList("123", "abc", "dds", "ddd");
        forEach(list, (String s) -> System.out.println(s) );
    }


    public <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i: list) {
            c.accept(i);
        }
    }

}
