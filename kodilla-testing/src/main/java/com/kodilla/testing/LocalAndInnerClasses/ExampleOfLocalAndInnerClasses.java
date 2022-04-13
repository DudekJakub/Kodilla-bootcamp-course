package com.kodilla.testing.LocalAndInnerClasses;

public class ExampleOfLocalAndInnerClasses {

    public int someVariableOfOuterClass = 1;

    public void someMethod() {
        System.out.println("Hello! I am outer_class.");

        class LocalClassExample {
            private final int someVariableOfLocalClass = 3;

            public void printFromLocalClass() {
                System.out.println("Hello! I am nested Local_class.");
            }
        }

        LocalClassExample localClassExample = new LocalClassExample();
        localClassExample.printFromLocalClass();
    }

    public static class InnerClass {
        public int someVariableOfInnerClass = 2;

        public void someMethodOfInnerClass() {
            System.out.println("Hello! I am inner_class.");
        }


    }
}
