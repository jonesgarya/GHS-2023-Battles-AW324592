public class Battleship extends ConsoleProgram
{
    public void run()
    {
        Player playerOne = new Player("Player");
        Player playerTwo = new Player("Bot");
        // Start here! This class should interact with the user
        // to play the game of Battleship
        playerOne.askShips(playerTwo);
        playerTwo.autoPutShips(playerOne);
        
        while(true)
        {
            askForGuess(playerOne, playerTwo);
            if(playerTwo.noLivesCheck())
            {
                winner(playerOne);
                break;
            }
            botGuess(playerTwo, playerOne);
            if(playerOne.noLivesCheck())
            {
                winner(playerOne);
                break;
            }
            
        }
        
    }
    
    public void askForGuess(Player guesser, Player other)
    {
        String name = guesser.getName();
        println("Your turn to guess, " + name + ". ");
        while(true) //repeat until legal
            {
                guesser.printMyGuesses();
                String guessRow = readLine("Guess a row between A-J. ");
                int guessCol = readInt("Guess a column between 1-10. ");
                
                if(guessRow.length() == 1) //make sure String guessRow is one character long
                {
                    char guessRowChar = guessRow.charAt(0); //convet to char
                    guessRowChar = Character.toUpperCase(guessRowChar); //make it uppercase
                    if(Character.isLetter(guessRowChar)) //make sure its not a number
                    {
                        int guessRowInt = (int) guessRowChar - 65; //convert to int
                        int convertedGCol = guessCol - 1; //convert guessCol to fit the grid build
                        if(guessRowInt > -1 && guessRowInt < 10 && convertedGCol > -1 && convertedGCol < 10) //make sure they are between 0 and 9 (also checks if letter between A-J)
                        {
                            
                            if(guesser.alreadyGuess(guessRowInt, convertedGCol) != true)
                            {       //at this point, guessRow had to be A-J and guessCol between 1-10.
                                    //now we can do a guess and see if it is a hit or miss
                                if(other.checkForHit(guessRowInt, convertedGCol))
                                {
                                    guesser.markHit(guessRowInt, convertedGCol);
                                    println("It was a HIT!");
                                    other.loseALife();
                                }
                                else
                                {
                                    guesser.markMiss(guessRowInt, convertedGCol);
                                    println("It was a MISS!");
                                }
                                break;
                            }
                            
                        }
                    }
                }
                
                String useless = readLine("Something you put would have caused an error. Press Enter to try again.");
            }
            
        
        
        guesser.printMyGuesses();
        String useless2 = readLine("Press Enter to continue.");
    }
    
    public void botGuess(Player guesser, Player other)
    {
        int attemptGuess = 0;
        String name = guesser.getName();
        println("Your turn to guess, " + name + ". ");
        while(true) //repeat until legal
        {
            attemptGuess++;
            int guessRow = Randomizer.nextInt(0, 9);
            int guessCol = Randomizer.nextInt(0, 9);
            
            if(guessRow > -1 && guessRow < 10 && guessCol > -1 && guessCol < 10) //make sure they are between 0 and 9 (also checks if letter between A-J)
            {
                //at this point, guessRow had to be A-J and guessCol between 1-10.
                //now we can do a guess and see if it is a hit or miss
                if(guesser.alreadyGuess(guessRow, guessCol) != true)
                {
                    if(other.checkForHit(guessRow, guessCol))
                    {
                        guesser.markHit(guessRow, guessCol);
                        println("Computer HIT after " + attemptGuess + " attempts.");
                        other.loseALife();
                    }
                    else
                    {
                        guesser.markMiss(guessRow, guessCol);
                        println("Computer MISS after " + attemptGuess + " attempts.");
                    }
                    break; 
                }
                
            }
        }
        
        guesser.printMyGuesses();
        String useless2 = readLine("Press Enter to continue.");
        
    }    
    
    public void winner(Player winner)
    {
        String name = winner.getName();
        println("The winner of battleship is, " + name.toUpperCase() + "!");
    }
    
    
}
