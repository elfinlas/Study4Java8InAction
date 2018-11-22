package com.study.chap03;

import com.study.common.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 3.7 람다, 메서드 레퍼런스 활용 예제
 * Created by MHLab on 22/11/2018..
 */

public class LambdaMethodReferExam {
    private List<Apple> inventory; //예제를 위해 Apple 객체를 담을 리스트

    /**
     * Default Construct
     */
    public LambdaMethodReferExam() {
        inventory = getAppleList(Apple::new);
    }

    /**
     * 실제 실행 코드
     */
    public void runCode() {
        System.out.println("Sort before");
        inventory.forEach(apple -> System.out.println("Apple weight = " + apple.getWeight() + " color = " + apple.getColor()));

        //코드 전달 방법
        //inventory.sort(new AppleComparator());

        //익명 클래스 사용
//        inventory.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });

        //lambda 사용
        //inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        //메서드 레퍼런스 사용
        inventory.sort(Comparator.comparing(Apple::getWeight));

        System.out.println("Sort after");
        inventory.forEach(apple -> System.out.println("Apple weight = " + apple.getWeight() + " color = " + apple.getColor()));
    }


    /**
     * 예제의 리스트를 사용하기 위한 메서드
     * @param bf
     * @return
     */
    private List<Apple> getAppleList(BiFunction<Integer, String, Apple> bf) {
        List<Apple> result = new ArrayList<>();
        result.add(bf.apply(300, "Red"));
        result.add(bf.apply(110, "Green"));
        result.add(bf.apply(90, "RedBlue"));
        result.add(bf.apply(210, "RedGreen"));
        result.add(bf.apply(220, "GreenYellow"));
        return result;
    }


    /**
     * Apple 객체의 무게를 비교하기 위한 내부 클래스 (코드 전달 예제)
     */
    class AppleComparator implements Comparator<Apple> {

        /**
         * 동일한 경우 0, 첫 값이 큰 경우 양수, 첫 값이 작은 경우 음수
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }
}
