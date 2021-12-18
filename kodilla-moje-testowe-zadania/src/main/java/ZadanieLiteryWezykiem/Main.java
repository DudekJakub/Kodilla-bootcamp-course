package ZadanieLiteryWezykiem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DequePlusFor dequePlusFor = new DequePlusFor();
        List<StringBuilder> list = dequePlusFor.literyWezykiem(50,50,"a", false);
        dequePlusFor.separateOddAndEvenList(list);
    }
}
