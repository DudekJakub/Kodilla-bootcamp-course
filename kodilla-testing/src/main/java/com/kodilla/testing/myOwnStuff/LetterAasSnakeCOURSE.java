package com.kodilla.testing.myOwnStuff;

import java.util.*;
import java.lang.*;

public class LetterAasSnakeCOURSE {
    ArrayList<String> transferTask1;
    ArrayList<String> transferTask2;

    public void TransferDequeToList(ArrayDeque<String> puttingAletter) {
        transferTask1 = new ArrayList<>();
        transferTask2 = new ArrayList<>();
    }

    public void makingList(Deque<String> theQueue) {
        System.out.println("ArrayList based on Deque -> EVEN result: " + "\n");
        while (theQueue.size() > 0) {

            String theTask = theQueue.poll();

            if(theTask.length() % 2 == 0) {
                transferTask1.add(theTask + " " + theTask.length() + "\n");
            }
            else {
                transferTask2.add(theTask + " " + theTask.length() + "\n");
            }
        }

        System.out.println(transferTask1.toString().replace("[","").replace("]","").replace(",",""));
        System.out.println(" ");
        System.out.println("ArrayList based on Deque -> ODD result: " + "\n");
        System.out.println(transferTask2.toString().replace("[","").replace("]","").replace(",",""));
    }

    public static String generateRandomAString (int maxLength) {
        String a = "a";
        Random random = new Random();
        int len = random.nextInt(maxLength);

        while (a.length() < len) {
            a = a + "a";
        } return a;
    }

    public static void main(String[] args) {

        ArrayDeque<String> puttingAletter = new ArrayDeque<String>();

        for (int i=0; i<50; i++) {
            String letterA = generateRandomAString(50);
            puttingAletter.add(letterA);
        }
            LetterAasSnakeCOURSE taskExecutor = new LetterAasSnakeCOURSE();
            taskExecutor.TransferDequeToList(puttingAletter);
            taskExecutor.makingList(puttingAletter);

    }
}









