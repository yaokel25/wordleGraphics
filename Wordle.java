import doodlepad.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Wordle extends Pad{
    private String key1;
    private boolean checkString = false;
    public Wordle(String key){
        super("Wordle", 1000, 1000);
        key1 = key;
    }
    
    public void drawVictory(){
        Rectangle backgroundV = new Rectangle(0,0,1000,1000);
        backgroundV.setFillColor(165,227,161);
    }
    public void drawDefeat(){
        Rectangle background1 = new Rectangle(0,0,1000,1000);
        background1.setFillColor(255,0,0);
        Text defeatText = new Text("YOU DIDN'T GUESS IT", 200, 420, 55);
        Text victoryText1 = new Text("WORD: " + key1, 350, 520, 55);
    }
    public void checkWord(String input, int numTry){
        boolean checkLetter = false;
        if(input.equals(key1)){
            drawVictory();
            Text victoryText = new Text("YOU GUESSED IT!", 240, 420, 55);
            Text victoryText1 = new Text(key1, 440, 520, 55);
            System.out.println("You guessed it!");
            checkString = true;
        }
        else{
            for(int i = 0; i < 5; i++){
                if(input.charAt(i) == key1.charAt(i)){
                    System.out.println("Green ");
                    Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
                    box.setFillColor(0,255,0);
                    Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
                }
                else{
                    for(int y = 0; y < 5; y++){
                        if(input.charAt(i) == key1.charAt(y)){
                            checkLetter = true;
                        }
                    }
                    if(checkLetter){
                        System.out.println("Yellow ");
                        Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
                        box.setFillColor(255,190,0);
                        Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
                        checkLetter = false;
                    }
                    else{
                        System.out.println("Red ");
                        Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
                        box.setFillColor(255,0,0);
                        Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
                    }
                }
            }
        }
    }
    
    public boolean getCheckString(){
        return checkString;
    }


}