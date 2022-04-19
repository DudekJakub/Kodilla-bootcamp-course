package functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StringConsumerExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kasia", "Kuba", "Bartek");

        System.out.println("BEFORE JAVA 8 AND FUNCTIONAL INTERFACES");
        printList(names, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });


        System.out.println("\nAFTER JAVA 8 AND FUNCTIONAL INTERFACES");
        printList(names, str -> System.out.println(str));
    }

    public static void printList(List<String> names, Consumer<String> consumer) {
        for (String str : names) {
            consumer.accept(str);
        }
    }
}
