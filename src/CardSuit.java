/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c16321
 */
public enum CardSuit {
    diamond(0),spade(1),clover(2),heart(3);
    
    private final int id;
    
    private CardSuit(final int id){
        this.id=id;
    }
    
}
