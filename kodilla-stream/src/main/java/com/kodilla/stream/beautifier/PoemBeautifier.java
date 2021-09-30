package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String example, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(example);
        System.out.println("BEFORE: " + example + " AFTER: " + result);
    }

    public static String toUpperCase(String example) {
        return example.toUpperCase();
    }

    public static String substring(String example) {
        return example.substring(0, 24);
    }

    public static String toUpperCaseANDreplaceFirst(String example) {
        return example.toLowerCase().replaceFirst("i","I");
    }
}
