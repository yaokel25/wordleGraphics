import doodlepad.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Tester{
    public static String [] myArray = new String[2502];
    public static String readFile(){
        //String [] wordList = new String[2502];-struggle: originally tried to copy list onto another string
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
        
        int numWords = myArray.length;//getting number of words in longList
        //System.out.println("numWords: " + numWords);
        int randomNum = 0;//declaring and initializing index for random word
        randomNum = (int)(Math.random()*numWords);//picking a random number from 0 to 2502
        //System.out.println(randomWord);
        /*for(int t = 0; t < 2502; t++){
            System.out.println(myArray[t]);
        }*/

        return myArray[randomNum];//returning the word at index randomNum (a random word)
}
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        boolean isWord = false;
        String inputWord = readFile();
        String input = "";
        System.out.print(inputWord); //check code
        Wordle w1 = new Wordle(inputWord);
        w1.drawInstructions();//display instructions
            for(int i = 0; i < 6; i++){
            do{//keep prompting for guesses if the user input is not 5 letter or a word from the longList 
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
            w1.checkWord(input, i);//checks user gues and prints out the guess and colored boxes
            if(w1.getCheckString()){//checks if user guesses the word
                break;//stop the game if user guesses the correct word
            }
        }
        if(!w1.getCheckString()){//if user still has not guesses the word, then draw the defeat screen
            w1.drawDefeat();
            System.out.print("You didn't guess it");
        }
    }
}

