
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class describes a card
 * @author Gurjeet Sandhu
 * @since june 1,2017
 * @version 1.0
 */
public class Card {
    //instance variables
   private String suit;
   private String faceName;
   private int faceValue;
   //they belong to class , every object can use it . but it stays on one memory location and all objects point them ..but dont copy them every time
    private static final int MINIMUM_FACE_VALUE=2;
    private static final int MAXIMUM_FACE_VALUE=16;//it should be 14 but we some time need invalid cards so to have invalid cards 
    private static final String[] FACES={"two","three","four","five","six","seven","eight","nine","ten","jack","queen","king","ace"};
    /**
     * This a method constructs a card object
     * @param suit a string the suit of cards 
     * @param faceValue a string to set face name of the card 
     * 
     */
    
    public Card(String suit, String faceName, int facevalue){
    setSuit(suit);
    setFaceName(faceName);
     setFaceValue(facevalue);
    }

    /**
     *
     * @param suit 
     * @throws illegalArgumentException if suit is invalid
     */
    public void setSuit(String suit) {
        
        //check if suit is valid
        if(suit.equalsIgnoreCase("spades")
            || suit.equalsIgnoreCase("diamonds")
                 || suit.equalsIgnoreCase("hearts")
                 || suit.equalsIgnoreCase("clubs"))
        {
        this.suit = suit.toLowerCase();
        }
        else{
         throw new IllegalArgumentException("Suit value is inValid");
        }
    }

    public void setFaceName(String faceName) {
        //if face name is valid
        //binary search is case sensitive
        Arrays.sort(FACES);//sorts the faces array 
        if(Arrays.binarySearch(FACES, faceName.toLowerCase())>=0){
        this.faceName = faceName;}
        else{
            throw new IllegalArgumentException("face is in invalid ");
        
        }
    }

     /**
     *
     * @param faceValue is  some thing i forgat
     * @throws illegalArgumentException if facevalue is invalid
     */
    public void setFaceValue(int faceValue) {
        if(faceValue>= MINIMUM_FACE_VALUE && faceValue<= MAXIMUM_FACE_VALUE){
        this.faceValue = faceValue;}
        else{
        throw new IllegalArgumentException("face Value value is inValid.It must lie between "+MINIMUM_FACE_VALUE+"and"+MAXIMUM_FACE_VALUE);
        }
    }

    public String getSuit() {
        return suit;
    }
    /**
     * 
     * @return the face name amount  
     */

    public String getFaceName() {
        return faceName;
    }
/**
 * 
 * This method retuens value
 * @return 
 */
    public int getFaceValue() {
        return faceValue;
    }
    
    /**
     * 
     * this method over rides the tostring method
     * @return the card information
     */
    @Override
    public String toString()
    {
        return getFaceName()+" of " +getSuit();
    }
    
}//end of class
