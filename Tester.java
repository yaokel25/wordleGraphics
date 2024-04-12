import doodlepad.*;
import java.util.Scanner;
public class Tester{
    public static void main(String args[]){
        String input = "";
        Scanner scan = new Scanner(System.in);
        Wordle w1 = new Wordle("fives");
        
        for(int i = 0; i < 5; i++){
            System.out.println("Enter your guess: ");
            input = scan.nextLine();
            w1.checkWord(input);
            if(w1.getCheckString()){
                break;
            }
        }
        if(!w1.getCheckString()){
            System.out.print("You didn't guess it");
        }
        
    }


}