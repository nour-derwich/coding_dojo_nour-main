import java.util.ArrayList;
import java.util.Random;
public class Puzzle{

    public ArrayList<Integer> getTenRolls()
{
    ArrayList<Integer> random10= new  ArrayList<Integer>();
    Random rand = new Random();
    for(int i=0; i<=10 ; i++)
    {
        
      random10.add(rand.nextInt(20)+1);

     }
     return random10;
     }
      public String getRandomLetterWithArray() {
         String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
         Random rand = new Random();
         for(int alf=0; alf<26 ; alf++)
         {
 alphabet[alf] = String.valueOf(alphabetString.charAt(alf));
         }
          return alphabet[rand.nextInt(26)];
      }
      public String getRandomLetterp()
      {
        
        Random rand = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        char randomChar = alphabetString.charAt(rand.nextInt(26));

        return String.valueOf(randomChar);
      }
       public String generatePassword() {

        String password = "";

        for(int i = 0; i < 8; i++) {
            password = password + getRandomLetterp();
        }
        return password;
    }
     public ArrayList<String> getNewPasswordSet(int length) {

        ArrayList<String> passwordSet = new ArrayList<String>();
        for(int i = 0; i < length; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;

    }
    public String shuffleArray(int[] array) {

        Random rand = new Random();
       for (int i = 0; i < array.length; i++) {
        // Generate a random index between i and the end of the array
        int randomIndex = i + rand.nextInt(array.length - i);
        
        // Swap the values at i and the random index
        int temp = array[i];
        array[i] = array[randomIndex];
        array[randomIndex] = temp;
    }
   }
}
      
