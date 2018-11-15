package com.study.chap02.quiz;

/**
 * Created by MHLab on 14/11/2018..
 */

public class Quiz2 {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value =10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
}
