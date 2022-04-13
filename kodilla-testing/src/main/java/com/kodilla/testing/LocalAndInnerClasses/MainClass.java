package com.kodilla.testing.LocalAndInnerClasses;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {

//        ExampleOfLocalAndInnerClasses outerClass = new ExampleOfLocalAndInnerClasses();
//
//        outerClass.someMethod();

//        System.out.println(hashSet2);

        Set<Test2> words = new HashSet<>(Set.of(new Test2("c"), new Test2("b"), new Test2("a")));
        System.out.println(words);

        Set<Test2> sortedWords = words.stream()
                .sorted(Comparator.comparing(Test2::getResource))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(sortedWords);

    }

    public static Set<Test> hashSet2 = new TreeSet<>();

    static {
        hashSet2.add(new Test(100));
        hashSet2.add(new Test(10));
        hashSet2.add(new Test(1));
    };

    public static class Test2 {
        private String resource;

        public Test2(String resource) {
            this.resource = resource;
        }

        public String getResource() {
            return resource;
        }

        @Override
        public String toString() {
            return "Test2{" +
                    "resource='" + resource + '\'' +
                    '}';
        }
    }

    public static class Test implements Comparable<Test> {

        private int id;

        public Test(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Test o) {

            if (this.getId() == o.getId()) {
                return 0;
            } else if (this.getId() > o.getId()) {
                return 1;
            }
            return -1;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "id= " + id + " ";
        }
    }
}
