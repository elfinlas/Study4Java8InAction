package com.study.common;

import java.util.Arrays;
import java.util.List;

/**
 * 예제 등에서 활용할 임시 데이터를 만들어주는 클래스
 * Created by MHLab on 22/11/2018..
 */

public class MakeDummyData {

    /**
     * Apple Dummy 데이터를 만들어주는 메서드ㄴ
     * @return
     */
    public static List<Apple> getDummyAppleList() {
        return Arrays.asList(new Apple(300, "Red"), new Apple(110, "Green"), new Apple(90, "RedBlue"),
                new Apple(210, "RedGreen"), new Apple(220, "GreenYellow"), new Apple(300, "GreenYellow"));
    }
}
