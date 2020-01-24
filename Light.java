package com.org.transport;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Light {

    //0: red light, 1: green light
    //Initial settings l2, l3 are green lights; l1, l4 are red lights
    //Initial settings l6, l7 are green; l5, l8 are red

    private int l1 = 0;
    private int l2 = 1;
    private int l5;
    private int l6;
    private int redGap;
    private int greenGap;
    private int delayGap;
    private int gap;
    private int specialGap;

    //Set the timer
    public Light() {

        //Get related parameters of the parameter setting window
        redGap = Integer.parseInt(SettingGui.redText.getText());
        greenGap = Integer.parseInt(SettingGui.greenText.getText());
        delayGap = Integer.parseInt(SettingGui.delayText.getText());
        gap = redGap + greenGap;
        //Determine how to set the traffic lights at the initial moment of the CR2 intersection。
        if (redGap > delayGap) {
            l5 = 1;
            l6 = 0;
            specialGap = delayGap + greenGap;
        } else {
            l5 = 0;
            l6 = 1;
            specialGap = delayGap - redGap;
        }

        setLightTimer();

    }

    public void setLightTimer() {

        Timer t1 = new Timer();
        // Control CR1, according to the parameters in the title, it needs to be executed after 12 seconds, and it is executed every 14s. You can set it yourself in this program.
        //According to the parameters in the question: (new light1 (), 120 * 1000, 140 * 1000);
        t1.schedule(new light1(), greenGap * 1000, gap * 1000);

        Timer t2 = new Timer();
        // Control CR1, according to the parameters in the question, need to be executed after 14 seconds, and executed every 14s. You can set it yourself in this program.
        // According to the parameters in the question: (new light2 (), 140 * 1000, 140 * 1000);
        t2.schedule(new light2(), gap * 1000, gap * 1000);

        Timer t3 = new Timer();
        // Control CR2, according to the parameters in the title, it needs to be executed after 4 seconds, and it is executed every 14s. You can set it yourself in this program.
        //According to the intent parameters: (new light3 (), 40 * 1000, 140 * 1000);
        t3.schedule(new light3(), specialGap * 1000, gap * 1000);

        Timer t4 = new Timer();
        // Control CR2, according to the parameters in the question, it needs to be executed after 6 seconds, and it is executed every 14s. You can set it yourself in this program.
        // According to the parameters in the question: (new light4 (), 60 * 1000, 140 * 1000);
        t4.schedule(new light4(), delayGap * 1000, gap * 1000);
    }

    //Controlling CR1 intersection
    private class light1 extends TimerTask {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (l1 == 0) {
                l1 = 1;
                l2 = 0;
            }
        }
    }

    //Controlling CR1 intersection
    private class light2 extends TimerTask {
        @Override
        public void run() {
            if (l1 == 1) {
                l1 = 0;
                l2 = 1;
            }
        }
    }
    //Controlling CR2 intersection
    private class light3 extends TimerTask {
        @Override
        public void run() {
            if (l5 == 0) {
                l6 = 0;
                l5 = 1;

            }
        }
    }
    //Controlling CR2 intersection
    private class light4 extends TimerTask {
        @Override
        public void run() {
            if (l5 == 1) {
                l6 = 1;
                l5 = 0;
            }
        }
    }

    public int getl1() {
        return l1;
    }

    public int getl2() {
        return l2;
    }

    public int getl5() {
        return l5;
    }

    public int getl6() {
        return l6;
    }

}