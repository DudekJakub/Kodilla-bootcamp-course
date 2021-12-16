import java.util.*;

public class mainClass {

    int[] table = new int[] {-3, -2, -1, 0, 1, 2, 3};
    int[] table1 = new int[] {1,2,2};

    public void tylkoBezwzgledne(int[] putTable) {

        Arrays.stream(putTable)
                .filter(e -> e >= 0)
                .forEach(System.out::println);
    }

    public void mediana(int[] putTable) {

        Arrays.sort(putTable);

        //median
        if (putTable.length % 2 !=0) {
            System.out.println("Mediana = " + putTable[putTable.length/2]);
        } else {
            System.out.println("Mediana = " + (putTable[putTable.length/2] + putTable[putTable.length/2-1])/2.0);
        }
    }

    public void moda(int[] putTable) {

        int maxNumber = 0;
        int maxAppearances = 0;

        for (int i=0; i<putTable.length; i++) {
            int count = 0;
            for (int j=0; j<putTable.length; j++) {

                System.out.println(count);
                if (putTable[i] == putTable[j])
                    count++;
            }

            if (count > maxAppearances) {
                maxNumber = putTable[i];
                maxAppearances = count;
            }
        }
        System.out.println("\nModa = " + maxNumber);
    }

    public void whilePractice() {

        int licznik = 1;

        while (licznik<10) {
            System.out.print(licznik + ", ");
            licznik++;
                if (licznik == 10)
                System.out.print(licznik);
        }
    }

    public void silnia(int number) {

        int n = 0;
        int result;
        List<Integer> nList = new ArrayList<>();

        for (int i=0; i<number; i++) {
            n++;
            nList.add(n);
            if (i == number-1) {
                result = nList.stream().reduce(1, (x,y) -> x * y);
                System.out.println(result);
            }
        }
    }

    public void palindrom(String word) {

        int ini = 0;

        for (int i=0; i<word.length(); i++) {
            char a = word.charAt(i);
            for (int j=word.length()-1; j>=0; j--) {
                char b = word.charAt(j);

                if (a != b) {
                    ini = 1;
                } else {
                    ini = 2;
                }
            }
        }
        if (ini == 1) {
            System.out.println("Podane slowo nie jest polindromem!");
        } else if (ini == 2) {
            System.out.println("Podane slowo jest polindromem!");
        }
    }

    public void getHighestInt(int...numbers) {

        int ini = 0;
        int[] n = numbers;
        Arrays.sort(n);

        for (int i=0; i<numbers.length; i++) {
            ini++;

            if (ini == numbers.length) {
                System.out.println("Najwieksza liczba z podanych to: " + n[i]);
            }
        }
    }

    public void loopInsideLoop() {

        for (int i=1; i<=10; i++) {
            if (i % 2 > 0) {
                continue;
            }
            innerLoop: for (int j=1; j<=10; j++) {
                if (j>i) {
                    continue;
                }
                System.out.println(j);
            }
            System.out.println("");
        }
    }

    public void sumowanieCiaguLiczbTablica(int...numbers) {

//        System.out.println(Arrays.stream(numbers).reduce(0, (a, b) -> a+b));

        int sum = 0;
        int[] n = numbers;

        for (int i=0; i<numbers.length; i++) {
           if (i==0) {
               continue;
            }
           if (i==1) {
               sum = n[0] + n[i];
           } else {
               sum = sum + n[i];
           }
        }
        System.out.println("\nWynik sumowania ciagu liczb w tablicy wynosi: " + sum);
    }

    public void sumowanieCiaguLiczbInteger(int numberValue) {

        int sum = 0;

        if (sum % 2 == 0) {
            sum = (numberValue/2) * (numberValue+1);
        } else {
            sum = (numberValue+1) / 2 * numberValue;
        }

        System.out.println("Wynik sumowanie ciagu liczb Integer wynosi: " + sum);
    }

    public static void main(String[] args) {

       mainClass mC = new mainClass();

//         mC.tylkoBezwzgledne(mC.table);

//         mC.mediana(mC.table1);

         mC.moda(mC.table1);

//         mC.whilePractice();

//         mC.silnia(4);

//         mC.palindrom("kajak");

//         mC.getHighestInt(20,492,102394,284740,1999992);

//         mC.loopInsideLoop();

//         mC.sumowanieCiaguLiczbTablica(1,2,3,4,5,6,7,8,9,10);
//
//         mC.sumowanieCiaguLiczbInteger(10);

    }
}
