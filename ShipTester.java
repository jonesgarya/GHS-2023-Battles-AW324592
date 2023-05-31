public class ShipTester extends ConsoleProgram
{
    public void run()
    {
        Ship ship = new Ship(4);
        ship.setLocation(5, 9);
        ship.setDirection(1);
        println(ship);
    }
}
