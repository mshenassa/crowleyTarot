/*
 * This program is designed to perform the calculations for finding one's 
 * Personal Cards in the Tarot Deck according to a method by Aleister
 * Crowley, adapted from the book _The Crowley Tarot: A Handbook to the
 * Cards_ by Akron & Hajo Banzhaf
 */
package crowleytarot;

import java.util.Scanner;
import java.util.Calendar;

public class PersonalCards {
 
 
    public static void main(String[] args) {
      //Create a Scanner
      Scanner input = new Scanner(System.in);
      
      //Create major arcana array
      String[] majorArcana = {
            "The Fool", "The Magus", "The High Priestess", 
            "The Empress", "The Emperor", "The Hierophant", "The Lovers", 
            "The Chariot", "Adjustment", "The Hermit", "Fortune", "Lust",
            "The Hanged Man", "Death", "Art", "The Devil", "The Tower",
            "The Star", "The Moon", "The Sun", "The Aeon", "The Universe"};
      //Explain program
      System.out.print("This program will calculate your Personal Tarot Cards" + 
              "\n according to a method taught and practiced by Aleister " +
              "Crowley\n In the book _The Crowley Tarot: The Handbook to the " +
              "Cards_ by Akron & Hajo Banzhaf, this method is explained thus:" +
              "\n\t From the twenty-two cards of the Major Arcana, you can \n" +
              "\n\t establish wich ones are of particular importance for you. "+
              "\n\t This is a mattor of: " +
              "\n\n\t 1.  The personality card, which makes a statement about" +
              "\n\t\t the appearance, behavior and external effect of the" + 
              "\n\t\t person concerned." +
              "\n\n\t 2. The character card, which illustrates the inner " + 
              "\n\t\t nature of the person asking the question." +
              "\n\n\t 3. The growth card, which changes annually and " +
              "\n\t\t distinguishes the growth theme of the year." +
              "\n\n\t In order to find these cards, three numbers are calculated" + 
              "\n\t The cards of the Major Aracana corresponding to these numbers" +
              "\n\t are the personal cards \n \n We will now determine your " +
              "personal cards \n\n");
      //Prompt user to enter date of birth as mm/dd/yyyy
      System.out.print("Enter your date of birth in the format mm/dd/yyyy: ");
      String dob = input.next();
     
      
      //Parse Strings day, month, and year
      int separatorA = dob.indexOf('/');
      int separatorB = dob.lastIndexOf('/');
      String day = dob.substring(0, separatorA);
      String month = dob.substring(separatorA + 1, separatorB);
      String year = dob.substring(separatorB + 1);
      
      
      //Perform addition of (day + month) + year
      int personalityFirst = ((Integer.parseInt(day) + (Integer.parseInt(month))) + 
              Integer.parseInt(year));
      
      //Separate digits of result for cross addition, perform cross addition
      String persString = String.valueOf(personalityFirst);
      String persStringA = persString.substring(0,1);
      String persStringB = persString.substring(1,2);
      String persStringC = persString.substring(2,3);
      String persStringD = persString.substring(3);
      int personalityFinal = (Integer.parseInt(persStringA) + 
        Integer.parseInt(persStringB) + Integer.parseInt(persStringC) + 
              Integer.parseInt(persStringD));
      //Check for value over 22, if found, perform further cross addition
      if (personalityFinal > 21){
          String persStringE = String.valueOf(personalityFinal);
          String persStringF = persStringE.substring(0,1);
          String persStringG = persStringE.substring(1);
          personalityFinal = (Integer.parseInt(persStringF) + 
                  Integer.parseInt(persStringG));}
          
       //Indicate personality card
      System.out.println("Your personality card is " + 
              majorArcana[personalityFinal]);
      
      //Check for personality card value >10, if found, perform additional cross
      //addition
      int characterFinal;  //declare character integer
      if (personalityFinal > 9){
          String character = String.valueOf(personalityFinal);
          String characterA = character.substring(0,1);
          String characterB = character.substring(1);
          characterFinal = (Integer.parseInt(characterA) + 
                  Integer.parseInt(characterB));}
          else characterFinal = personalityFinal;
      //Indicate character card
      System.out.println("Your character card is " + 
              majorArcana[characterFinal]);
      
       //Calculate growth card by adding dd + mm + current year and performing 
      //cross addition
      int growthFinal = Integer.parseInt(day) + Integer.parseInt(month) + Calendar.getInstance().get(Calendar.YEAR);
      String growthString = String.valueOf(growthFinal);
      String growthStringA = growthString.substring(0,1);
      String growthStringB = growthString.substring(1,2);
      String growthStringC = growthString.substring(2,3);
      String growthStringD = growthString.substring(3);
      growthFinal = (Integer.parseInt(growthStringA) + 
        Integer.parseInt(growthStringB) + Integer.parseInt(growthStringC) + 
              Integer.parseInt(growthStringD));
      //Check for value over 22, if found, perform further cross addition
      if (growthFinal > 21){
          String growthStringE = String.valueOf(growthFinal);
          String growthStringF = growthStringE.substring(0,1);
          String growthStringG = growthStringE.substring(1);
          growthFinal = (Integer.parseInt(growthStringF) + 
                  Integer.parseInt(growthStringG));}
      //indicate growth card
      System.out.println("Your growth card for this year is " + 
              majorArcana[growthFinal]);
     
    }
    
}
