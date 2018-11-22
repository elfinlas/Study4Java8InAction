package com.study.chap03;

import com.study.common.Apple;
import com.study.common.MakeDummyData;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 3.8 예제
 * Created by MHLab on 22/11/2018..
 */

public class LambdaUtilExam {
    private List<Apple> inventory;

    public LambdaUtilExam() {
        inventory = MakeDummyData.getDummyAppleList();
    }

    public void runCode() {
//        exam4Comparator();
//        exam4Predicate();
        exam4Function();
    }

    /**
     * Comparator를 처리하는 예제
     */
    private void exam4Comparator() {
        System.out.println("Sort before");
        inventory.forEach(apple -> System.out.println("Apple weight = " + apple.getWeight() + " color = " + apple.getColor()));

        Comparator<Apple> comparator = Comparator.comparing(Apple::getWeight);
        inventory.sort(comparator.reversed()); //역 정렬

        System.out.println("Sort reverse");
        inventory.forEach(apple -> System.out.println("Apple weight = " + apple.getWeight() + " color = " + apple.getColor()));

        //만약 동일한 무게를 찾는다면 색상 별로 정렬
        inventory.sort(comparator.reversed().thenComparing(Apple::getColor));

        System.out.println("Sort reverse and then...");
        inventory.forEach(apple -> System.out.println("Apple weight = " + apple.getWeight() + " color = " + apple.getColor()));
    }

    /**
     * Predicate 처리하는 예제
     */
    private void exam4Predicate() {
        Predicate<Apple> redApple = apple -> apple.getColor().equals("Red");
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 200);

        inventory.forEach(apple -> {if(redApple.test(apple)) System.out.println("find red Apple = " + apple.toString()); });
        inventory.forEach(apple -> {if(notRedApple.test(apple)) System.out.println("find not red Apple = " + apple.toString()); });
        inventory.forEach(apple -> {if(redAndHeavyApple.test(apple)) System.out.println("find red and heavy Apple = " + apple.toString()); });
    }


    /**
     * Function 예제
     */
    private void exam4Function() {
        Function<Integer, Integer> function1 = x -> x + 1;
        Function<Integer, Integer> function2 = x -> x * 2;
        Function<Integer, Integer> funcAndThen = function1.andThen(function2);
        Function<Integer, Integer> funcCompose = function1.compose(function2);

        System.out.println("Function AndThen = " + funcAndThen.apply(1));
        System.out.println("Function Compose = " + funcCompose.apply(1));

        Function<String, String> funcAddHeader = Letter::addHeader;
        Function<String, String> funcAddFooter = Letter::addFooter;
        Function<String, String> funcTransFormatingPipeLine = funcAddHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);

        String str = funcTransFormatingPipeLine.apply("Test labda is Good");
        System.out.println("str= " + str);
    }
}

/**
 * Function 예제를 위한 클래스
 */
class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
