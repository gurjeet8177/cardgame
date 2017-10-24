/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This cards simulates a deck of card
 * @author gurjeet Sandhu
 * @since june 1, 2107
 * @version 1.0
 */
import java.util.*;
import java.security.*;
public class DeckOfCards {
    //instances variables
    private ArrayList<Card> deck;// its a list of Card objects
    
   
    /**
     * This method creates a deck of cards
     */
    public DeckOfCards(){
        //constructing the same way as we do it for objects
    deck=new ArrayList<Card>();
     String[] faceNames={"two","three","four","five","six","seven","eight","nine","ten","jack","queen","king","ace"};
    String [] suits={"spades","diamonds","hearts","clubs"};
    
    ///for loop 
    //for(String suit:suits) forEach loop
    for(int suit=0;suit<suits.length;suit++){
        for(int faceName=0; faceName<faceNames.length;faceName++){
            //Card card= new Card(suit,faceNames[faceName],faceName+2);if used for each loop
        Card card= new Card(suits[suit],faceNames[faceName],faceName+2);
        deck.add(card);
        }
        
    }
    // we are not writing get and set cause the wouldnt be used as deck doesnt change its instance variable
    }//cpnstructor
    
    
    /***
     * this method shuffles the card
     * 
     */
    public void shuffle(){
        Collections.shuffle(deck);
    
    }
    
    /***
     * this method returns the top most card from the deck
     * @return a card
     */
    
    public Card dealTopCard()
    {
    if(deck.size()>0){ return deck.remove(0);}
    else{
        return null;}
    
    }
    /**
     * this method draws a card
     */
    public Card drawCard()
    {SecureRandom generator=new SecureRandom();
    int randomNumber;
    if(deck.size()>0){
    randomNumber=generator.nextInt(deck.size());
    return deck.remove(randomNumber);
    }
    
    return null;
    } 
    /**
     * its a function to add additional except for 51 cards to the deck
     * @param addingCard would recieves a card that is to be added to deck
     */
    public void addAdditionalCard(Card addingCard){
        if(addingCard!=null){
    deck.add(addingCard);}
       
    }
    /**
     * this function is to size of the deck
     * @return deck s size , or number of cards in deck
     */
    public int size(){
    return deck.size();
    }
    /**
     * this method return a string representing all the cards in the deck
     * @return a string representing all the cards in the deck 
     *
     */
     @Override
     public String toString(){
         String deckString="";
         /*Card card;
         for(int i =0; i<deck.size(); i++){
         card=deck.get(i);
         deckString=deckString+card.toString()+"\n";
         
         }*/
         
         for(Card card:deck){
         deckString=deckString+card.toString()+"\n";
         }
        return deckString; 
     }
     }
    

