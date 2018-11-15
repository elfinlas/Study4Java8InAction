package com.study.chap02.quiz;

import com.study.common.Apple;

/**
 * 무게만 표시
 *
 * Created by MHLab on 14/11/2018..
 */

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "Apple weight = " + apple.getWeight();
    }
}
