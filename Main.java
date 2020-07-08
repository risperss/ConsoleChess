import java.io.IOException;

/*
    Gaetano Rispoli
    ICS3U Culminating Project
    Chess. No modifications to the rules.
*/
public class Main
{
    public static void main(String[] args) throws IOException
    {
        /*
        FULLY COMPLETE TEXT VERSION
        1800 LINES
        PLAY HUMAN VS COMPUTER
        */        

        Player whitePlayer = new HumanPlayer(Color.WHITE);
        Player blackPlayer = new CPUPlayer(Color.BLACK);
                
        Game game = new Game(whitePlayer, blackPlayer);       
        game.play();                        
    }
}

