import doodlepad.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Tester{
    public static String [] myArray = new String[2502];
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
        //boolean isWord = false;
        //String input = "";
        String inputWord = readFile();
        System.out.print(inputWord);
        //Scanner scan = new Scanner(System.in);
        Pad inScreen = new Pad("Instructions", 1000, 1000);
        Text instructions = new Text("Welcome to Wordle!", 335, 260, 35);
        Text instructions1 = new Text("You have 6 tries to guess a five letter word. Enter your guesses into the terminal.", 55, 400, 25);
        Text instructions2 = new Text("Letter combinations that are not words or are not 5 letters long are not valid inputs.", 45, 460, 25);
        Text instructions3 = new Text("If you did not input a valid word, you will be reprompted to enter your guess.", 80, 520, 25);
        PushButton instructionButton = new PushButton(inputWord);
        //Text instructions4 = new Text("Press enter to continue", 400, 640, 25);
        //Wordle w1 = new Wordle(inputWord);
        /*for(int i = 0; i < 6; i++){
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
        }*/
        
    }
}
class PushButton {
    private RoundRect shpButton;    // Button Shape
    private boolean isOn;           // Button state
    private boolean isWord = false;
    private String input = "";

    public PushButton(String inputWord) {
        // Create button shape and initialize
        shpButton = new RoundRect(345, 610, 300, 50, 20, 20);
        shpButton.setFillColor(200);
        Text instructions4 = new Text("Press here to continue", 370, 625, 25);
        input = inputWord;
        // Starts off
        isOn = false;

        // Set button click event handler method
        //shpButton.setMousePressedHandler( this::onPressed );
        instructions4.setMousePressedHandler( this::onPressed );
    }

    private void onPressed(Shape shp, double x, double y, int button) {
        // Toggle button state
        Scanner scan = new Scanner(System.in);
        isOn = !isOn;
        Tester t1 = new Tester();

        // Set button fill color based on state
        if (isOn) {
            Wordle w1 = new Wordle(input);
            for(int i = 0; i < 6; i++){
            do{
            System.out.println("Enter your guess: ");
            input = scan.nextLine();
            input = input.toLowerCase();
            //System.out.println("BEFORE FOR LOOP"); checking code
            for(int r = 0; r < 2501; r++){
                if(input.equals(t1.myArray[r])){
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
            //shpButton.setFillColor(0, 255, 0);
         else {
            //shpButton.setFillColor(200);
        }
    }

            
    
}

