import java.util.ArrayList;
import java.util.Random;
public class TestPuzzle {
    public static void main(String[]args)
    {
       Puzzle game = new Puzzle();
       ArrayList<Integer> randomRolls = game.getTenRolls();
       System.out.println(randomRolls); 
       System.out.println(game.getRandomLetterWithArray());
       System.out.println(game.generatePassword());
       System.out.println(game.getNewPasswordSet(6));
int[] array = {1, 2, 3, 4, 5};
game.shuffleArray(array);
System.out.println(game.shuffleArray(array));
   
    }
}