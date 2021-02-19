/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rouletteassessment;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author euvinmongwe
 */
public class RouletteAssessment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Roulette roulette = new Roulette();
            roulette.generateRolette();
            Roulette(roulette);

        } catch (Exception ex) {
            Logger.getLogger(RouletteAssessment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @param roulette
     * @throws Exception 
     */
    private static void Roulette(Roulette roulette) throws Exception {
        ArrayList<String> playersName = getPlayersDetail("PlayersName");
        Map<String, ArrayList<String>> playerNumBet = new HashMap<>();
        Map<String, ArrayList<String>> playerOddEven = new HashMap<>();
        ArrayList<String> playNumAmount = new ArrayList<>();
        ArrayList<String> playOddEvenAmount = new ArrayList<>();
        

        for (int i = 0; i < playersName.size(); i++) {

            ArrayList<String> playNumBet = getPlayersDetail(playersName.get(i) + "NumBet");
            playerNumBet.put(playersName.get(i), playNumBet);
            playNumAmount = getPlayersDetail(playersName.get(i) + "NumAmount");
            
            ArrayList<String> playOddEven = getPlayersDetail(playersName.get(i) + "OddEven");
            playerOddEven.put(playersName.get(i), playOddEven);
            playOddEvenAmount = getPlayersDetail(playersName.get(i) + "OddEvenAmount");
            
        }
        roulette.generateBet(playerNumBet,playNumAmount,playerOddEven,playOddEvenAmount);
    }
    
    

    /**
     * gets players details from the file
     * @param input
     * @return
     * @throws Exception 
     */
    private static ArrayList<String> getPlayersDetail(String input) throws Exception {
        ArrayList<String> playersDetail = new ArrayList<>();

        String name = getProperties().getProperty(input);
        String[] arrSplit = name.split(",");

        for (int i = 0; i < arrSplit.length; i++) {
            playersDetail.add(arrSplit[i]);
        }
        return playersDetail;
    }

    /**
     * This Method will get a property file that store players details
     *
     * @return
     * @throws Exception
     */
    private static Properties getProperties() throws Exception {
        String filename = "/Users/euvinmongwe/Desktop/RouletteAssessment/config/playersDetails.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(filename));
        return properties;

    }

}
