/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rouletteassessment;

/**
 *
 * @author euvinmongwe
 */
public class Player {
    
    private String playerName;
    
    private String playerBet;
    
    private int playerNumber;
    
    private double betAmount;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(String playerBet) {
        this.playerBet = playerBet;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(double betAmount) {
        this.betAmount = betAmount;
    }
    
}
