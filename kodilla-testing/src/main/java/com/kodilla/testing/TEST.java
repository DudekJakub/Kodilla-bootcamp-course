package com.kodilla.testing;

import java.util.TimerTask;

public class TEST {
        int secondsPassed = 0;

        java.util.Timer timer = new java.util.Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                System.out.println("Sec passed" + secondsPassed);
            }
        };

        public void start() {
            timer.scheduleAtFixedRate(task, 1000, 1000);
        }

        public int getSecondsPassed() {
            return secondsPassed;
        }

        public static void main(String[] args) {
            TEST timer1 = new TEST();
            timer1.start();

            int second = timer1.getSecondsPassed();
            System.out.println(second);
            second++;

            System.out.println(second);


            if (timer1.getSecondsPassed() == 5) {
                System.out.println("dupa!");
            }
        }
    }


