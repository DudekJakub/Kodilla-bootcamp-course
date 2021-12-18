package ZadanieWyscigiSum;

import java.util.Random;

public class WhileLoopExecutor {

    private int sumaA = 0;
    private int sumaB = 0;
    private Random intGenerator = new Random();

    public void whileTest(int sumaA, int sumaB) {

        int counter = 0;
        int firstRandomInt = intGenerator.nextInt(10);
        int secondRandomInt = intGenerator.nextInt(50);

        while(sumaA > sumaB) {

            counter++;

            sumaA += firstRandomInt;
            sumaB += secondRandomInt;

            System.out.println("Number przebiegu petli = " + counter);
            System.out.println("Suma 'A' = " + sumaA);
            System.out.println("Suma 'B' = " + sumaB + "");

            if(sumaB > sumaA) {
                int counterFinalPosition = counter+1;
                System.out.println("\nAfter " + counter + " runs, at run no." + counterFinalPosition + " the condition sumA > sumB is met");
                System.out.println("Suma 'A' = " + sumaA);
                System.out.println("Suma 'B' = " + sumaB);
            }
        }
    }
}
