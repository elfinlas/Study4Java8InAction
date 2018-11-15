package com.study.chap03;

import com.study.common.Apple;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 생성자 레퍼런스를 테스트 하는 예제
 *
 * Created by MHLab on 15/11/2018..
 */

public class ConstructorReferExam {

    public void runCode() {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> appleList = map(weights, Apple::new);
        //List<Apple> appleList3 = map(weights,  (weight) -> new Apple(weight));  //위와 동일한 코드

        for (Apple apple : appleList) {
            System.out.println("apple = " + apple.toString());
        }

        List<String> colors = Arrays.asList("red", "green", "yello", "green");
        List<Apple> appleList2 = map(weights, colors, Apple::new );
        for (Apple apple : appleList2) {
            System.out.println("apple = " + apple.toString());
        }
    }


    /**
     * 사이즈만 받아서 처리하는 메서드
     * @param list
     * @param f
     * @return
     */
    private List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i:list) {
            result.add(f.apply(i));
        }
        return result;
    }

    /**
     * 사이즈와 컬러를 받아서 처리하는 메서드
     * @param weightList
     * @param colorList
     * @param f
     * @return
     */
    private List<Apple> map(List<Integer> weightList, List<String> colorList, BiFunction<Integer, String, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (int i=0; i<weightList.size(); i++) {
            result.add(f.apply(weightList.get(i), colorList.get(i)));
        }
        return result;
    }

}
