
import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 *
 * @author Gurjeet Sandhu(200354737)
 * @version 1.0
 * @since 15 June, 2017 
 */
public class Cardoncard {

    /**
     * @param args the command line arguments
     */
    
    
    
   public  DeckOfCards deck1= new DeckOfCards();//creates a new pile of card object named deck1
        
    public    DeckOfCards deck2= new DeckOfCards();//creates a new pile of card object named deck2
        public static int p1s=0;
        public static int p2s=0;
    public static void main(String[] args) {
        // TODO code application logic here
        
             try{
    DeckOfCards deck1= new DeckOfCards();//creates a new pile of card object named deck1
        
     DeckOfCards deck2= new DeckOfCards();//creates a new pile of card object named deck2
       
           //////////
         System.out.println("*****************************************************"
                 + "******************************************************************************************************"); 
         
         System.out.println("*********    CARD    ***********************   ON    *****************    CARD           ****************"); 
         
            System.out.println("****************************************************************"
                    + "********************************************************************************************"); 
       for(int p=0;p<3;p++) {//this loop would enable three rounds of game
           
           System.out.println("Round Number:   "+(p+1));
           System.out.println();
           ArrayList<Card> pile;//creats an aray of card object
       pile=new ArrayList<Card>(500);
         
         
        
        int player1score=0;
        int player2score=0;
        
        int winnerSelectionMethod=0;//it would be used to selct one of two methods of winning.
           
           
           
       deck1.shuffle();
       deck2.shuffle();
        Card c1 = new Card("spades","three",15);//its an invalid card added to start loop
       // pile.add(c1);
        
      
        Card c2 = new Card("spades","three",16);//its an invalid card added to start loop
        //pile.add(c2);
       // player2score++;
           ///////////
           
          // if(c1.getFaceValue()==c2.getFaceValue()){
          //  player2score++;
        //}
           Scanner userInput=new Scanner(System.in);
           int flag=0;
        while(!(c1.getFaceValue()==c2.getFaceValue()) )//this loop will make players to play until one of them gets same card as on top of pile.
        {
            
           deck1.shuffle(); 
        //System.out.println("Card drown was "+pi
         
        if(deck1.size()>0 )//checks if deck 1 has enough cards to play game
        {
           
        c1=deck1.dealTopCard();
        
        pile.add(c1);
        }
        else//if deck doesnt have cards then method of choosing winner would be second
        {
            System.out.println("no more cards to draw from deck 1 ");
            c1=helperCard(c1.getFaceValue(),c2.getFaceValue());
            
              c2=helperCard(c1.getFaceValue(),c2.getFaceValue());
            //these lines would make too cards the same value which would terminate loop
            
            winnerSelectionMethod=1;
        }
        
        if(c1.getFaceValue()==c2.getFaceValue()){
            player1score++;
        }
        else{
        deck2.shuffle();
        if(deck2.size()>0){
         c2=deck2.dealTopCard();
        pile.add(c2);}
        else{System.out.println("no more cards to draw from deck 2 ");
        
        
         c1=helperCard(c1.getFaceValue(),c2.getFaceValue());
            
              c2=helperCard(c1.getFaceValue(),c2.getFaceValue());
            
            
            winnerSelectionMethod=1;
        
        }
        
        if(c1.getFaceValue()==c2.getFaceValue()){player2score++;}
        deck2.shuffle();}
        //System.out.println("pile has "+pile);
        }//while loop ends for one round of showing cards
        System.out.println();
        System.out.println("pile has "+pile);//print out all the cards in pile
          System.out.println();
            System.out.println();
         System.out.println("score of p1 "+player1score);
         System.out.println("score of p2 "+player2score);
         
         if((player1score>player2score) && ( winnerSelectionMethod==0)){
      //for loop adds all the cards in the pile to deck 1 as it won 
             for(int i=0; i<pile.size();i++){
        deck1.addAdditionalCard(pile.get(i));
         
       }//end of for loop
       p1s++;//it increase the  score of player 1 as it won 1 out of 3 rounds 
       System.out.println(" Player 1 WON , final size of deck 1 is "+deck1.size());
         System.out.println();
           System.out.println();
        }//end of if above
       
        
        if((player2score>player1score) && ( winnerSelectionMethod==0)){
           
       for(int i=0; i<pile.size();i++){
        deck2.addAdditionalCard(pile.get(i));
      
       }//end of for loop
         System.out.println(" Player 2 WON , final size of deck 2 is "+deck2.size());
         p2s++;//it increase the  score of player 2 as it won 2 out of 3 rounds 
           System.out.println();  System.out.println();
       }
        
        
        
       if(( winnerSelectionMethod==1))//if one of the player runs out of card so this would decide the winner of that round by lucky draw method
       {
       
           
           int decider=luckyDraw();//cals luck draw function
           //value of p is set to 5 to terminate the for loop at the top as this lucky draw will decide the final decision of the entire game
           if(decider==0){System.out.println(" Player 1 WON the entire game");p=5; }
       if(decider==1){System.out.println(" Player 2 WON the entire game");p=5;}
       
       }
       
       //once the game is done with two rounds lucky draw helps gain two bonus point.
    if(p==1 && winnerSelectionMethod==0){
        
  int  decider=luckyDraw();//calls lucky draw method.
  // System.out.println(decider);
   if(decider==0){
         System.out.println("************************************************************************");  System.out.println();
       System.out.println(" Player 1 WON the lucky draw , +2 points to him");p1s++;p1s++;
         System.out.println("*************************************************************************");  System.out.println();
   }
   
   
   if(decider==1){
         System.out.println("**************************************************************************");  System.out.println();
       System.out.println(" Player 2 WON the lucky draw , +2 ponts to him");p2s++; p1s++;}
      System.out.println("******************************************************************************");  System.out.println();
    }
       
      
    }//end of for loop for one round
    
       if((p1s>p2s))//if number of scores made by player 1 is greater 
       {  System.out.println();
      System.out.println("Player one won Final  Game by scoring "+p1s+" points");
       System.out.println("Player Two scored "+p2s+" points");
       }
     
     
       if((p2s>p1s))//if number of scores made by player 1 is greater 
       {  System.out.println();
      System.out.println("Player two won Final  Game by scoring "+p2s+" points");
       System.out.println("Player one scored "+p1s+" points");}
       
             }
           catch (NullPointerException nullPointer)
{
   //log(causeStr, nullPointer, System.out);
    System.out.println("There is an Unexpected null pointer Error ");
}

       
       
       
    }
    
    /**
     * 
     * creates a card which is invalid.
     * @param faceValue1 face value of card 1 
     * @param faceValue2 face value of card 2
     * @return an invalid card that can be used to equate the card one and card two to terminate the loop.
     */
    public static Card helperCard(int faceValue1, int faceValue2){
    
    Card helperCard= new Card("spades","three",15);
   return helperCard;
    }
    
    /**
     * Draws a random number from 0 to 1
     * @return an integer which is result of lucky draw.
     */
    public static int luckyDraw(){
    
      SecureRandom random= new SecureRandom();
      int luckyNumber=random.nextInt(1);
      return luckyNumber;
    }
    
    
}
