package com.study.chap03;

import com.study.common.Apple;

import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;

/**
 * Created by MHLab on 15/11/2018..
 */

public class ComparatorExam {

    public void runCode() {
        //무게를 기준으로 정렬하는 예제
        System.out.println("Sort before");
        List<Apple> inventory = Arrays.asList(new Apple(120, "Yello"), new Apple(161, "Green"), new Apple(148, "Red"));
        inventory.forEach(System.out::println);

        System.out.println("=========");
        System.out.println("Sort after");
        inventory.sort(comparing(Apple::getWeight));
        inventory.forEach(System.out::println);

        System.out.println("=========");
        System.out.println("Sort reverse");
        inventory.sort(comparing(Apple::getWeight).reversed());
        inventory.forEach(System.out::println);

        System.out.println("=========");
        System.out.println("Sort weight and color");
        inventory.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor));
        inventory.forEach(System.out::println);
    }
}
