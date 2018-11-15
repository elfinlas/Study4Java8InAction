package com.study.chap03;

import com.study.common.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate를 다루는 예제
 *
 * Created by MHLab on 14/11/2018..
 */

public class PredicateExam {

    public void runCode() {
        Predicate<String> nonEmptyStrPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmptyStrList = filter(Arrays.asList("" ,"123", "1234s", "", "abvc!"), nonEmptyStrPredicate);

        for (String str : nonEmptyStrList) {
            System.out.println(str);
        }



    }


    private <T>List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) { results.add(s); }
        }
        return results;
    }
}
