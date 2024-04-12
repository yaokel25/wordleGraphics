import doodlepad.*;

public class Wordle extends Pad{
    private String key1;
    private boolean checkString = false;
    public Wordle(String key){
        super("Wordle", 100, 100);
        key1 = key;
    }
    public void drawVictory(){
        Rectangle background = new Rectangle(0,0,130,130);
        background.setFillColor(165,227,161);
    }
    public void checkWord(String input){
        boolean checkLetter = false;
        if(input.equals(key1)){
            System.out.println("You guessed it!");
            checkString = true;
        }
        else{
            for(int i = 0; i < 5; i++){
                if(input.charAt(i) == key1.charAt(i)){
                    System.out.println("Green ");
                }
                else{
                    for(int y = 0; y < 5; y++){
                        if(input.charAt(i) == key1.charAt(y)){
                            checkLetter = true;
                        }
                    }
                    if(checkLetter){
                        System.out.println("Yellow ");
                    }
                    else{
                        System.out.println("Red ");
                    }
                }
            }
        }
    }
    
    public boolean getCheckString(){
        return checkString;
    }


}