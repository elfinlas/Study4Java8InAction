package com.study.chap03.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MHLab on 15/11/2018..
 */

public class Quiz {

    public void runCode() {

    }

    /**
     * Quiz 3-7
     */
    private void quiz3_7() {
        List<String> colorList = Arrays.asList("1,2,3","5,6,7","10,22,42");
        TriFuction<Integer, Integer, Integer, Color> f1 = Color::new; //이와 같은 형태로 전달
        map(colorList, Color::new).forEach(color -> System.out.println("color = " + color.toString()));
    }

    /**
     * Quiz 3-7에서 사용
     * @param colorList
     * @param f
     * @return
     */
    private List<Color> map(List<String> colorList, TriFuction<Integer, Integer, Integer, Color> f) {
        List<Color> result = new ArrayList<>();
        for (String str : colorList) {
            int r = Integer.parseInt(str.split(",")[0]);
            int g = Integer.parseInt(str.split(",")[1]);
            int b = Integer.parseInt(str.split(",")[2]);
            result.add(f.apply(r, g, b));
        }
        return result;
    }



}
