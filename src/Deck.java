import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author c16321
 */
import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck;
    
    public Deck(){
        deck = new ArrayList<>();
    }
    public Card withdraw(int num){
        if(num>deck.size()) num = deck.size();
        return deck.remove(num);
    }

    Card remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
