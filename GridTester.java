public class GridTester extends ConsoleProgram
{
    public void run()
    {
        // This code tests out the methods of the Grid class


        // Create vertical ship of length 3 at location (D, 4)        
        Grid grid = new Grid();
        Ship s1 = new Ship(3);
        
        s1.setLocation(2, 2);
        s1.setDirection(1);
        grid.addShip(s1);
        
        // Create hosrizontal ship of length 5 at location (H, 6)        
        Ship s2 = new Ship(5);
        
        s2.setLocation(6, 4);
        s2.setDirection(0);
        grid.addShip(s2);


        // Create horizontal ship of length 3 at location (I, 9)        
        Ship s3 = new Ship(2);
        
        s3.setLocation(8, 8);
        s3.setDirection(0);
        grid.addShip(s3);


        // Create vertical ship of length 3 at location (I, 9)        
        Ship s4 = new Ship(2);
        
        s4.setLocation(8, 8);
        s4.setDirection(1);
        grid.addShip(s4);


        grid.printShips();
    }
}
