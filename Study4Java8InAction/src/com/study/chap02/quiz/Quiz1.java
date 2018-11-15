package com.study.chap02.quiz;

import com.study.chap02.quiz.AppleFancyFormatter;
import com.study.chap02.quiz.AppleFormatter;
import com.study.chap02.quiz.AppleSimpleFormatter;
import com.study.common.Apple;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MHLab on 14/11/2018..
 */

public class Quiz1 {

    public static void runQuiz() {
        List<Apple> appleList = Arrays.asList(new Apple(120, "Yello"), new Apple(161, "Green"), new Apple(148, "Red"));

        //Quiz1 2-1
        prettyPrintApple(appleList, new AppleFancyFormatter());
        prettyPrintApple(appleList, new AppleSimpleFormatter());
    }

    /**
     * Quiz1 2-1
     * @param inventory
     */
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for(Apple apple: inventory) {
            String output = formatter.accept(apple);
            System.out.println("output = " + output);
        }
    }
}

