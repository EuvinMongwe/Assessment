package rouletteassessment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author euvinmongwe
 */
public class Roulette {

    /**
     * winningN
     */
    private int winningN;

    /**
     *
     * @return
     */
    public int getWinningN() {
        return winningN;
    }

    /**
     *
     * @param winningN
     */
    public void setWinningN(int winningN) {
        this.winningN = winningN;
    }
    
    /**
     * THIS METHOD WILL GENERATE A BET AND DETERMINE WHETHER PLAYERS HAVE WON
     * @param playerNumBet
     * @param playerOddEven
     * @param betAmount
     */
    public void generateBet(Map<String, ArrayList<String>> playerNumBet, ArrayList<String> playNumAmount, Map<String, ArrayList<String>> playerOddEven, ArrayList<String> playOddEvenAmount) {
        int winningNumber = getWinningN();
        double winnings = 0.0;
        double betAmount = 0.0;
        String outcome = null;
        for (Map.Entry<String, ArrayList<String>> entry : playerNumBet.entrySet()) {
            String name = (String) entry.getKey();
            ArrayList<String> NumberBetList = entry.getValue();
            for (int i = 0; i < NumberBetList.size(); i++) {
                int number = Integer.parseInt(NumberBetList.get(i));
                betAmount = Double.parseDouble(playNumAmount.get(i));
                if (winningNumber == number) {
                    winnings = betAmount * 36;
                    outcome = "WIN";
                } else {
                    winnings = 0.0;
                    outcome = "LOSS";
                }

                displayWinner(name, winningNumber, NumberBetList.get(i), outcome, winnings);
            }

        }
        for (Map.Entry<String, ArrayList<String>> entry : playerOddEven.entrySet()) {
            String name = (String) entry.getKey();

            ArrayList<String> OddEvenBetList = entry.getValue();
            for (int i = 0; i < OddEvenBetList.size(); i++) {
                String bet = OddEvenBetList.get(i);
                betAmount = Double.parseDouble(playOddEvenAmount.get(i));
                String winEvenOdd = isEvenNumber(winningNumber);
                if (winEvenOdd.equalsIgnoreCase(bet)) {
                    outcome = "WIN";
                    winnings = betAmount * 2;
                } else {
                    outcome = "LOSS";
                    winnings = 0.0;
                }
                displayWinner(name, winningNumber, bet, outcome, winnings);
            }
        }
    }

    /**
     * This Method will generate a winning number
     *
     * @return
     */
    @SuppressWarnings("empty-statement")
    public void generateRolette() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        @SuppressWarnings("empty-statement")
        Runnable generateWinningNumber;
        generateWinningNumber = () -> {
            int min = 1;
            int max = 36;

            setWinningN(((int) (Math.random() * (max - min))) + min);;
        };

        executor.scheduleAtFixedRate(generateWinningNumber, 0, 30, TimeUnit.SECONDS);
    }

    /**
     * This method will compare winning number and determine whether its an odd
     * or even number
     *
     * @param winning
     * @return
     */
    private String isEvenNumber(int winning) {
        if (winning % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }

    /**
     * This method will generate winnings for each player
     *
     * @param player
     * @param winningNumber
     * @param betType
     * @param outcome
     * @param winnings
     */
    private void displayWinner(String player, int winningNumber, String betType, String outcome, double winnings) {
        System.out.println("         ");
        System.out.println("Number:" + winningNumber);
        System.out.println("Player      Bet     Outcome     Winnings");
        System.out.println("---");
        System.out.println(player + "     " + betType.toUpperCase() + "     " + outcome.toUpperCase() + "     " + winnings);
        System.out.println("         ");
        int count=0;
        
        if(outcome.equalsIgnoreCase("WIN")){
            
        }
    }

    /**
     * This Method will display total earnings for players
     *
     * @param player
     * @param totWin
     * @param totBet
     */
    private void displayTotalWinnings(String[] player, int totWin[], double totBet[]) {
        for (int i = 0; i < player.length; i++) {
                System.out.println("Player        Total Win        Total Bet");
                System.out.println("---");
                System.out.println(player[i] + "        " + totWin[i] + "        " + totBet[i]);
        }

    }

}
