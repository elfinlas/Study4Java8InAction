package com.study.chap02.quiz;

import com.study.common.Apple;

/**
 * 무게 비교와 색상
 *
 * Created by MHLab on 14/11/2018..
 */

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String weightStr = apple.getWeight() > 150 ? "heavy" : "light";
        return "Apple info = " + weightStr + " color = " + apple.getColor();
    }


}

