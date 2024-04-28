import doodlepad.*;
import java.io.File;
import java.util.Scanner;



import java.io.FileNotFoundException;
public class Wordle extends Pad{
    private String key1;
    private boolean checkString = false;
    private Text instructions;
    private Text instructions1;
    private Text instructions2;
    private Text instructions3;
    private Text instructions4;
    private RoundRect shpButton;
    public Wordle(String key){
        super("Wordle", 1000, 1200);
        key1 = key;
    }
    public void drawInstructions(){
        instructions = new Text("Welcome to Wordle!", 335, 260, 35);
        instructions1 = new Text("You have 6 tries to guess a five letter word. Enter your guesses into the terminal.", 55, 400, 25);
        instructions2 = new Text("Letter combinations that are not words or are not 5 letters long are not valid inputs.", 45, 460, 25);
        instructions3 = new Text("If you did not input a valid word, you will be reprompted to enter your guess.", 80, 520, 25);
        shpButton = new RoundRect(345, 610, 300, 50, 20, 20);
        shpButton.setFillColor(200);
        instructions4 = new Text("Press here to continue", 370, 625, 25);
        instructions4.setMouseClickedHandler( this::hidePiece );
        shpButton.setMouseClickedHandler( this::hidePiece );


    }
    public void hidePiece(Shape shp, double x, double y, int b){
        instructions.setVisible(false);
        instructions1.setVisible(false);
        instructions2.setVisible(false);
        instructions3.setVisible(false);
        instructions4.setVisible(false);
        shpButton.setVisible(false);
        //shp.setVisible(false);
    }
    public void drawVictory(){
        Rectangle backgroundV = new Rectangle(0,0,1000,1200);
        backgroundV.setFillColor(165,227,161);
    }
    public void drawDefeat(){
        Rectangle background1 = new Rectangle(0,0,1000,1200);
        background1.setFillColor(255,0,0);
        Text defeatText = new Text("YOU DIDN'T GUESS IT", 180, 500, 55);
        Text victoryText1 = new Text("WORD: \"" + key1 + "\"", 320, 600, 55);
    }
    public void printRed(String input, int i, int numTry, boolean checkLetter){
        System.out.println("Red ");
        Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
        box.setFillColor(255,0,0);
        Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
        System.out.println("Printed red letter");

    }
    public void printYellow(String input, int i, int numTry, boolean checkLetter){
        System.out.println("Yellow ");
        Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
        box.setFillColor(255,190,0);
        Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
        System.out.println("Printed yellow letter");
        checkLetter = false;

    }
    public void printGreen(String input, int i, int numTry, boolean checkLetter){
        System.out.println("Green ");
        Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
        box.setFillColor(0,255,0);
        Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
        System.out.println("Printed green letter");

    }
    public void checkWord(String input, int numTry){
        boolean checkLetter = false;
        if(input.equals(key1)){
            System.out.println("input = key1");
            drawVictory();
            Text victoryText = new Text("YOU GUESSED IT!", 245, 500, 55);
            Text victoryText1 = new Text("Word: \"" + key1 + "\"", 320, 600, 55);
            System.out.println("You guessed it!");
            checkString = true;
        }
        else{
            System.out.println("Else 1");
            for(int i = 0; i < 5; i++){
                if(input.charAt(i) == key1.charAt(i)){
                   printGreen(input, i, numTry, checkLetter); 
                }
                else{
                    for(int y = 0; y < 5; y++){
                        if(input.charAt(i) == key1.charAt(y)){
                            checkLetter = true;
                        }
                    }
                    if(checkLetter){
                        printYellow(input, i, numTry, checkLetter);
                    }
                    else{
                        printRed(input, i, numTry, checkLetter);
                    }
                }
            }
        }
    }
    
    public boolean getCheckString(){
        return checkString;
    }


}