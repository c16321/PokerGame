
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
public class Rule {
    
 
    
    private boolean pflag = false;
    public int Judge(List<Cards> hand){ //役の判定

        if (Somecard(hand)==4){
            System.out.println("FourCard");
            return 7;
        }
        if(Flash(hand)==true && Straight(hand)==true){//ストレートフラッシュの判定
            System.out.println("Straightflush");
            return 6;
        }
        if (Flash(hand)==true){
            System.out.println("Flush");
            return 5;           
        }
        if (Straight(hand)==true){
            System.out.println("Straight");
            return 4;
        }
        if (Somecard(hand)==3){
            System.out.println("ThreeCard");
            return 3;  
        }
         if (Pair(Pair(hand))!=null){
            System.out.println("TwoPare");
            return 2; 
         }
        if (pflag==true){
            System.out.println("OnePare");
            return 1; 
        }
        System.out.println("NOPare");
            return 0; 
    }
    /*public String Judge(List<Cards> hand){ //役の判定

        if (Somecard(hand)==4)
            return "FourCard";
        if(Flash(hand)==true && Straight(hand)==true)//ストレートフラッシュの判定
            return "Straightlush";
        if (Flash(hand)==true)
            return "Flaush";
        if (Straight(hand)==true)
            return "Straight";
        if (Somecard(hand)==3)
            return "ThreeCard";
         if (Pair(Pair(hand))!=null)
            return "TwoPare";
        if (pflag==true)
            return "OnePare"; 
        return "NoPair";
    }*/
    

    
    private boolean Flash(List<Cards> hand){//フラッシュの判定
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(0).getSuit() != hand.get(i).getSuit()) {//全てのマークが同じか調べる
                return false;
            }
        }
        return true;
    }
    private boolean Straight(List<Cards> hand){//ストレートの判定
        Cards card = hand.get(0);
        int count = 0;
        for (int i = 1; i < hand.size(); i++)
            if (card.getRank()>hand.get(i).getRank())
                card = hand.get(i);
        for (int i = 0; i < hand.size(); i++) {
            if (card.getRank()+1 == hand.get(i).getRank()) {
                card=hand.get(i);
                count++;
            }
            if (count==4)return true;
        }
        return false;
    }
    private int Somecard(List<Cards> hand){//同じ数字のカードの数
        for (int i = 0; i < hand.size(); i++) {
            int count = 0;
            Cards comp = hand.get(i);
            for (int j = 0; j < hand.size(); j++) {
                if (comp.getRank() == hand.get(j).getRank())
                    count++;
            }
            if (count==3)
                return 3;
            if(count==4)
                return 4;
        }
        return 0;
    }
    


  private List<Cards> Pair(List<Cards> hand){
        if (hand==null)
            return null;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (hand.get(i).getRank() == hand.get(j).getRank()) {
                    hand.remove(hand.get(i));
                    hand.remove(hand.get(j));
                    pflag=true;
                    return hand;
                }
            }
        }
        return null;
    }
  

}

