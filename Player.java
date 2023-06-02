public class Player extends ConsoleProgram
{
    // Write your Player class here
    // These are the lengths of all of the ships.
    private Grid playerGrid;
    private Grid oppGrid;
    private String name;
    private int lives;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    public Player(String name)
    {
        this.name = name;
        playerGrid = new Grid();
        oppGrid = new Grid();
        lives = 17;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void chooseShipLocation(Ship s, int r, int c, int dir)
    {
        s.setLocation(r, c);
        s.setDirection(dir);
        playerGrid.addShip(s);
    }
    
    public void chooseShipOppLocation(Ship s, int r, int c, int dir)
    {
        s.setLocation(r, c);
        s.setDirection(dir);
        oppGrid.addShip(s);
    }
    
    public boolean checkForHit(int r, int c)
    {
        if(playerGrid.hasShip(r, c))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean alreadyGuess(int r, int c)
    {
        
        return oppGrid.alreadyGuessed(r, c);
        
    }
    
    public void markHit(int r, int c)
    {
        oppGrid.markHit(r, c);
    }
    
    public void markMiss(int r, int c)
    {
        oppGrid.markMiss(r, c);
    }
    
    public void loseALife()
    {
        lives--;
        
    }
    
    public boolean noLivesCheck()
    {
        if(lives > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public void askShips(Player p2)
    {
        String name = getName();
        println("Your turn to place ships, " + name + ". ");
        for (int i = 0; i < SHIP_LENGTHS.length; i++) //repeat code for each Ship
        {
            while(true) //repeat until legal
            {
                playerGrid.printShips();
                String pRow = readLine("Place a ship of length " + SHIP_LENGTHS[i] + " at a row between A-J. ");
                int pCol = readInt("Place a ship of length " + SHIP_LENGTHS[i] + " at a column between 1-10. ");
                String pDir = readLine("Does it face Horizontal or Vertical. ");
                
                if(pRow.length() == 1) //make sure String pRow is one character long
                {
                    char pRowChar = pRow.charAt(0); //convet to char
                    pRowChar = Character.toUpperCase(pRowChar); //make it uppercase
                    if(Character.isLetter(pRowChar)) //make sure its not a number
                    {
                        int pRowInt = (int) pRowChar - 65; //convert to int
                        int convertedCol = pCol - 1; //convert pCol to fit the grid build
                        if(pRowInt > -1 && pRowInt < 10 && convertedCol > -1 && convertedCol < 10) //make sure they are between 0 and 9 (also checks if letter between A-J)
                        {
                            char directionChar = pDir.charAt(0); //first letter of pDir String
                            int direction = 2; //if it stays as 2 theres an error
                            if(directionChar == 'H' || directionChar == 'h') //horizontal
                            {
                                if(convertedCol + SHIP_LENGTHS[i] <= 10) //make sure it fits
                                {
                                    direction = 0;
                                }
                            }
                            if(directionChar == 'V' || directionChar == 'v') //vertical
                            {
                                if(pRowInt + SHIP_LENGTHS[i] <= 10) //make sure it fits
                                {
                                    direction = 1;
                                }
                            }
                            if(direction != 2) 
                            {
                                int fault = 0; //changes to 1 if the ship intersects with another
                                if(direction == 1)
                                {
                                    for (int j = 0; j < SHIP_LENGTHS[i]; j++)
                                    {
                                        
                                        if(playerGrid.hasShip(pRowInt + j, convertedCol))//checks if theres is already a ship
                                        {
                                            fault = 1;
                                        }
                                    }
                                    
                                }
                                else
                                {
                                    for (int j = 0; j < SHIP_LENGTHS[i]; j++)
                                    {
                                        if(playerGrid.hasShip(pRowInt, convertedCol + j))//same as above comment
                                        {
                                            fault = 1;
                                        }
                                    }
                                }
                                if(fault == 0)
                                { //at this point, pRow had to be A-J, pCol between 1-10, and pDir starting with H or V.
                                //now we can place the ships
                                    println("Successfuly placed Ship with length " + SHIP_LENGTHS[i] + " at Row " + pRowInt + ", Column " + convertedCol + ", and Direction " + direction + ".");
                                    chooseShipLocation(new Ship(SHIP_LENGTHS[i]), pRowInt, convertedCol, direction); //puts ship with the info
                                    p2.chooseShipOppLocation(new Ship(SHIP_LENGTHS[i]), pRowInt, convertedCol, direction); //puts ship on other players oppGrid.
                                    break;
                                }
                                
                            }
                        }
                    }
                }
                
                String useless = readLine("Something you put would have caused an error. Press Enter to try again.");
            }
            
        }
        
        playerGrid.printShips();
        String useless2 = readLine("Press Enter to continue.");
    }
    
    public void autoPutShips(Player p2)
    {
        int attempts = 0;
        String name = getName();
        println("Your turn to place ships, " + name + ". ");
        for (int i = 0; i < SHIP_LENGTHS.length; i++) //repeat code for each Ship
        {
            while(true) //repeat until legal
            {
                attempts++;
                int pRow = Randomizer.nextInt(0, 9);
                int pCol = Randomizer.nextInt(0, 9);
                int directionInt = Randomizer.nextInt(0, 1);
                int direction = 2; //if it stays as 2 theres an error
                if(directionInt == 0) //horizontal
                {
                    if(pCol + SHIP_LENGTHS[i] < 10) //make sure it fits
                    {
                        direction = 0;
                    }
                }
                if(directionInt == 1) //vertical
                {
                    if(pRow + SHIP_LENGTHS[i] < 10) //make sure it fits
                    {
                        direction = 1;
                    }
                }
                if(direction != 2) 
                {
                    int fault = 0; //changes to 1 if the ship intersects with another
                    if(direction == 1)
                    {
                        for (int j = 0; j < SHIP_LENGTHS[i]; j++)
                        {
                        
                            if(playerGrid.hasShip(pRow + j, pCol))//checks if theres is already a ship
                            {
                                fault = 1;
                            }
                        }
                        
                    }
                    else
                    {
                        for (int j = 0; j < SHIP_LENGTHS[i]; j++)
                        {
                            if(playerGrid.hasShip(pRow, pCol + j))//same as above comment
                            {
                                fault = 1;
                            }
                        }
                    }
                    if(fault == 0)
                    { //at this point, pRow had to be A-J, pCol between 1-10, and pDir starting with H or V.
                    //now we can place the ships
                        println("Successfuly placed Ship with length " + SHIP_LENGTHS[i] + " in a safe location after " + attempts + " attempts.");
                        chooseShipLocation(new Ship(SHIP_LENGTHS[i]), pRow, pCol, direction); //puts ship with the info
                        p2.chooseShipOppLocation(new Ship(SHIP_LENGTHS[i]), pRow, pCol, direction); //puts ship on other players oppGrid.
                        attempts = 0;
                        break;
                    }
                }
                
                
            }
            
        }
        
        String useless2 = readLine("Press Enter to continue.");
    }
    
    
    public void printMyShips()
    {
        playerGrid.printShips();
    }
    public void printMyGuesses()
    {
        oppGrid.printStatus();
    }
    public void printOpponentGuesses()
    {
        playerGrid.printStatus();
    } 
}
