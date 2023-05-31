public class Ship
{
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int row;
    private int col;
    private int length;
    private int direction;
    // Constructor. Create a ship and set the length.
    public Ship(int length)
    {
        this.length = length;
        this.row = UNSET;
        this.col = UNSET;
        this.direction = UNSET;
    }
    // Has the location been initialized
    public boolean isLocationSet()
    {
        if(row != 0 && col != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // Has the direction been initialized
    public boolean isDirectionSet()
    {
        if(direction != -1)
        {
            return true;
            
        }
        else
        {
            return false;
        }
    }
    // Set the location of the ship 
    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    // Set the direction of the ship
    public void setDirection(int direction)
    {
        this.direction = direction;
    }
    // Getter for the row value
    public int getRow()
    {
        return row;
    }
    // Getter for the column value
    public int getCol()
    {
        return col;
    }
    
    // Getter for the length of the ship
    public int getLength()
    {
        return length;
    }
    // Getter for the direction
    public int getDirection()
    {
        return direction;
    }
    // Helper method to get a string value from the direction
    private String directionToString()
    {
        if(getDirection() == 1)
        {
            return "Vertical";
        }
        else if(getDirection() == 0)
        {
            return "Horizontal";
        }
        else
        {
            return "Unset";
        }
    }
    
    // toString value for this Ship
    public String toString()
    {
        return "Row: " + getRow() + ". Col: " + getCol() + ". Direction: " + directionToString() + ". Length: " + getLength() + ".";
    }
}
