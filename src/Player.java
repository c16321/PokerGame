
import java.util.ArrayList;
import java.util.List;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c16321
 */
public class Player {
    private String name;
    private int coins = 0;
    private List<Cards> hand;
    
    public Player(String name,int coins){
        this.name = name;
        this.coins = coins;
        hand = new ArrayList<>();
    }
    public void setCoins(int num){this.coins = num;}
    
    public String getName(){return name;}
    public int getCoins(){return coins;}
    public List<Cards> getHands(){return hand;}
    
    public void bet(int num){
        coins -= num;
    }
    Cards drawOut(int index){
        return hand.remove(index);
    }
    void drawIn(List<Cards> deck){
        hand.add(deck.remove(0));
        
    }
}
