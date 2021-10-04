package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        try {
            if (b == 0) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            System.out.println("Ups! Coś poszło nie tak... Error: " + e);
        } finally {
            System.out.println("(Pamiętaj, nie dziel przez 0!)");
        }
        return a / b;
    }
    
    public static void main (String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = firstChallenge.divide(3, 0 );

        System.out.println(result);
    }
}
