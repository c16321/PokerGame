import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c16321
 */
public class PorkerTester {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        List<Cards> cards = Cards.newDeck();
        
        int prank,crank;
        Player human = new HumanPlayer("human",100);
        Player cp = new ComputerPlayer("cp",100);
        Rule rule = new Rule();
        
        for (int i = 0; i < 5; i++) {
            human.drawIn(cards);
            cp.drawIn(cards);
        }
        
        List<Cards> hand = human.getHands();
        List<Cards> cphand=cp.getHands();
        

        do{
            hand.forEach(System.out::println);
            System.out.println("1~"+(hand.size())+"で捨てる、範囲外でカードを引く");
            int i = stdIn.nextInt();
            if(i<1 || i>hand.size())
                break;
            hand.remove(hand.get(i-1));
        }while(human.getHands().size()>0);

        System.out.println("引き直し");
        while(hand.size()<5){
            human.drawIn(cards);
        }

        System.out.println(human.getName()+"の手札");
        hand.forEach(System.out::println);
        prank=rule.Judge(hand);
        //System.out.println(rule.Judge(hand));
        
        
       System.out.println(cp.getName()+"の手札");
        cphand.forEach(System.out::println);
        crank=rule.Judge(cphand);
        //System.out.println(rule.Judge(cphand));
        
        if(prank>crank)
            System.out.println(human.getName()+"の勝ち");
        else if(prank==crank)
            System.out.println("引き分け");
        else
            System.out.println(cp.getName()+"の勝ち");
    }
    
}