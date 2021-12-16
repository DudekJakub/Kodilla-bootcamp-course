package CodilityTest;

import java.util.Arrays;

public class Lesson2Arrays {

    private int[] nTable = {3, 8, 9, 7, 6};

    public int[] solution(int[] A, int K) {

        int first = A[A.length-5];

        for (int i = 0; i <= A.length-2; i++) {
            A[i] = A[i+1];
            if(i==A.length-2) {
                A[A.length-1] = first;
            }
        }
        Arrays.stream(A).forEach(System.out::print);

        return A;
    }

    public int[] getnTable() {
        return nTable;
    }



    public static void main(String[] args) {

        int K = 1;

        Lesson2Arrays lesson2Arrays = new Lesson2Arrays();
        lesson2Arrays.solution(lesson2Arrays.getnTable(), 2);
    }
}
