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
    private int numLetters = 5;
    public Wordle(String key){
        super("Wordle", 1000, 1200);//this pad size only works on pcs it is too big for my macbook air computer screen
        key1 = key;
    }
    public void drawInstructions(){//draw instructions
        instructions = new Text("Welcome to Wordle!", 335, 260, 35);
        instructions1 = new Text("You have 6 tries to guess a five letter word. Enter your guesses into the terminal.", 55, 400, 25);
        instructions2 = new Text("Letter combinations that are not words or are not 5 letters long are not valid inputs.", 45, 460, 25);
        instructions3 = new Text("If you did not input a valid word, you will be reprompted to enter your guess.", 80, 520, 25);
        shpButton = new RoundRect(345, 610, 300, 50, 20, 20);
        shpButton.setFillColor(200);
        instructions4 = new Text("Press here to continue", 370, 625, 25);
        instructions4.setMouseClickedHandler( this::hidePiece );//struggle: originally had this in tester class and then switched it to a button but neither of them worked so I put them in this class so I don't have to worry about static and void methods
        shpButton.setMouseClickedHandler( this::hidePiece );//struggle: originally did not have this but realized that both button and text have to to have to for it to work


    }
    public void hidePiece(Shape shp, double x, double y, int b){//method to hide instructions after button is clicked
        instructions.setVisible(false);
        instructions1.setVisible(false);
        instructions2.setVisible(false);
        instructions3.setVisible(false);
        instructions4.setVisible(false);
        shpButton.setVisible(false);
        //shp.setVisible(false);-original code that only hid the button that is being pressed
    }
    public void drawVictory(){//drawing screen is user currectly guesses word
        Rectangle backgroundV = new Rectangle(0,0,1000,1200);
        backgroundV.setFillColor(165,227,161);
    }
    public void drawDefeat(){//draws screen if user does not guess the word within 6 guesses
        Rectangle background1 = new Rectangle(0,0,1000,1200);
        background1.setFillColor(255,0,0);
        Text defeatText = new Text("YOU DIDN'T GUESS IT", 180, 500, 55);
        Text victoryText1 = new Text("WORD: \"" + key1 + "\"", 320, 600, 55);
    }
    public void printRed(String input, int i, int numTry, boolean checkLetter){//prints letter and a red square if user guesses a letter that is not in the word, used in checkWord method
        System.out.println("Red ");
        Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
        box.setFillColor(255,0,0);
        Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
        System.out.println("Printed red letter");

    }
    public void printYellow(String input, int i, int numTry, boolean checkLetter){//prints a yellow box and the letter if user guesses the right letter but in the wrong position, used in checkWord method
        System.out.println("Yellow ");
        Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
        box.setFillColor(255,190,0);
        Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
        System.out.println("Printed yellow letter");
        checkLetter = false;

    }
    public void printGreen(String input, int i, int numTry, boolean checkLetter){//prints green box and the letter if user guesses right letter in the right position, used in checkWord method
        System.out.println("Green ");
        Rectangle box = new Rectangle(i*200, numTry*200, 200, 200);
        box.setFillColor(0,255,0);
        Text letter1 = new Text(String.valueOf(input.charAt(i)), i*200 + 75, numTry*200 + 75, 100);
        System.out.println("Printed green letter");

    }
    public void checkWord(String input, int numTry){//takes the user's guesses as input and checks every letter and prints out letter and a colored box if it is right, wrong position, or wrong
        boolean checkLetter = false;
        if(input.equals(key1)){//if input equals the word
            System.out.println("input = key1");
            drawVictory();
            Text victoryText = new Text("YOU GUESSED IT!", 245, 500, 55);
            Text victoryText1 = new Text("Word: \"" + key1 + "\"", 320, 600, 55);
            System.out.println("You guessed it!");
            checkString = true;
        }
        else{
            //System.out.println("Else 1");-check code
            for(int i = 0; i < numLetters; i++){//iterates through all letter in word
                if(input.charAt(i) == key1.charAt(i)){//if it is the right letter in the right position
                   printGreen(input, i, numTry, checkLetter); //print green box and letter
                }
                else{
                    for(int y = 0; y < numLetters; y++){//if it is the right letter but wrong box, then checkLetter is true
                        if(input.charAt(i) == key1.charAt(y)){
                            checkLetter = true;
                        }
                    }
                    if(checkLetter){
                        printYellow(input, i, numTry, checkLetter);//prints yellow box and letter
                    }
                    else{
                        printRed(input, i, numTry, checkLetter);//otherwise, print red box and letter
                    }
                }
            }
        }
    }
    
    public boolean getCheckString(){//return true if user guess is correct, false if it is wrong
        return checkString;
    }


}