package com.study.chap03.quiz;

/**
 * 퀴즈 예제를 위한 클래스
 *
 * Created by MHLab on 15/11/2018..
 */

public class Color {
    private int r;
    private int g;
    private int b;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public String toString() {
        return "r = " + r + " g = " + g + " b = " + b;
    }
}
