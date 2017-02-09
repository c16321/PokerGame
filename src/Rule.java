
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

public class Rule{
    
    public int numberJudge=0; /* 役の判定用変数 */
   
    public int judge(List<Cards> hand){
                
        for(int i=0; i<5; i++){
            for(int j=i+1; j<5; j++){
                if(hand.get(i).getRank() == hand.get(j).getRank()) numberJudge++;
            }
        }
        
        if(numberJudge == 1) System.out.println("ワンペア");
        if(numberJudge == 2) System.out.println("ツーペア");
        if(numberJudge == 3) System.out.println("スリーカード");
        if(numberJudge == 4) System.out.println("フルハウス");
        if(numberJudge == 6) System.out.println("フォーカード");
        if(numberJudge == 0) System.out.println("ノーペア");
        return numberJudge;
        
        }
    }
    


