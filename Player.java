public class Player
{
    // Write your Player class here
    // These are the lengths of all of the ships.
    private Grid playerGrid;
    private Grid oppGrid;
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    public static final String ltr = "ABCDEFGHIJ";
    public Player()
    {
        playerGrid = new Grid();
        oppGrid = new Grid();
    }
    
    public void chooseShipLocation(Ship s, int r, int c, int dir)
    {
        s.setLocation(r, c);
        s.setDirection(dir);
        playerGrid.addShip(s);
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
