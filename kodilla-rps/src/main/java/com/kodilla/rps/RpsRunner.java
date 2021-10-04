package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner playerName = new Scanner(System.in);
        Scanner roundScan = new Scanner(System.in);
        Scanner again = new Scanner(System.in);
        Random random = new Random();

        boolean endIni = false;
        boolean end1 = false;
        boolean end2 = false;
        boolean end3 = false;
        boolean endIniFinish = true;

        int roundNumber = 0;
        int playerScore = 0;
        int computerScore = 0;
        int initNextGame = 0;


        //pętla inicjująca
        while (!endIni) {

            System.out.println("--- NOWA GRA --- \nJak masz na imie?");
            String name = playerName.nextLine();

            //pętla pierwszego poziomu
            while (!end1) {
                System.out.println("Witaj " + name + "! Ile rund chcesz zagrać?");
                int roundNum = roundScan.nextInt();

                //pętla drugiego poziomu
                while (!end2) {
                    String[] rps = {"1", "2", "3"};
                    String computerMove = rps[random.nextInt(rps.length)];
                    String playerMove = null;
                    String playAgain;

                    if (roundNumber == roundNum) {
                        System.out.println("KONIEC GRY!");
                        initNextGame = 1;
                        roundNumber = 0;

                        if (playerScore > computerScore) {
                            System.out.println("ZWYCIESTWO! " + playerScore + " : " + computerScore);
                            computerScore = 0;
                            playerScore = 0;
                        } else if (playerScore == computerScore) {
                            System.out.println("REMIS! " + playerScore + " : " + computerScore);
                            computerScore = 0;
                            playerScore = 0;
                        } else {
                            System.out.println("PRZEGRANA! " + playerScore + " : " + computerScore);
                            computerScore = 0;
                            playerScore = 0;
                        }
                    }

                    if (initNextGame > 0) {
                        System.out.println("\nCzy chcesz zagrać ponownie? tak/nie ");
                        playAgain = again.nextLine();
                        if (!playAgain.equals("tak")) {
                            System.out.println("Dziękujemy za grę!");
                            roundNumber = roundNum;
                            System.exit(0);
                        } else if (playAgain.equals("tak")) {
                            endIni = endIniFinish;
                            break;
                        }
                    }

                    roundNumber++;
                    System.out.println("-------- \nRunda: " + roundNumber);

                    //pętla trzeciego poziomu
                    while (!end3) {

                        String keyMap = "\n Instrukcja obsługi gry:" +
                                "\n klawisz 1 - zagranie 'kamień" +
                                "\n klawisz 2 - zagranie 'papier'" +
                                "\n klawisz 3 - zagranie 'nożyce" +
                                "\n klawisz x - zakończenie gry" +
                                "\n klawisz n - reset gry\n";
                        System.out.println(keyMap);

                        playerMove = scanner.nextLine();

                        if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3") || playerMove.equals("x") || playerMove.equals("n")) {
                            break;
                        }
                        System.out.println("'" + playerMove + "'" + " to niedozwolony ruch, proszę wybrać 1/2/3!");
                    }


                    //KLAWISZ 'x'
                    if (playerMove.equals("x")) {
                        while (true) {
                            System.out.println("Czy na pewno zakończyć grę? tak/nie ");
                            playerMove = scanner.nextLine();
                            if (playerMove.equals("tak")) {
                                System.out.println("Dziękujemy za grę!");
                                System.exit(0);
                                roundNumber = roundNum;
                            } else
                                roundNumber--;
                            break;
                        }
                        continue;
                    }

                    //KLAWISZ 'n'
                    if (playerMove.equals("n")) {
                        while (true) {
                            System.out.println("Czy na pewno zakończyć aktualną rozgrywkę? tak/nie ");
                            playerMove = scanner.nextLine();
                            if (playerMove.equals("tak")) {
                                roundNumber = roundNum;
                                break;
                            } else
                                roundNumber--;
                            break;
                        }
                        continue;
                    }

                    System.out.println(name + " wybrał/a: " + playerMove.replace("1", "kamień").replace("2", "papier").replace("3", "nożyce"));
                    System.out.println("Komputer wybrał: " + computerMove.replace("1", "kamień").replace("2", "papier").replace("3", "nożyce"));


                    //LOGIKA WYGRANEJ/PRZEGRANEJ i REMISU
                    if (playerMove.equals(computerMove)) {
                        System.out.println("Remis!");
                        computerScore++;
                        playerScore++;
                    } else if (playerMove.equals("1")) {
                        if (computerMove.equals("2")) {
                            System.out.println("Przegrałeś/aś rundę!");
                            computerScore++;
                            System.out.println("Wynik: " + "(Ty) " + playerScore + " : " + computerScore + " (Komputer)");
                        }
                        if (computerMove.equals("3")) {
                            System.out.println("Wygrałeś/aś rundę!");
                            playerScore++;
                            System.out.println("Wynik: " + "(Ty) " + playerScore + " : " + computerScore + " (Komputer)");
                        }
                    } else if (playerMove.equals("2")) {
                        if (computerMove.equals("1")) {
                            System.out.println("Wygrałeś/aś rundę!");
                            playerScore++;
                            System.out.println("Wynik: " + "(Ty) " + playerScore + " : " + computerScore + " (Komputer)");
                        }
                        if (computerMove.equals("3")) {
                            System.out.println("Przegrałeś/aś rundę!");
                            computerScore++;
                            System.out.println("Wynik: " + "(Ty) " + playerScore + " : " + computerScore + " (Komputer)");
                        }
                    } else if (playerMove.equals("3")) {
                        if (computerMove.equals("1")) {
                            System.out.println("Przegrałeś/aś rundę!");
                            computerScore++;
                            System.out.println("Wynik: " + "(Ty) " + playerScore + " : " + computerScore + " (Komputer)");
                        }
                        if (computerMove.equals("2")) {
                            System.out.println("Wygrałeś/aś rundę!");
                            playerScore++;
                            System.out.println("Wynik: " + "(Ty) " + playerScore + " : " + computerScore + " (Komputer)");
                        }
                    }
                }
            }
        }
    }
}