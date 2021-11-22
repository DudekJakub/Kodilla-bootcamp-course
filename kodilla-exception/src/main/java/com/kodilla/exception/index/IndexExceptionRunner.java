package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {

    public static void main (String[] args) {

     VideoCollector video1 = new VideoCollector();
     List<String> collection = video1.getCollection();

     video1.getCollection().get(0);

        if (collection.size() >= 2) {
            String move1 = collection.get(0);
            String move2 = collection.get(1);
            System.out.println(move1);
            System.out.println(move2);
        }
    }
}
