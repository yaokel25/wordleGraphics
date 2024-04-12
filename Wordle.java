import doodlepad.*;

public class Wordle{
    private String key1;
    private boolean checkString = false;
    public Wordle(String key){
        key1 = key;
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