import doodlepad.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Tester{
    private static String [] myArray = new String[2502];
    public static String readFile(){
        //String [] wordList = new String[2502];
        try {
            File myObj = new File("longlist.txt");
            Scanner myReader = new Scanner(myObj);
            int n = 0;
            while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            myArray = data.split(",");
        } }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        int numWords = myArray.length;
        //System.out.println("numWords: " + numWords);
        int randomWord = 0;
        randomWord = (int)(Math.random()*numWords);
        //System.out.println(randomWord);
        /*for(int t = 0; t < 2502; t++){
            System.out.println(myArray[t]);
        }*/

        return myArray[randomWord];
         
       
    }
    public static void main(String args[]){
        boolean isWord = false;
        String input = "";
        String inputWord = readFile();
        System.out.print(inputWord);
        Scanner scan = new Scanner(System.in);
        Pad inScreen = new Pad("Instructions", 1000, 1000);
        Text instructions = new Text("Welcome to Wordle!", 400, 400, 35);
        Text instructions1 = new Text("You have 6 tries to guess a five letter word. Enter your guesses into the terminal.", 90, 460, 25);
        Text instructions2 = new Text("Letter combinations that are not words or are not 5 letters long are not valid inputs.", 70, 520, 25);
        Text instructions3 = new Text("If you did not input a valid word, you will be reprompted to enter your guess.", 80, 580, 25);
        Text instructions4 = new Text("Press enter to continue", 400, 640, 25);
        Wordle w1 = new Wordle(inputWord);
        for(int i = 0; i < 6; i++){
            do{
            System.out.println("Enter your guess: ");
            input = scan.nextLine();
            input = input.toLowerCase();
            //System.out.println("BEFORE FOR LOOP"); checking code
            for(int r = 0; r < 2501; r++){
                if(input.equals(myArray[r])){
                    //System.out.println("IF STATEMENT"); checking code
                    isWord = true;
                    //System.out.println("TRUE"); checking code
                    break;
                }
                else{
                    isWord = false;
                    //System.out.println("FALSE"); checking code
                }
            }
            }
            while((input.length() != 5) || (isWord == false));
            //System.out.println("WHILE LOOP DONE"); checking code
            w1.checkWord(input, i);
            if(w1.getCheckString()){
                break;
            }
        }
        if(!w1.getCheckString()){
            w1.drawDefeat();
            System.out.print("You didn't guess it");
        }
        
    }
}
